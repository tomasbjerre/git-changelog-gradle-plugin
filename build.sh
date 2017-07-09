#!/bin/bash
./gradlew clean cE build install eclipse || exit 1
cd git-changelog-gradle-plugin-example
./gradlew generateChangelogs -i --stacktrace -DGITHUB_OAUTH2TOKEN=$GITHUB_OAUTH2TOKEN -DGITLAB_TOKEN=$GITLAB_TOKEN || exit 1
cp CHANGELOG.md ..
