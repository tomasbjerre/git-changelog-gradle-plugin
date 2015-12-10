package se.bjurr.gitchangelog.plugin.gradle;

public class GitChangelogPluginExtension {
 private String toRef;
 private String toCommit;

 private String fromRef;
 private String fromCommit;

 private String settingsFile;
 private String templateContent;
 private String filePath;

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

 public String getFilePath() {
  return filePath;
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

 public void setFilePath(String filePath) {
  this.filePath = filePath;
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

 public String getReadableTagName() {
  return readableTagName;
 }

 public String getTimeZone() {
  return timeZone;
 }

 public String getUntaggedName() {
  return untaggedName;
 }
}
