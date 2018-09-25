# Git Changelog Gradle Plugin
[![Build Status](https://travis-ci.org/tomasbjerre/git-changelog-gradle-plugin.svg?branch=master)](https://travis-ci.org/tomasbjerre/git-changelog-gradle-plugin)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/se.bjurr.gitchangelog/git-changelog-gradle-plugin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/se.bjurr.gitchangelog/git-changelog-gradle-plugin)
[![Bintray](https://api.bintray.com/packages/tomasbjerre/tomasbjerre/se.bjurr.gitchangelog%3Agit-changelog-gradle-plugin/images/download.svg) ](https://bintray.com/tomasbjerre/tomasbjerre/se.bjurr.gitchangelog%3Agit-changelog-gradle-plugin/_latestVersion)

This is a Gradle plugin for [Git Changelog Lib](https://github.com/tomasbjerre/git-changelog-lib).

## Usage ##
There is a complete running example [here](https://github.com/tomasbjerre/git-changelog-gradle-plugin/tree/master/git-changelog-gradle-plugin-example).

There are some more examples in the [build.gradle](https://github.com/tomasbjerre/git-changelog-gradle-plugin/blob/master/git-changelog-gradle-plugin-example/build.gradle).

Here is and example that will produce a CHANGELOG.md when running `./gradlew gitChangelogTask`.

```
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.se.bjurr.gitchangelog:git-changelog-gradle-plugin:X"
  }
}

apply plugin: "se.bjurr.gitchangelog.git-changelog-gradle-plugin"

task gitChangelogTask(type: se.bjurr.gitchangelog.plugin.gradle.GitChangelogTask) {
 file = new File("CHANGELOG.md");
Changelog of ${projectDisplayName}.

{{#tags}}
## {{name}}
 {{#issues}}
  {{#hasIssue}}
   {{#hasLink}}
### {{name}} [{{issue}}]({{link}}) {{title}} {{#hasIssueType}} *{{issueType}}* {{/hasIssueType}} {{#hasLabels}} {{#labels}} *{{.}}* {{/labels}} {{/hasLabels}}
   {{/hasLink}}
   {{^hasLink}}
### {{name}} {{issue}} {{title}} {{#hasIssueType}} *{{issueType}}* {{/hasIssueType}} {{#hasLabels}} {{#labels}} *{{.}}* {{/labels}} {{/hasLabels}}
   {{/hasLink}}
  {{/hasIssue}}
  {{^hasIssue}}
### {{name}}
  {{/hasIssue}}

  {{#commits}}
**{{{messageTitle}}}**

{{#messageBodyItems}}
 * {{.}}
{{/messageBodyItems}}

[{{hash}}](https://github.com/{{ownerName}}/{{repoName}}/commit/{{hash}}) {{authorName}} *{{commitTime}}*

  {{/commits}}

 {{/issues}}
{{/tags}}
 """;
}
```

More documentation can be found in the [Git Changelog Lib](https://github.com/tomasbjerre/git-changelog-lib).
