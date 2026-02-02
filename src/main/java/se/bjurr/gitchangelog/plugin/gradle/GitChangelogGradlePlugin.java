package se.bjurr.gitchangelog.plugin.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.ExtraPropertiesExtension;

public class GitChangelogGradlePlugin implements Plugin<Project> {

  @Override
  public void apply(final Project target) {
    final String setVersionConventional = this.getOrElse(target, "setVersionConventional", "false");
    if (setVersionConventional != null && setVersionConventional.equals("true")) {
      SetSemanticVersion.setVersion(
          this.getSemanticVersionParamsFromProperties(target.getProject()));
    }

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
              task.ignoreCommitsIfMessageMatches.set(
                  "^\\[maven-release-plugin\\].*|^\\[Gradle Release Plugin\\].*|^Merge.*|.*\\[GRADLE SCRIPT\\].*");
            });
  }

  private SetSemanticVersionParameters getSemanticVersionParamsFromProperties(
      final Project project) {

    final SetSemanticVersionParameters params = new SetSemanticVersionParameters();
    params.suffixSnapshot = this.getOrElse(project, "suffixSnapshot", false);
    params.suffixSnapshotIfNotTagged = this.getOrElse(project, "suffixSnapshotIfNotTagged", true);
    params.majorVersionPattern = this.getOrElse(project, "majorVersionPattern", null);
    params.minorVersionPattern = this.getOrElse(project, "minorVersionPattern", null);
    params.patchVersionPattern = this.getOrElse(project, "patchVersionPattern", null);
    params.ignoreTagsIfNameMatches = this.getOrElse(project, "ignoreTagsIfNameMatches", null);
    params.project = project;
    return params;
  }

  private String getOrElse(final Project project, final String key, final String defaul) {
    ExtraPropertiesExtension extraProperties = project.getExtensions().getExtraProperties();
    Object valueOpt = extraProperties.has(key) ? extraProperties.get(key) : null;
    project.getLogger().info("Got '" + valueOpt + "' from extraProperties key '" + key + "'");
    if (valueOpt == null) {
      valueOpt = project.getProviders().gradleProperty(key).getOrNull();
      project.getLogger().info("Got '" + valueOpt + "' from properties key '" + key + "'");
    }
    if (valueOpt == null) {
      project.getLogger().info("Using default '" + defaul + "' for key '" + key + "'");
      return defaul;
    }
    project.getLogger().info("Using '" + valueOpt + "' for key '" + key + "'");
    return valueOpt.toString();
  }

  private Boolean getOrElse(final Project project, final String key, final boolean defaul) {
    final String value = this.getOrElse(project, key, Boolean.toString(defaul));
    return Boolean.valueOf(value);
  }
}
