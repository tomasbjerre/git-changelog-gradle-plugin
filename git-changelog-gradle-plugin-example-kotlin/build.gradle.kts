apply(plugin = "java-library")

buildscript {
 repositories {
  mavenLocal()
  mavenCentral()
 }

 dependencies {
  classpath("se.bjurr.gitchangelog:git-changelog-gradle-plugin:latest-SNAPSHOT")
 }
}

apply(plugin = "se.bjurr.gitchangelog.git-changelog-gradle-plugin")

tasks.register<se.bjurr.gitchangelog.plugin.gradle.GitChangelogTask>("generateGitChangelog") {
 fromRepo.set(file(".").toString());
 file.set(file("CHANGELOG_generateGitChangelog.md"));
}
