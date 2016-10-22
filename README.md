# Git Changelog Gradle Plugin [![Build Status](https://travis-ci.org/tomasbjerre/git-changelog-gradle-plugin.svg?branch=master)](https://travis-ci.org/tomasbjerre/git-changelog-gradle-plugin) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/se.bjurr.gitchangelog/git-changelog-gradle-plugin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/se.bjurr.gitchangelog/git-changelog-gradle-plugin)

This is a Gradle plugin for [Git Changelog Lib](https://github.com/tomasbjerre/git-changelog-lib).

## Usage ##
There is a complete running example [here](https://github.com/tomasbjerre/git-changelog-gradle-plugin/tree/master/git-changelog-gradle-plugin-example).

There are some more examples in the [build.gradle](https://github.com/tomasbjerre/git-changelog-gradle-plugin/blob/master/git-changelog-gradle-plugin-example/build.gradle).

Here is and example that will produce a CHANGELOG.md.

```
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.se.bjurr.gitchangelog:git-changelog-gradle-plugin:1.40"
  }
}

apply plugin: "se.bjurr.gitchangelog.git-changelog-gradle-plugin"

task gitChangelogTask(type: se.bjurr.gitchangelog.plugin.gradle.GitChangelogTask) {
 filePath = "CHANGELOG.md";
 templateContent = new File('changelog.mustache').getText('UTF-8');
}
```

And then to generate CHANGELOG.md, just run `gradle gitChangelog`.

More documentation can be found in the [Git Changelog Lib](https://github.com/tomasbjerre/git-changelog-lib).

## Developer instructions

To build the code you need to run `build.sh` in root of repo. You may also have a look at `.travis.yml`.

To do a release you need to do `./gradlew release -Dgradle.publish.key=... -Dgradle.publish.secret=...` and release the artifact from [staging](https://oss.sonatype.org/#stagingRepositories). More information [here](http://central.sonatype.org/pages/releasing-the-deployment.html).
