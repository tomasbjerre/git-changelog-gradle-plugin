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

   String fromCommit = extension.getFromCommit();
   URL settingsFile = new File(extension.getSettingsFile()).toURI().toURL();
   String filePath = extension.getFilePath();
   String fromRef = extension.getFromRef();
   String toCommit = extension.getToCommit();
   String toRef = extension.getToRef();
   String templateContent = extension.getTemplateContent();

   GitChangelogApi builder = gitChangelogApiBuilder() //
     .withSettings(settingsFile) //
     .withTemplateContent(templateContent) //
     .withToRef(toRef);

   if (!isNullOrEmpty(fromCommit)) {
    builder //
      .withFromCommit(fromCommit);
   }
   if (!isNullOrEmpty(fromRef)) {
    builder //
      .withFromRef(fromRef);
   }
   if (!isNullOrEmpty(toCommit)) {
    builder //
      .withToCommit(toCommit);
   }

   builder //
     .toFile(filePath);

   log.info("Git Changelog written to " + filePath);

  } catch (Exception e) {
   throw new TaskExecutionException(this, e);
  }
 }
}
