#!/bin/bash
./gradlew publishToMavenLocal -Pversion=latest-SNAPSHOT || exit 1

cd git-changelog-gradle-plugin-example-kotlin
./gradlew build
cd -

cd git-changelog-gradle-plugin-example
./gradlew build
cd -
