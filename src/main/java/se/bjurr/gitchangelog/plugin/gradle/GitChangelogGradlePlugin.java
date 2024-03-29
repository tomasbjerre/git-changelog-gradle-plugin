package se.bjurr.gitchangelog.plugin.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class GitChangelogGradlePlugin implements Plugin<Project> {
  @Override
  public void apply(final Project target) {
    target.getExtensions().create("gitChangelogPlugin", GitChangelogPluginExtension.class);

    target
        .getTasks()
        .register(
            "gitChangelogSemanticVersion",
            GitChangelogSemanticVersionTask.class,
            task -> {
              task.setDescription("Set version in gradle.properties from conventional commits.");
              task.setGroup("Git Changelog");
            });

    target
        .getTasks()
        .register(
            "gitChangelog",
            GitChangelogTask.class,
            task -> {
              task.setDescription("Update CHANGELOG.md using conventional commits.");
              task.setGroup("Git Changelog");
              task.ignoreCommitsIfMessageMatches =
                  "^\\[maven-release-plugin\\].*|^\\[Gradle Release Plugin\\].*|^Merge.*|.*\\[GRADLE SCRIPT\\].*";
            });
  }
}
