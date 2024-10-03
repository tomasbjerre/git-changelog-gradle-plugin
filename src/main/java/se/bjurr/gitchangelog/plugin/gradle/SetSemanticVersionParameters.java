package se.bjurr.gitchangelog.plugin.gradle;

import org.gradle.api.Project;

/** */
public class SetSemanticVersionParameters {
  public Boolean suffixSnapshot = false;
  public Boolean suffixSnapshotIfNotTagged = true;
  public String majorVersionPattern;
  public String minorVersionPattern;
  public String patchVersionPattern;
  public String ignoreTagsIfNameMatches;
  public Project project;

  @Override
  public String toString() {
    return "SetSemanticVersionParameters [suffixSnapshot="
        + this.suffixSnapshot
        + ", suffixSnapshotIfNotTagged="
        + this.suffixSnapshotIfNotTagged
        + ", majorVersionPattern="
        + this.majorVersionPattern
        + ", minorVersionPattern="
        + this.minorVersionPattern
        + ", patchVersionPattern="
        + this.patchVersionPattern
        + ", ignoreTagsIfNameMatches="
        + this.ignoreTagsIfNameMatches
        + ", project="
        + this.project
        + "]";
  }
}
