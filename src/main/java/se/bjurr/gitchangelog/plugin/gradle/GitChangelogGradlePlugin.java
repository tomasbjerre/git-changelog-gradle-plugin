package se.bjurr.gitchangelog.plugin.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class GitChangelogGradlePlugin implements Plugin<Project> {
  @Override
  public void apply(Project target) {
    target.getExtensions().create("gitChangelogPlugin", GitChangelogPluginExtension.class);
  }
}
