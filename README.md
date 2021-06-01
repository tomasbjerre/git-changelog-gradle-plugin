# Git Changelog Gradle Plugin

[![Build Status](https://travis-ci.org/tomasbjerre/git-changelog-gradle-plugin.svg?branch=master)](https://travis-ci.org/tomasbjerre/git-changelog-gradle-plugin)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/se.bjurr.gitchangelog/git-changelog-gradle-plugin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/se.bjurr.gitchangelog/git-changelog-gradle-plugin)

This is a Gradle plugin for [Git Changelog Lib](https://github.com/tomasbjerre/git-changelog-lib).

## Usage

There is a complete running example [here](https://github.com/tomasbjerre/git-changelog-gradle-plugin/tree/master/git-changelog-gradle-plugin-example).

There are some more examples in the [build.gradle](https://github.com/tomasbjerre/git-changelog-gradle-plugin/blob/master/git-changelog-gradle-plugin-example/build.gradle).

Here is and example that will produce a CHANGELOG.md when running `./gradlew gitChangelogTask`.

More documentation can be found in the [Git Changelog Lib](https://github.com/tomasbjerre/git-changelog-lib).

### `settings.gradle`

```groovy
pluginManagement {
  repositories {
    gradlePluginPortal()
  }
}
```

### `build.gradle`

```groovy
plugin {
  id 'se.bjurr.gitchangelog.git-changelog-gradle-plugin' version 'X'
}

task gitChangelogTask(type: se.bjurr.gitchangelog.plugin.gradle.GitChangelogTask) {
 file = new File("CHANGELOG.md");
 templateContent = """
  // Template here!
 """;
}
```

### Template - Simple

```hbs
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
```

### Template - Semantic versioning from conventional commits

If you are using [conventional commits](https://www.conventionalcommits.org/en/v1.0.0/):

```shell
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]
```

A changelog can be rendered (using [Helpers](https://github.com/tomasbjerre/git-changelog-lib#Helpers)) like this:

```hbs
# Changelog

{{#tags}}
{{#ifReleaseTag .}}
## [{{name}}](https://gitlab.com/html-validate/html-validate/compare/{{name}}) ({{tagDate .}})

  {{#ifContainsType commits type='feat'}}
### Features

    {{#commits}}
      {{#ifCommitType . type='feat'}}
 - {{#eachCommitScope .}} **{{.}}** {{/eachCommitScope}} {{{commitDescription .}}} ([{{hash}}](https://gitlab.com/html-validate/html-validate/commit/{{hashFull}}))
      {{/ifCommitType}}
    {{/commits}}
  {{/ifContainsType}}

  {{#ifContainsType commits type='fix'}}
### Bug Fixes

    {{#commits}}
      {{#ifCommitType . type='fix'}}
 - {{#eachCommitScope .}} **{{.}}** {{/eachCommitScope}} {{{commitDescription .}}} ([{{hash}}](https://gitlab.com/html-validate/html-validate/commit/{{hashFull}}))
      {{/ifCommitType}}
    {{/commits}}
  {{/ifContainsType}}

{{/ifReleaseTag}}
{{/tags}}
```

### Example - custom helpers

You can add your own helpers and use them in the template. There are also [built in Helpers](https://github.com/tomasbjerre/git-changelog-lib#Helpers).

```groovy
apply plugin: "se.bjurr.gitchangelog.git-changelog-gradle-plugin"

import se.bjurr.gitchangelog.plugin.gradle.HelperParam;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

task gitChangelogTask(type: se.bjurr.gitchangelog.plugin.gradle.GitChangelogTask) {
  file = new File("CHANGELOG.md");
  handlebarsHelpers = [
    new HelperParam("startsWith", new Helper<String>() {
      public Object apply(String from, Options options) throws IOException {
        def s = options.hash['s']
        if (from.matches("^" + s + ".*")) {
          return options.fn(this);
        } else {
          return options.inverse(this);
        }
      }
    }),
    new HelperParam("firstLetters", new Helper<String>() {
      public Object apply(String from, Options options) throws IOException {
        def number = new Integer(options.hash['number'])
        return from.substring(0,number);
      }
    })
  ]
  templateContent = """
  {{#commits}}
    {{#startsWith messageTitle s='feat'}}
      Starts with feat: "{{messageTitle}}"
      first 10 letters of hash is: {{firstLetters hash number='10'}}
    {{/startsWith}}
  {{/commits}}
  """;
}
```

### Get next release

It can also be used to get the next semantic version based on commits.

```groovy
classpath 'se.bjurr.gitchangelog:git-changelog-lib:1.+'

...

buildscript {
 repositories {
  mavenCentral()
  mavenLocal()
 }
 dependencies {
  ...
  classpath 'se.bjurr.gitchangelog:git-changelog-lib:1.+'
 }
}


def nextVersion = se.bjurr.gitchangelog.api.GitChangelogApi.gitChangelogApiBuilder()
  .withSemanticMajorVersionPattern("^[Bb]reaking")
  .withSemanticMinorVersionPattern("[Ff]eature")
  .getNextSemanticVersion();

println "Next version:" + nextVersion.toString();
println " Major:" + nextVersion.getMajor();
println " Minor:" + nextVersion.getMinor();
println " Patch:" + nextVersion.getPatch();
```
