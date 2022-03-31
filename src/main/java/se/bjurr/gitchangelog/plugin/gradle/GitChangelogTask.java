package se.bjurr.gitchangelog.plugin.gradle;

import static se.bjurr.gitchangelog.api.GitChangelogApi.gitChangelogApiBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.TaskExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.bjurr.gitchangelog.api.GitChangelogApi;

public class GitChangelogTask extends DefaultTask {

  private static final Logger log = LoggerFactory.getLogger(DefaultTask.class.getName());

  public String fromRepo;

  public String toRef;
  public String toCommit;

  public String fromRef;
  public String fromCommit;

  public String settingsFile;
  public String templateContent;
  public File file;

  public String readableTagName;
  public String dateFormat;
  public String timeZone;
  public boolean removeIssueFromMessage;
  public String ignoreCommitsIfMessageMatches;
  public String untaggedName;
  public String noIssueName;
  public boolean ignoreCommitsWithoutIssue;
  public String ignoreTagsIfNameMatches;

  public List<List<String>> customIssues = new ArrayList<>();

  public boolean gitHubEnabled;
  public String gitHubApi;
  public String gitHubToken;
  public String gitHubIssuePattern;

  public boolean jiraEnabled;
  public String jiraUsername;
  public String jiraPassword;
  public String jiraIssuePattern;
  public String jiraServer;

  public boolean gitLabEnabled;
  public String gitLabServer;
  public String gitLabProjectName;
  public String gitLabToken;

  public Date ignoreCommitsOlderThan;
  public List<HelperParam> handlebarsHelpers = new ArrayList<>();

  public boolean useIntegrations;
  public boolean prependToFile;

  @TaskAction
  public void gitChangelogPluginTasks() throws TaskExecutionException {
    try {
      this.getProject().getExtensions().findByType(GitChangelogPluginExtension.class);

      final GitChangelogApi builder =
          gitChangelogApiBuilder()
              .withUseIntegrations(this.useIntegrations)
              .withJiraEnabled(this.jiraEnabled)
              .withGitLabEnabled(this.gitLabEnabled)
              .withGitHubEnabled(this.gitHubEnabled);

      for (final HelperParam helper : this.handlebarsHelpers) {
        builder //
            .withHandlebarsHelper(helper.getName(), helper.getHelper());
      }

      if (this.isSupplied(this.settingsFile)) {
        builder.withSettings(this.getProject().file(this.settingsFile).toURI().toURL());
      }

      if (this.isSupplied(this.fromRepo)) {
        builder.withFromRepo(this.fromRepo);
      }

      if (this.isSupplied(this.toRef)) {
        builder.withToRef(this.toRef);
      }

      if (this.isSupplied(this.templateContent)) {
        builder.withTemplateContent(this.templateContent);
      }
      if (this.isSupplied(this.fromCommit)) {
        builder.withFromCommit(this.fromCommit);
      }
      if (this.isSupplied(this.fromRef)) {
        builder.withFromRef(this.fromRef);
      }
      if (this.isSupplied(this.toCommit)) {
        builder.withToCommit(this.toCommit);
      }

      if (this.isSupplied(this.ignoreTagsIfNameMatches)) {
        builder.withIgnoreTagsIfNameMatches(this.ignoreTagsIfNameMatches);
      }
      if (this.isSupplied(this.readableTagName)) {
        builder.withReadableTagName(this.readableTagName);
      }
      if (this.isSupplied(this.dateFormat)) {
        builder.withDateFormat(this.dateFormat);
      }
      if (this.isSupplied(this.timeZone)) {
        builder.withTimeZone(this.timeZone);
      }
      builder.withRemoveIssueFromMessageArgument(this.removeIssueFromMessage);
      if (this.isSupplied(this.ignoreCommitsIfMessageMatches)) {
        builder.withIgnoreCommitsWithMessage(this.ignoreCommitsIfMessageMatches);
      }
      if (this.ignoreCommitsOlderThan != null) {
        builder.withIgnoreCommitsOlderThan(this.ignoreCommitsOlderThan);
      }
      if (this.isSupplied(this.untaggedName)) {
        builder.withUntaggedName(this.untaggedName);
      }
      if (this.isSupplied(this.noIssueName)) {
        builder.withNoIssueName(this.noIssueName);
      }
      builder.withIgnoreCommitsWithoutIssue(this.ignoreCommitsWithoutIssue);
      for (final List<String> customIssue : this.customIssues) {
        final String name = customIssue.get(0);
        final String pattern = customIssue.get(1);
        String link = null;
        String title = null;
        if (customIssue.size() > 2) {
          link = customIssue.get(2);
        }
        if (customIssue.size() > 3) {
          title = customIssue.get(3);
        }
        builder.withCustomIssue(name, pattern, link, title);
      }
      if (this.isSupplied(this.gitHubApi)) {
        builder.withGitHubApi(this.gitHubApi);
      }
      if (this.isSupplied(this.gitHubToken)) {
        builder.withGitHubToken(this.gitHubToken);
      }
      if (this.isSupplied(this.gitHubIssuePattern)) {
        builder.withGitHubIssuePattern(this.gitHubIssuePattern);
      }

      if (this.isSupplied(this.gitLabProjectName)) {
        builder.withGitLabProjectName(this.gitLabProjectName);
      }
      if (this.isSupplied(this.gitLabServer)) {
        builder.withGitLabServer(this.gitLabServer);
      }
      if (this.isSupplied(this.gitLabToken)) {
        builder.withGitLabToken(this.gitLabToken);
      }

      if (this.isSupplied(this.jiraUsername)) {
        builder.withJiraUsername(this.jiraUsername);
      }
      if (this.isSupplied(this.jiraPassword)) {
        builder.withJiraPassword(this.jiraPassword);
      }
      if (this.isSupplied(this.jiraIssuePattern)) {
        builder.withJiraIssuePattern(this.jiraIssuePattern);
      }
      if (this.isSupplied(this.jiraServer)) {
        builder.withJiraServer(this.jiraServer);
      }

      if (this.file != null) {
        if (this.prependToFile) {
          builder.prependToFile(this.file);
        } else {
          builder.toFile(this.file);
        }
        log.info("#");
        log.info("# Wrote: " + this.file);
        log.info("#");
      }

    } catch (final Exception e) {
      log.error("GitChangelog", e);
    }
  }

  private boolean isSupplied(final String param) {
    return param != null && !param.isEmpty();
  }
}
