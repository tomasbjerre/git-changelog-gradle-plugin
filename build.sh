#!/bin/bash
./gradlew clean cE build install eclipse
cd git-changelog-gradle-plugin-example
./gradlew clean cE build eclipse
