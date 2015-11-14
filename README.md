# Git Changelog Gradle Plugin [![Build Status](https://travis-ci.org/tomasbjerre/git-changelog-gradle-plugin.svg?branch=master)](https://travis-ci.org/tomasbjerre/git-changelog-gradle-plugin)

This is a Gradle plugin for [Git Changelog](https://github.com/tomasbjerre/git-changelog-lib).

## Usage ##
Here is and examplet.
```
```

To generate changelog, just run `gradle git-changelog`.

## Developer instructions

To build the code you need to run `build.sh` in root of repo. You may also have a look at `.travis.yml`.

To do a release you need to do `./gradlew release` and release the artifact from [staging](https://oss.sonatype.org/#stagingRepositories). More information [here](http://central.sonatype.org/pages/releasing-the-deployment.html).
