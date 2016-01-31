#!/bin/bash
./gradlew clean cE build install eclipse || exit 1
cd git-changelog-gradle-plugin-example
./gradlew generateChangelogs -i --stacktrace
cp CHANGELOG.md ..
