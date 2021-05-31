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

  private String fromRepo;

  private String toRef;
  private String toCommit;

  private String fromRef;
  private String fromCommit;

  private String settingsFile;
  private String templateContent;
  private File file;

  private String readableTagName;
  private String dateFormat;
  private String timeZone;
  private boolean removeIssueFromMessage;
  private String ignoreCommitsIfMessageMatches;
  private String untaggedName;
  private String noIssueName;
  private boolean ignoreCommitsWithoutIssue;
  private String ignoreTagsIfNameMatches;

  private List<List<String>> customIssues = new ArrayList<>();
  private String gitHubApi;
  private String gitHubToken;
  private String gitHubIssuePattern;
  private String jiraUsername;
  private String jiraPassword;
  private String jiraIssuePattern;
  private String jiraServer;

  private String gitLabServer;
  private String gitLabProjectName;
  private String gitLabToken;

  private Date ignoreCommitsOlderThan;

  private List<HelperParam> handlebarsHelpers = new ArrayList<>();

  public void setHandlebarsHelpers(final List<HelperParam> handlebarsHelpers) {
    this.handlebarsHelpers = handlebarsHelpers;
  }

  public void setIgnoreCommitsOlderThan(final Date ignoreCommitsOlderThan) {
    this.ignoreCommitsOlderThan = ignoreCommitsOlderThan;
  }

  public Date getIgnoreCommitsOlderThan() {
    return this.ignoreCommitsOlderThan;
  }

  public void setFromRepo(final String fromRepo) {
    this.fromRepo = fromRepo;
  }

  public String getFromRepo() {
    return this.fromRepo;
  }

  public void setGitLabProjectName(final String gitLabProjectName) {
    this.gitLabProjectName = gitLabProjectName;
  }

  public void setGitLabServer(final String gitLabServer) {
    this.gitLabServer = gitLabServer;
  }

  public void setGitLabToken(final String gitLabToken) {
    this.gitLabToken = gitLabToken;
  }

  public void setIgnoreTagsIfNameMatches(final String ignoreTagsIfNameMatches) {
    this.ignoreTagsIfNameMatches = ignoreTagsIfNameMatches;
  }

  public String getIgnoreTagsIfNameMatches() {
    return this.ignoreTagsIfNameMatches;
  }

  public void setJiraIssuePattern(final String jiraIssuePattern) {
    this.jiraIssuePattern = jiraIssuePattern;
  }

  public void setJiraPassword(final String jiraPassword) {
    this.jiraPassword = jiraPassword;
  }

  public void setJiraServer(final String jiraServer) {
    this.jiraServer = jiraServer;
  }

  public void setJiraUsername(final String jiraUsername) {
    this.jiraUsername = jiraUsername;
  }

  public String getJiraIssuePattern() {
    return this.jiraIssuePattern;
  }

  public String getJiraPassword() {
    return this.jiraPassword;
  }

  public String getJiraServer() {
    return this.jiraServer;
  }

  public String getJiraUsername() {
    return this.jiraUsername;
  }

  public void setCustomIssues(final List<List<String>> customIssues) {
    this.customIssues = customIssues;
  }

  public List<List<String>> getCustomIssues() {
    return this.customIssues;
  }

  public void setTemplateContent(final String templateContent) {
    this.templateContent = templateContent;
  }

  public String getTemplateContent() {
    return this.templateContent;
  }

  public String getFromCommit() {
    return this.fromCommit;
  }

  public String getSettingsFile() {
    return this.settingsFile;
  }

  public File getFile() {
    return this.file;
  }

  public String getFromRef() {
    return this.fromRef;
  }

  public String getToCommit() {
    return this.toCommit;
  }

  public String getToRef() {
    return this.toRef;
  }

  public void setFile(final File file) {
    this.file = file;
  }

  public void setFromCommit(final String fromCommit) {
    this.fromCommit = fromCommit;
  }

  public void setFromRef(final String fromRef) {
    this.fromRef = fromRef;
  }

  public void setSettingsFile(final String settingsFile) {
    this.settingsFile = settingsFile;
  }

  public void setToCommit(final String toCommit) {
    this.toCommit = toCommit;
  }

  public void setToRef(final String toRef) {
    this.toRef = toRef;
  }

  public void setDateFormat(final String dateFormat) {
    this.dateFormat = dateFormat;
  }

  public void setIgnoreCommitsIfMessageMatches(final String ignoreCommitsIfMessageMatches) {
    this.ignoreCommitsIfMessageMatches = ignoreCommitsIfMessageMatches;
  }

  public void setNoIssueName(final String noIssueName) {
    this.noIssueName = noIssueName;
  }

  public void setReadableTagName(final String readableTagName) {
    this.readableTagName = readableTagName;
  }

  public void setTimeZone(final String timeZone) {
    this.timeZone = timeZone;
  }

  public void setUntaggedName(final String untaggedName) {
    this.untaggedName = untaggedName;
  }

  public String getDateFormat() {
    return this.dateFormat;
  }

  public boolean getRemoveIssueFromMessage() {
    return this.removeIssueFromMessage;
  }

  public void setRemoveIssueFromMessage(final boolean removeIssueFromMessage) {
    this.removeIssueFromMessage = removeIssueFromMessage;
  }

  public String getIgnoreCommitsIfMessageMatches() {
    return this.ignoreCommitsIfMessageMatches;
  }

  public String getNoIssueName() {
    return this.noIssueName;
  }

  public void setIgnoreCommitsWithoutIssue(final boolean ignoreCommitsWithoutIssue) {
    this.ignoreCommitsWithoutIssue = ignoreCommitsWithoutIssue;
  }

  public boolean isIgnoreCommitsWithoutIssue() {
    return this.ignoreCommitsWithoutIssue;
  }

  public String getReadableTagName() {
    return this.readableTagName;
  }

  public String getTimeZone() {
    return this.timeZone;
  }

  public String getUntaggedName() {
    return this.untaggedName;
  }

  public void setGitHubApi(final String gitHubApi) {
    this.gitHubApi = gitHubApi;
  }

  public void setGitHubIssuePattern(final String gitHubIssuePattern) {
    this.gitHubIssuePattern = gitHubIssuePattern;
  }

  public void setGitHubToken(final String gitHubToken) {
    this.gitHubToken = gitHubToken;
  }

  public String getGitHubApi() {
    return this.gitHubApi;
  }

  public String getGitHubIssuePattern() {
    return this.gitHubIssuePattern;
  }

  public String getGitHubToken() {
    return this.gitHubToken;
  }

  @TaskAction
  public void gitChangelogPluginTasks() throws TaskExecutionException {
    try {
      this.getProject().getExtensions().findByType(GitChangelogPluginExtension.class);

      final GitChangelogApi builder = gitChangelogApiBuilder();

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
        builder.toFile(this.file);
        log.info("#");
        log.info("# Wrote: " + this.file);
        log.info("#");
      }

    } catch (final Exception e) {
      log.error("GitChangelog", e);
    }
  }

  private boolean isSupplied(final String param) {
    return param == null || param.isEmpty();
  }
}
