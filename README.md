# Git Changelog Gradle Plugin [![Build Status](https://travis-ci.org/tomasbjerre/git-changelog-gradle-plugin.svg?branch=master)](https://travis-ci.org/tomasbjerre/git-changelog-gradle-plugin)

This is a Gradle plugin for [Git Changelog](https://github.com/tomasbjerre/git-changelog-lib).


## Usage ##
Here is and example that will produce a CHANGELOG.md. There is also a complete running example [here](https://github.com/tomasbjerre/git-changelog-gradle-plugin/tree/master/git-changelog-gradle-plugin-example).
```
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.se.bjurr.gitchangelog:git-changelog-gradle-plugin:1.8"
  }
}

apply plugin: "se.bjurr.gitchangelog.git-changelog-gradle-plugin

task gitChangelogTask(type: se.bjurr.gitchangelog.plugin.gradle.GitChangelogTask) {
 //gitChangelogPlugin.fromRef;
 //gitChangelogPlugin.fromCommit;
 gitChangelogPlugin.toRef = "refs/heads/master";
 //gitChangelogPlugin.toCommit;
 gitChangelogPlugin.templateContent = new File('changelog.mustache').getText('UTF-8');
 gitChangelogPlugin.filePath = "CHANGELOG.md";
 gitChangelogPlugin.settingsFile = "changelog.json";
 //gitChangelogPlugin.mediaWikiUrl = "http://localhost/mediawiki/";
 //gitChangelogPlugin.mediaWikiTitle = "Tomas Title";
 //gitChangelogPlugin.mediaWikiUsername = "tomas";
 //gitChangelogPlugin.mediaWikiPassword = "tomaskod";
}
```

This setup has a settings file, changelog.json, like this:

```
{
 "fromRepo": ".",
 "fromCommit": "0000000000000000000000000000000000000000",
 "toRef": "refs/heads/master",
 
 "ignoreCommitsIfMessageMatches": "^\\[maven-release-plugin\\].*|^\\[Gradle Release Plugin\\].*|^Merge.*",
 "readableTagName": "/([^/]+?)$",
 "dateFormat": "YYYY-MM-dd HH:mm:ss",
 "untaggedName": "Next release",
 "noIssueName": "Other changes",
 "timeZone": "UTC",
 "removeIssueFromMessage": "true",
 
 "jiraIssuePattern": "\\b[a-zA-Z]([a-zA-Z]+)-([0-9]+)\\b",

 "customIssues": [
  {"name": "Github", "pattern": "#([0-9]+)", "link": "https://github.com/tomasbjerre/git-changelog-gradle-plugin/issues/${PATTERN_GROUP_1}" },
  { "name": "Bugs", "pattern": "#bug" },
  { "name": "Features", "pattern": "#feature" }
 ]
}
```

It has a template file like this:

```
# Git Changelog changelog

Changelog of Git Changelog.

{{#tags}}
## {{name}}
 {{#issues}}
### {{name}}

   {{#commits}}
{{{message}}}

   {{/commits}}
 {{/issues}}
{{/tags}}
```

And then to generate CHANGELOG.md, just run `gradle gitChangelog`.

## Developer instructions

To build the code you need to run `build.sh` in root of repo. You may also have a look at `.travis.yml`.

To do a release you need to do `./gradlew release -Dgradle.publish.key=... -Dgradle.publish.secret=...` and release the artifact from [staging](https://oss.sonatype.org/#stagingRepositories). More information [here](http://central.sonatype.org/pages/releasing-the-deployment.html).
