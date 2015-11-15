package se.bjurr.gitchangelog.plugin.gradle;

public class GitChangelogPluginExtension {

 private String fromCommit;
 private String toRef;
 private String toCommit;
 private String fromRef;
 private String filePath;
 private String settingsFile;
 private String templateContent;

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
}
