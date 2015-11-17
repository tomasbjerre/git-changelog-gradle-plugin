package se.bjurr.gitchangelog.plugin.gradle;

import static com.google.common.base.Strings.isNullOrEmpty;
import static se.bjurr.gitchangelog.api.GitChangelogApi.gitChangelogApiBuilder;

import java.io.File;
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

   URL settingsFile = new File(extension.getSettingsFile()).toURI().toURL();

   GitChangelogApi builder = gitChangelogApiBuilder() //
     .withSettings(settingsFile) //
     .withTemplateContent(extension.getTemplateContent()) //
     .withToRef(extension.getToRef());

   if (!isNullOrEmpty(extension.getFromCommit())) {
    builder //
      .withFromCommit(extension.getFromCommit());
   }
   if (!isNullOrEmpty(extension.getFromRef())) {
    builder //
      .withFromRef(extension.getFromRef());
   }

   if (!isNullOrEmpty(extension.getToCommit())) {
    builder //
      .withToCommit(extension.getToCommit());
   }
   if (!isNullOrEmpty(extension.getToRef())) {
    builder //
      .withToRef(extension.getToRef());
   }

   if (!isNullOrEmpty(extension.getFilePath())) {
    builder //
      .toFile(extension.getFilePath());
    log.info("Git Changelog written to " + extension.getFilePath());
   }

   if (!isNullOrEmpty(extension.getMediaWikiUrl())) {
    builder//
      .toMediaWiki(//
        extension.getMediaWikiUsername(),//
        extension.getMediaWikiPassword(), //
        extension.getMediaWikiUrl(),//
        extension.getMediaWikiTitle());
    log.info("Git Changelog written to " + extension.getMediaWikiUrl() + "/index.php/" + extension.getMediaWikiTitle());
   }

  } catch (Exception e) {
   throw new TaskExecutionException(this, e);
  }
 }
}
