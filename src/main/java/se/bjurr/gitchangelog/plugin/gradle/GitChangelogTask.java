package se.bjurr.gitchangelog.plugin.gradle;

import static se.bjurr.gitchangelog.api.GitChangelogApi.gitChangelogApiBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import org.gradle.api.DefaultTask;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.TaskAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.bjurr.gitchangelog.api.GitChangelogApi;
import se.bjurr.gitchangelog.api.InclusivenessStrategy;

public class GitChangelogTask extends DefaultTask {

  private static final Logger log = LoggerFactory.getLogger(GitChangelogTask.class.getName());

  public Property<String> fromRepo =
      this.getProject()
          .getObjects()
          .property(String.class)
          .convention(this.getProject().getRootProject().getRootDir().getAbsolutePath());

  public Property<String> toRevision = this.getProject().getObjects().property(String.class);
  public Property<InclusivenessStrategy> toRevisionStrategy =
      this.getProject()
          .getObjects()
          .property(InclusivenessStrategy.class)
          .convention(InclusivenessStrategy.DEFAULT);

  public Property<String> fromRevision = this.getProject().getObjects().property(String.class);
  public Property<InclusivenessStrategy> fromRevisionStrategy =
      this.getProject()
          .getObjects()
          .property(InclusivenessStrategy.class)
          .convention(InclusivenessStrategy.DEFAULT);

  public Property<String> settingsFile = this.getProject().getObjects().property(String.class);
  public Property<String> templateBaseDir = this.getProject().getObjects().property(String.class);
  public Property<String> templateContent = this.getProject().getObjects().property(String.class);
  public Property<String> templateSuffix = this.getProject().getObjects().property(String.class);
  public Property<File> file =
      this.getProject()
          .getObjects()
          .property(File.class)
          .convention(this.getProject().file("CHANGELOG.md"));

  public Property<String> readableTagName = this.getProject().getObjects().property(String.class);
  public Property<String> dateFormat = this.getProject().getObjects().property(String.class);
  public Property<String> timeZone = this.getProject().getObjects().property(String.class);
  public Property<Boolean> removeIssueFromMessage =
      this.getProject().getObjects().property(Boolean.class);
  public Property<String> ignoreCommitsIfMessageMatches =
      this.getProject().getObjects().property(String.class);
  public Property<String> untaggedName = this.getProject().getObjects().property(String.class);
  public Property<String> noIssueName = this.getProject().getObjects().property(String.class);
  public Property<Boolean> ignoreCommitsWithoutIssue =
      this.getProject().getObjects().property(Boolean.class);
  public Property<String> ignoreTagsIfNameMatches =
      this.getProject().getObjects().property(String.class);

  public ListProperty<CustomIssue> customIssues =
      this.getProject()
          .getObjects()
          .listProperty(CustomIssue.class)
          .convention(new ArrayList<CustomIssue>());

  public Property<Boolean> gitHubEnabled =
      this.getProject().getObjects().property(Boolean.class).convention(false);
  public Property<String> gitHubApi = this.getProject().getObjects().property(String.class);
  public Property<String> gitHubToken = this.getProject().getObjects().property(String.class);
  public Property<String> gitHubIssuePattern =
      this.getProject().getObjects().property(String.class);

  public Property<Boolean> jiraEnabled =
      this.getProject().getObjects().property(Boolean.class).convention(false);
  public Property<String> jiraUsername = this.getProject().getObjects().property(String.class);
  public Property<String> jiraPassword = this.getProject().getObjects().property(String.class);
  public Property<String> jiraIssuePattern = this.getProject().getObjects().property(String.class);
  public Property<String> jiraServer = this.getProject().getObjects().property(String.class);

  public Property<Boolean> gitLabEnabled =
      this.getProject().getObjects().property(Boolean.class).convention(false);
  public Property<String> gitLabServer = this.getProject().getObjects().property(String.class);
  public Property<String> gitLabProjectName = this.getProject().getObjects().property(String.class);
  public Property<String> gitLabToken = this.getProject().getObjects().property(String.class);

  public Property<Date> ignoreCommitsOlderThan =
      this.getProject().getObjects().property(Date.class);
  public ListProperty<HelperParam> handlebarsHelpers =
      this.getProject()
          .getObjects()
          .listProperty(HelperParam.class)
          .convention(new ArrayList<HelperParam>());

  public Property<Boolean> useIntegrations =
      this.getProject().getObjects().property(Boolean.class).convention(false);
  public Property<Boolean> prependToFile =
      this.getProject().getObjects().property(Boolean.class).convention(false);

  public CustomIssue customIssue() {
    final CustomIssue customIssue = new CustomIssue();
    this.customIssues.add(customIssue);
    return customIssue;
  }

  @TaskAction
  public void gitChangelogPluginTasks() {
    try {
      this.getProject().getExtensions().findByType(GitChangelogPluginExtension.class);

      final GitChangelogApi builder =
          gitChangelogApiBuilder()
              .withUseIntegrations(this.useIntegrations.get())
              .withJiraEnabled(this.jiraEnabled.get())
              .withGitLabEnabled(this.gitLabEnabled.get())
              .withGitHubEnabled(this.gitHubEnabled.get());

      for (final HelperParam helper : this.handlebarsHelpers.get()) {
        builder //
            .withHandlebarsHelper(helper.getName(), helper.getHelper());
      }

      if (this.settingsFile.isPresent()) {
        builder.withSettings(this.getProject().file(this.settingsFile).toURI().toURL());
      }

      builder.withFromRepo(this.fromRepo.get());

      if (this.fromRevision.isPresent()) {
        builder.withFromRevision(this.fromRevision.get(), this.fromRevisionStrategy.get());
      }

      if (this.toRevision.isPresent()) {
        builder.withToRevision(this.toRevision.get(), this.toRevisionStrategy.get());
      }

      if (this.templateBaseDir.isPresent()) {
        builder.withTemplateBaseDir(this.templateBaseDir.get());
      }
      if (this.templateContent.isPresent()) {
        builder.withTemplateContent(this.templateContent.get());
      }
      if (this.templateSuffix.isPresent()) {
        builder.withTemplateSuffix(this.templateSuffix.get());
      }

      if (this.ignoreTagsIfNameMatches.isPresent()) {
        builder.withIgnoreTagsIfNameMatches(this.ignoreTagsIfNameMatches.get());
      }
      if (this.readableTagName.isPresent()) {
        builder.withReadableTagName(this.readableTagName.get());
      }
      if (this.dateFormat.isPresent()) {
        builder.withDateFormat(this.dateFormat.get());
      }
      if (this.timeZone.isPresent()) {
        builder.withTimeZone(this.timeZone.get());
      }
      builder.withRemoveIssueFromMessageArgument(this.removeIssueFromMessage.get());
      if (this.ignoreCommitsIfMessageMatches.isPresent()) {
        builder.withIgnoreCommitsWithMessage(this.ignoreCommitsIfMessageMatches.get());
      }
      if (this.ignoreCommitsOlderThan.isPresent()) {
        builder.withIgnoreCommitsOlderThan(this.ignoreCommitsOlderThan.get());
      }
      if (this.untaggedName.isPresent()) {
        builder.withUntaggedName(this.untaggedName.get());
      }
      if (this.noIssueName.isPresent()) {
        builder.withNoIssueName(this.noIssueName.get());
      }

      builder.withIgnoreCommitsWithoutIssue(this.ignoreCommitsWithoutIssue.get());
      for (final CustomIssue customIssue : this.customIssues.get()) {
        final String name = customIssue.getName();
        final String pattern = customIssue.getPattern();
        final String link = customIssue.getLink();
        final String title = customIssue.getTitle();
        builder.withCustomIssue(name, pattern, link, title);
      }
      if (this.gitHubApi.isPresent()) {
        builder.withGitHubApi(this.gitHubApi.get());
      }
      if (this.gitHubToken.isPresent()) {
        builder.withGitHubToken(this.gitHubToken.get());
      }
      if (this.gitHubIssuePattern.isPresent()) {
        builder.withGitHubIssuePattern(this.gitHubIssuePattern.get());
      }

      if (this.gitLabProjectName.isPresent()) {
        builder.withGitLabProjectName(this.gitLabProjectName.get());
      }
      if (this.gitLabServer.isPresent()) {
        builder.withGitLabServer(this.gitLabServer.get());
      }
      if (this.gitLabToken.isPresent()) {
        builder.withGitLabToken(this.gitLabToken.get());
      }

      if (this.jiraUsername.isPresent()) {
        builder.withJiraUsername(this.jiraUsername.get());
      }
      if (this.jiraPassword.isPresent()) {
        builder.withJiraPassword(this.jiraPassword.get());
      }
      if (this.jiraIssuePattern.isPresent()) {
        builder.withJiraIssuePattern(this.jiraIssuePattern.get());
      }
      if (this.jiraServer.isPresent()) {
        builder.withJiraServer(this.jiraServer.get());
      }

      if (this.file.isPresent()) {
        if (this.prependToFile.get()) {
          builder.prependToFile(this.file.get());
        } else {
          builder.toFile(this.file.get());
        }
        log.info("#");
        log.info("# Wrote: " + this.file + " to: " + this.file.get().getCanonicalFile().toPath());
        log.info("#");
      }

    } catch (final Exception e) {
      log.error("GitChangelog", e);
    }
  }
}
