apply(plugin = "java-library")

buildscript {
 repositories {
  mavenLocal()
  mavenCentral()
 }

 dependencies {
  classpath("se.bjurr.gitchangelog:git-changelog-gradle-plugin:+")
 }
}

apply(plugin = "se.bjurr.gitchangelog.git-changelog-gradle-plugin")

tasks.register<se.bjurr.gitchangelog.plugin.gradle.GitChangelogTask>("generateGitChangelog") {
 fromRepo = file(".").toString();
 file = file("CHANGELOG_generateGitChangelog.md");
}
