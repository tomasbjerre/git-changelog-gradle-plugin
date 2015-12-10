package se.bjurr.gitchangelog.plugin.gradle;

import static com.google.common.base.Strings.isNullOrEmpty;
import static se.bjurr.gitchangelog.api.GitChangelogApi.gitChangelogApiBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.TaskExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.bjurr.gitchangelog.api.GitChangelogApi;

public class GitChangelogTask extends DefaultTask {

 private static final Logger log = LoggerFactory.getLogger(DefaultTask.class.getName());

 @TaskAction
 public void gitChangelogPluginTasks() throws TaskExecutionException {
  try {
   GitChangelogPluginExtension extension = getProject().getExtensions().findByType(GitChangelogPluginExtension.class);

   GitChangelogApi builder;
   builder = gitChangelogApiBuilder();
   if (isSupplied(extension.getSettingsFile())) {
    URL settingsFile = new File(extension.getSettingsFile()).toURI().toURL();
    builder.withSettings(settingsFile);
   }

   if (isSupplied(extension.getToRef())) {
    builder.withToRef(extension.getToRef());
   }

   if (isSupplied(extension.getTemplateContent())) {
    builder.withTemplateContent(extension.getTemplateContent());
   }
   if (isSupplied(extension.getFromCommit())) {
    builder.withFromCommit(extension.getFromCommit());
   }
   if (isSupplied(extension.getFromRef())) {
    builder.withFromRef(extension.getFromRef());
   }
   if (isSupplied(extension.getToCommit())) {
    builder.withToCommit(extension.getToCommit());
   }

   if (isSupplied(extension.getReadableTagName())) {
    builder.withReadableTagName(extension.getReadableTagName());
   }
   if (isSupplied(extension.getDateFormat())) {
    builder.withDateFormat(extension.getDateFormat());
   }
   if (isSupplied(extension.getTimeZone())) {
    builder.withTimeZone(extension.getTimeZone());
   }
   builder.withRemoveIssueFromMessageArgument(extension.getRemoveIssueFromMessage());
   if (isSupplied(extension.getIgnoreCommitsIfMessageMatches())) {
    builder.withIgnoreCommitsWithMesssage(extension.getIgnoreCommitsIfMessageMatches());
   }
   if (isSupplied(extension.getUntaggedName())) {
    builder.withUntaggedName(extension.getUntaggedName());
   }
   if (isSupplied(extension.getNoIssueName())) {
    builder.withNoIssueName(extension.getNoIssueName());
   }

   if (isSupplied(extension.getFilePath())) {
    builder.toFile(extension.getFilePath());
    log.info("#");
    log.info("# Wrote: " + extension.getFilePath());
    log.info("#");
   }

   if (isSupplied(extension.getMediaWikiUrl())) {
    builder//
      .toMediaWiki(//
        extension.getMediaWikiUsername(),//
        extension.getMediaWikiPassword(), //
        extension.getMediaWikiUrl(),//
        extension.getMediaWikiTitle());
    log.info("#");
    log.info("# Created: " + extension.getMediaWikiUrl() + "/index.php/" + extension.getMediaWikiTitle());
    log.info("#");
   }
  } catch (MalformedURLException e) {
   log.error("GitChangelog", e);
  }
 }

 private boolean isSupplied(String param) {
  return !isNullOrEmpty(param);
 }
}
