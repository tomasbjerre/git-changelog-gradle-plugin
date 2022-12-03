package se.bjurr.gitchangelog.plugin.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class GitChangelogGradlePlugin implements Plugin<Project> {
  @Override
  public void apply(final Project target) {
    target.getExtensions().create("gitChangelogPlugin", GitChangelogPluginExtension.class);

    target.getTasks().create("gitChangelogSemanticVersion", GitChangelogSemanticVersionTask.class);

    final GitChangelogTask gitChangelogTask =
        target.getTasks().create("gitChangelog", GitChangelogTask.class);
    gitChangelogTask.file = target.getRootProject().file("CHANGELOG.md");
    gitChangelogTask.ignoreCommitsIfMessageMatches = "^\\[maven-release-plugin\\].*|^\\[Gradle Release Plugin\\].*|^Merge.*|.*\\[GRADLE SCRIPT\\].*";
  }
}
