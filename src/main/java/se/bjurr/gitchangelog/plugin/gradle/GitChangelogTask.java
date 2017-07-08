package se.bjurr.gitchangelog.plugin.gradle;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Lists.newArrayList;
import static se.bjurr.gitchangelog.api.GitChangelogApi.gitChangelogApiBuilder;

import java.io.File;
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

  private String mediaWikiUrl;
  private String mediaWikiTitle;
  private String mediaWikiUsername;
  private String mediaWikiPassword;

  private String readableTagName;
  private String dateFormat;
  private String timeZone;
  private boolean removeIssueFromMessage;
  private String ignoreCommitsIfMessageMatches;
  private String untaggedName;
  private String noIssueName;
  private boolean ignoreCommitsWithoutIssue;
  private String ignoreTagsIfNameMatches;

  private List<List<String>> customIssues = newArrayList();
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

  public void setIgnoreCommitsOlderThan(Date ignoreCommitsOlderThan) {
    this.ignoreCommitsOlderThan = ignoreCommitsOlderThan;
  }

  public Date getIgnoreCommitsOlderThan() {
    return ignoreCommitsOlderThan;
  }

  public void setFromRepo(String fromRepo) {
    this.fromRepo = fromRepo;
  }

  public String getFromRepo() {
    return fromRepo;
  }

  public void setGitLabProjectName(String gitLabProjectName) {
    this.gitLabProjectName = gitLabProjectName;
  }

  public void setGitLabServer(String gitLabServer) {
    this.gitLabServer = gitLabServer;
  }

  public void setGitLabToken(String gitLabToken) {
    this.gitLabToken = gitLabToken;
  }

  public void setIgnoreTagsIfNameMatches(String ignoreTagsIfNameMatches) {
    this.ignoreTagsIfNameMatches = ignoreTagsIfNameMatches;
  }

  public String getIgnoreTagsIfNameMatches() {
    return ignoreTagsIfNameMatches;
  }

  public void setJiraIssuePattern(String jiraIssuePattern) {
    this.jiraIssuePattern = jiraIssuePattern;
  }

  public void setJiraPassword(String jiraPassword) {
    this.jiraPassword = jiraPassword;
  }

  public void setJiraServer(String jiraServer) {
    this.jiraServer = jiraServer;
  }

  public void setJiraUsername(String jiraUsername) {
    this.jiraUsername = jiraUsername;
  }

  public String getJiraIssuePattern() {
    return jiraIssuePattern;
  }

  public String getJiraPassword() {
    return jiraPassword;
  }

  public String getJiraServer() {
    return jiraServer;
  }

  public String getJiraUsername() {
    return jiraUsername;
  }

  public void setCustomIssues(List<List<String>> customIssues) {
    this.customIssues = customIssues;
  }

  public List<List<String>> getCustomIssues() {
    return customIssues;
  }

  public void setTemplateContent(String templateContent) {
    this.templateContent = templateContent;
  }

  public String getTemplateContent() {
    return templateContent;
  }

  public String getFromCommit() {
    return fromCommit;
  }

  public String getSettingsFile() {
    return settingsFile;
  }

  public File getFile() {
    return file;
  }

  public String getFromRef() {
    return fromRef;
  }

  public String getToCommit() {
    return toCommit;
  }

  public String getToRef() {
    return toRef;
  }

  public void setFile(File file) {
    this.file = file;
  }

  public void setFromCommit(String fromCommit) {
    this.fromCommit = fromCommit;
  }

  public void setFromRef(String fromRef) {
    this.fromRef = fromRef;
  }

  public void setSettingsFile(String settingsFile) {
    this.settingsFile = settingsFile;
  }

  public void setToCommit(String toCommit) {
    this.toCommit = toCommit;
  }

  public void setToRef(String toRef) {
    this.toRef = toRef;
  }

  public void setMediaWikiPassword(String mediaWikiPassword) {
    this.mediaWikiPassword = mediaWikiPassword;
  }

  public void setMediaWikiTitle(String mediaWikiTitle) {
    this.mediaWikiTitle = mediaWikiTitle;
  }

  public void setMediaWikiUrl(String mediaWikiUrl) {
    this.mediaWikiUrl = mediaWikiUrl;
  }

  public void setMediaWikiUsername(String mediaWikiUsername) {
    this.mediaWikiUsername = mediaWikiUsername;
  }

  public String getMediaWikiPassword() {
    return mediaWikiPassword;
  }

  public String getMediaWikiTitle() {
    return mediaWikiTitle;
  }

  public String getMediaWikiUrl() {
    return mediaWikiUrl;
  }

  public String getMediaWikiUsername() {
    return mediaWikiUsername;
  }

  public void setDateFormat(String dateFormat) {
    this.dateFormat = dateFormat;
  }

  public void setIgnoreCommitsIfMessageMatches(String ignoreCommitsIfMessageMatches) {
    this.ignoreCommitsIfMessageMatches = ignoreCommitsIfMessageMatches;
  }

  public void setNoIssueName(String noIssueName) {
    this.noIssueName = noIssueName;
  }

  public void setReadableTagName(String readableTagName) {
    this.readableTagName = readableTagName;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  public void setUntaggedName(String untaggedName) {
    this.untaggedName = untaggedName;
  }

  public String getDateFormat() {
    return dateFormat;
  }

  public boolean getRemoveIssueFromMessage() {
    return removeIssueFromMessage;
  }

  public void setRemoveIssueFromMessage(boolean removeIssueFromMessage) {
    this.removeIssueFromMessage = removeIssueFromMessage;
  }

  public String getIgnoreCommitsIfMessageMatches() {
    return ignoreCommitsIfMessageMatches;
  }

  public String getNoIssueName() {
    return noIssueName;
  }

  public void setIgnoreCommitsWithoutIssue(boolean ignoreCommitsWithoutIssue) {
    this.ignoreCommitsWithoutIssue = ignoreCommitsWithoutIssue;
  }

  public boolean isIgnoreCommitsWithoutIssue() {
    return ignoreCommitsWithoutIssue;
  }

  public String getReadableTagName() {
    return readableTagName;
  }

  public String getTimeZone() {
    return timeZone;
  }

  public String getUntaggedName() {
    return untaggedName;
  }

  public void setGitHubApi(String gitHubApi) {
    this.gitHubApi = gitHubApi;
  }

  public void setGitHubIssuePattern(String gitHubIssuePattern) {
    this.gitHubIssuePattern = gitHubIssuePattern;
  }

  public void setGitHubToken(String gitHubToken) {
    this.gitHubToken = gitHubToken;
  }

  public String getGitHubApi() {
    return gitHubApi;
  }

  public String getGitHubIssuePattern() {
    return gitHubIssuePattern;
  }

  public String getGitHubToken() {
    return gitHubToken;
  }

  @TaskAction
  public void gitChangelogPluginTasks() throws TaskExecutionException {
    try {
      getProject().getExtensions().findByType(GitChangelogPluginExtension.class);

      GitChangelogApi builder;
      builder = gitChangelogApiBuilder();

      builder.withFromRepo(fromRepo);

      if (isSupplied(settingsFile)) {
        builder.withSettings(getProject().file(settingsFile).toURI().toURL());
      }

      if (isSupplied(toRef)) {
        builder.withToRef(toRef);
      }

      if (isSupplied(templateContent)) {
        builder.withTemplateContent(templateContent);
      }
      if (isSupplied(fromCommit)) {
        builder.withFromCommit(fromCommit);
      }
      if (isSupplied(fromRef)) {
        builder.withFromRef(fromRef);
      }
      if (isSupplied(toCommit)) {
        builder.withToCommit(toCommit);
      }

      if (isSupplied(ignoreTagsIfNameMatches)) {
        builder.withIgnoreTagsIfNameMatches(ignoreTagsIfNameMatches);
      }
      if (isSupplied(readableTagName)) {
        builder.withReadableTagName(readableTagName);
      }
      if (isSupplied(dateFormat)) {
        builder.withDateFormat(dateFormat);
      }
      if (isSupplied(timeZone)) {
        builder.withTimeZone(timeZone);
      }
      builder.withRemoveIssueFromMessageArgument(removeIssueFromMessage);
      if (isSupplied(ignoreCommitsIfMessageMatches)) {
        builder.withIgnoreCommitsWithMessage(ignoreCommitsIfMessageMatches);
      }
      if (ignoreCommitsOlderThan != null) {
        builder.withIgnoreCommitsOlderThan(ignoreCommitsOlderThan);
      }
      if (isSupplied(untaggedName)) {
        builder.withUntaggedName(untaggedName);
      }
      if (isSupplied(noIssueName)) {
        builder.withNoIssueName(noIssueName);
      }
      builder.withIgnoreCommitsWithoutIssue(ignoreCommitsWithoutIssue);
      for (List<String> customIssue : customIssues) {
        String name = customIssue.get(0);
        String pattern = customIssue.get(1);
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
      if (isSupplied(gitHubApi)) {
        builder.withGitHubApi(gitHubApi);
      }
      if (isSupplied(gitHubToken)) {
        builder.withGitHubToken(gitHubToken);
      }
      if (isSupplied(gitHubIssuePattern)) {
        builder.withGitHubIssuePattern(gitHubIssuePattern);
      }

      if (isSupplied(gitLabProjectName)) {
        builder.withGitLabProjectName(gitLabProjectName);
      }
      if (isSupplied(gitLabServer)) {
        builder.withGitLabServer(gitLabServer);
      }
      if (isSupplied(gitLabToken)) {
        builder.withGitLabToken(gitLabToken);
      }

      if (isSupplied(jiraUsername)) {
        builder.withJiraUsername(jiraUsername);
      }
      if (isSupplied(jiraPassword)) {
        builder.withJiraPassword(jiraPassword);
      }
      if (isSupplied(jiraIssuePattern)) {
        builder.withJiraIssuePattern(jiraIssuePattern);
      }
      if (isSupplied(jiraServer)) {
        builder.withJiraServer(jiraServer);
      }

      if (file != null) {
        builder.toFile(file);
        log.info("#");
        log.info("# Wrote: " + file);
        log.info("#");
      }

      if (isSupplied(mediaWikiUrl)) {
        builder //
            .toMediaWiki( //
            mediaWikiUsername, //
            mediaWikiPassword, //
            mediaWikiUrl, //
            mediaWikiTitle);
        log.info("#");
        log.info("# Created: " + mediaWikiUrl + "/index.php/" + mediaWikiTitle);
        log.info("#");
      }
    } catch (Exception e) {
      log.error("GitChangelog", e);
    }
  }

  private boolean isSupplied(String param) {
    return !isNullOrEmpty(param);
  }
}
