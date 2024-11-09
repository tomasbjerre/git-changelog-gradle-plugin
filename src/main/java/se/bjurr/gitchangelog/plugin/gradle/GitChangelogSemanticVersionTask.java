package se.bjurr.gitchangelog.plugin.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.TaskAction;

public class GitChangelogSemanticVersionTask extends DefaultTask {

  public Property<Boolean> suffixSnapshot =
      this.getProject().getObjects().property(Boolean.class).convention(false);
  public Property<Boolean> suffixSnapshotIfNotTagged =
      this.getProject().getObjects().property(Boolean.class).convention(true);
  public Property<String> majorVersionPattern =
      this.getProject().getObjects().property(String.class).convention("");
  public Property<String> minorVersionPattern =
      this.getProject().getObjects().property(String.class).convention("");
  public Property<String> patchVersionPattern =
      this.getProject().getObjects().property(String.class).convention("");
  public Property<String> ignoreTagsIfNameMatches =
      this.getProject().getObjects().property(String.class).convention("");

  @TaskAction
  public void gitChangelogPluginTasks() {
    final SetSemanticVersionParameters params = new SetSemanticVersionParameters();
    params.suffixSnapshot = this.suffixSnapshot.get();
    params.suffixSnapshotIfNotTagged = this.suffixSnapshotIfNotTagged.get();
    params.majorVersionPattern = this.majorVersionPattern.get();
    params.minorVersionPattern = this.minorVersionPattern.get();
    params.patchVersionPattern = this.patchVersionPattern.get();
    params.ignoreTagsIfNameMatches = this.ignoreTagsIfNameMatches.get();
    params.project = this.getProject();
    SetSemanticVersion.setVersion(params);
  }
}
