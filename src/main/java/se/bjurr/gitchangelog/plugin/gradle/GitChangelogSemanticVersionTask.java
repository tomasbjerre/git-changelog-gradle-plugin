package se.bjurr.gitchangelog.plugin.gradle;

import static se.bjurr.gitchangelog.api.GitChangelogApi.gitChangelogApiBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.TaskExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.bjurr.gitchangelog.api.GitChangelogApi;
import se.bjurr.gitchangelog.internal.semantic.SemanticVersion;

public class GitChangelogSemanticVersionTask extends DefaultTask {

  private static final Logger log =
      LoggerFactory.getLogger(GitChangelogSemanticVersionTask.class.getName());

  public Boolean suffixSnapshot = true;
  public String majorVersionPattern;
  public String minorVersionPattern;
  public String patchVersionPattern;

  @TaskAction
  public void gitChangelogPluginTasks() throws TaskExecutionException {
    try {
      final GitChangelogApi gitChangelogApiBuilder = gitChangelogApiBuilder();
      gitChangelogApiBuilder.withFromRepo(this.getProject().getRootDir());
      if (this.isSupplied(this.majorVersionPattern)) {
        gitChangelogApiBuilder.withSemanticMajorVersionPattern(this.majorVersionPattern);
      }
      if (this.isSupplied(this.minorVersionPattern)) {
        gitChangelogApiBuilder.withSemanticMinorVersionPattern(this.minorVersionPattern);
      }
      if (this.isSupplied(this.patchVersionPattern)) {
        gitChangelogApiBuilder.withSemanticPatchVersionPattern(this.patchVersionPattern);
      }

      final SemanticVersion nextSemanticVersion = gitChangelogApiBuilder.getNextSemanticVersion();
      final String nextVersion =
          this.isSuppliedAndTrue(this.suffixSnapshot)
              ? nextSemanticVersion.getVersion() + "-SNAPSHOT"
              : nextSemanticVersion.getVersion();
      final File propertyFile = this.getProject().getRootProject().file("gradle.properties");
      final Properties gradleProps = new Properties();
      gradleProps.load(new FileInputStream(propertyFile));
      final String currentVersion = gradleProps.getProperty("version");
      if (nextVersion.equals(currentVersion)) {
        this.getProject()
            .getLogger()
            .info("Leaving semantic version " + currentVersion + " unchanged.");
      } else {
        this.getProject()
            .getLogger()
            .lifecycle(
                "Setting semantic version to "
                    + nextVersion
                    + " was "
                    + currentVersion
                    + ". Storing in "
                    + propertyFile);
        gradleProps.setProperty("version", nextVersion);
        gradleProps.store(new FileOutputStream(propertyFile), "");
        this.getProject().setVersion(nextVersion);
      }
    } catch (final Exception e) {
      log.error("GitChangelogVersion", e);
    }
  }

  private boolean isSuppliedAndTrue(final Boolean param) {
    return param != null && param;
  }

  private boolean isSupplied(final String param) {
    return param != null && !param.isEmpty();
  }
}
