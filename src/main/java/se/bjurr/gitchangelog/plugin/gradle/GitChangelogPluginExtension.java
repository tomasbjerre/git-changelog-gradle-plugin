package se.bjurr.gitchangelog.plugin.gradle;

public class GitChangelogPluginExtension {

 private String fromCommit;
 private String toRef;
 private String toCommit;
 private String fromRef;
 private String filePath;
 private String settingsFile;
 private String templateContent;
 private String mediaWikiUrl;
 private String mediaWikiTitle;
 private String mediaWikiUsername;
 private String mediaWikiPassword;

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
}
