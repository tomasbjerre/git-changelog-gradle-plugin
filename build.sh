#!/bin/bash
./gradlew clean cE build install eclipse
cd git-changelog-gradle-plugin-example
./gradlew generateChangelogs -i --stacktrace
cp CHANGELOG.md ..
