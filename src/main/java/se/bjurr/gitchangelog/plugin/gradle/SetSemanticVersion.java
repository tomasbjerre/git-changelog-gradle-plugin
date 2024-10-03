package se.bjurr.gitchangelog.plugin.gradle;

import static se.bjurr.gitchangelog.api.GitChangelogApi.gitChangelogApiBuilder;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import se.bjurr.gitchangelog.api.GitChangelogApi;
import se.bjurr.gitchangelog.internal.semantic.SemanticVersion;

public class SetSemanticVersion {

  public static void setVersion(final SetSemanticVersionParameters params) {
    try {
      final GitChangelogApi gitChangelogApiBuilder = gitChangelogApiBuilder();
      gitChangelogApiBuilder.withFromRepo(params.project.getRootDir());
      if (isSupplied(params.majorVersionPattern)) {
        gitChangelogApiBuilder.withSemanticMajorVersionPattern(params.majorVersionPattern);
      }
      if (isSupplied(params.minorVersionPattern)) {
        gitChangelogApiBuilder.withSemanticMinorVersionPattern(params.minorVersionPattern);
      }
      if (isSupplied(params.patchVersionPattern)) {
        gitChangelogApiBuilder.withSemanticPatchVersionPattern(params.patchVersionPattern);
      }
      if (isSupplied(params.ignoreTagsIfNameMatches)) {
        gitChangelogApiBuilder.withIgnoreTagsIfNameMatches(params.ignoreTagsIfNameMatches);
      }

      final SemanticVersion nextSemanticVersion =
          gitChangelogApiBuilder.getCurrentSemanticVersion();
      final boolean notTagged = nextSemanticVersion.findTag().isEmpty();
      final boolean suffixWithSnapshot =
          isSuppliedAndTrue(params.suffixSnapshot)
              || isSuppliedAndTrue(params.suffixSnapshotIfNotTagged) && notTagged;
      final String nextVersion =
          suffixWithSnapshot
              ? nextSemanticVersion.getVersion() + "-SNAPSHOT"
              : nextSemanticVersion.getVersion();

      // Update properties file
      final File propertyFile = params.project.getRootProject().file("gradle.properties");
      final SortedProperties gradleProps = new SortedProperties();
      try (InputStream is = Files.newInputStream(propertyFile.toPath())) {
        gradleProps.load(is);
      }
      final String currentVersion = gradleProps.getProperty("version");
      if (nextVersion.equals(currentVersion)) {
        params
            .project
            .getLogger()
            .info("Leaving semantic version " + currentVersion + " unchanged.");
      } else {
        params
            .project
            .getLogger()
            .lifecycle(
                "Setting semantic version to "
                    + nextVersion
                    + " (was "
                    + currentVersion
                    + "). Storing in "
                    + propertyFile);
        gradleProps.setProperty("version", nextVersion);
        try (OutputStream os = Files.newOutputStream(propertyFile.toPath())) {
          gradleProps.store(os, "");
        }
        params.project.setVersion(nextVersion);
        params
            .project
            .getAllprojects()
            .forEach(
                (p) -> {
                  p.setVersion(nextVersion);
                });
      }
    } catch (final Exception e) {
      params.project.getLogger().error("GitChangelogVersion", e);
    }
  }

  public static boolean isSuppliedAndTrue(final Boolean param) {
    return param != null && param;
  }

  public static boolean isSupplied(final String param) {
    return param != null && !param.isEmpty();
  }
}
