package se.bjurr.gitchangelog.plugin.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class GitChangelogSemanticVersionTask extends DefaultTask {

  public Boolean suffixSnapshot = false;
  public Boolean suffixSnapshotIfNotTagged = true;
  public String majorVersionPattern;
  public String minorVersionPattern;
  public String patchVersionPattern;
  public String ignoreTagsIfNameMatches;

  @TaskAction
  public void gitChangelogPluginTasks() {
    final SetSemanticVersionParameters params = new SetSemanticVersionParameters();
    params.suffixSnapshot = this.suffixSnapshot;
    params.suffixSnapshotIfNotTagged = this.suffixSnapshotIfNotTagged;
    params.majorVersionPattern = this.majorVersionPattern;
    params.minorVersionPattern = this.minorVersionPattern;
    params.patchVersionPattern = this.patchVersionPattern;
    params.ignoreTagsIfNameMatches = this.ignoreTagsIfNameMatches;
    params.project = this.getProject();
    SetSemanticVersion.setVersion(params);
  }
}
