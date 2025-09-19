## 3.1.0 (2025-09-19)

### Features

-  expose git-changelog-lib as api ([40d46](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/40d46845d3122d9) Tomas Bjerre)  

## 3.0.7 (2025-07-29)

### Dependency updates

- dependency updates ([b1530](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/b1530259d9c27f9) Tomas Bjerre)  
## 3.0.6 (2025-03-16)

### Dependency updates

- git-changelog-lib ([f7c6e](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/f7c6efe9b0d67c0) Tomas Bjerre)  
## 3.0.5 (2025-02-09)

### Bug Fixes

-  configuration cache fix by avoiding project during execution ([87e78](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/87e78411c68c0b8) Tomas Bjerre)  [#55](https://github.com/tomasbjerre/git-changelog-gradle-plugin/issues/55)  

## 3.0.4 (2025-01-26)

### Bug Fixes

-  reverse order in eachUrlPart ([64a1b](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/64a1bb9df9bc08c) Tomas Bjerre)  

## 3.0.3 (2025-01-18)

### Dependency updates

- upgrading dependencies ([fcb64](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/fcb64e4aee16613) Tomas Bjerre)  
## 3.0.2 (2024-11-09)

### Bug Fixes

-  triggering new version ([69b18](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/69b185cbf96503b) Tomas Bjerre)  

## 3.0.0 (2024-11-09)

### Breaking changes

-  enabling lazy loading of all configuration ([3d1a2](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/3d1a20d9c17a433) Tomas Bjerre)  

## 2.5.2 (2024-10-18)

### Bug Fixes

-  triggering new version ([4b9f6](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/4b9f603d91b65be) Tomas Bjerre)  

## 2.5.1 (2024-10-16)

### Bug Fixes

-  scope helpers to support chore(deps) ([1bdfe](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/1bdfe8c8d3c22e7) Tomas Bjerre)  

## 2.5.0 (2024-10-16)

### Features

-  stepping git-changelog-lib ([064c1](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/064c1e6cf66faaa) Tomas Bjerre)  

# git-changelog-gradle-plugin changelog

Changelog of git-changelog-gradle-plugin.

## 2.4.1 (2024-10-03)

### Bug Fixes

-  logging reading of properties ([41430](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/41430b1c9426770) Tomas Bjerre)  

## 2.4.0 (2024-10-03)

### Features

-  enable version change to be triggered by property 'setVersionConventional' ([11021](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/1102173439584d5) Tomas Bjerre)  

## 2.3.0 (2024-10-02)

### Bug Fixes

-  removing snapshot build dependencies, using git changelog plugin 2.2.1 ([05da5](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/05da51d52494a02) Tomas Bjerre)  

## 2.2.2 (2024-10-02)

### Features

-  sorting properties when setting version ([a48f3](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/a48f30c138810fb) Tomas Bjerre)  

## 2.2.1 (2024-10-02)

### Bug Fixes

-  releasing with gradle release task ([cb6e4](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/cb6e475e5dc91d9) Tomas Bjerre)  

## 2.2.0 (2024-10-02)

### Features

-  use special default template when prepending ([cb5cc](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/cb5cc7172dd5229) Tomas Bjerre)  

### Bug Fixes

-  build script ([77772](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/777725bcd56c95d) Tomas Bjerre)  

## 2.1.2 (2024-02-25)

### Bug Fixes

-  building with Gradle 8 ([024cb](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/024cb1f5c1ac4f9) Tomas Bjerre)  

## 2.1.1 (2024-02-25)

### Bug Fixes

-  building with Gradle 8 ([af981](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/af981b60f0780e1) Tomas Bjerre)  

## 2.1.0 (2024-02-10)

### Features

-  **conventional-commits**  allow whitespace, colon and comma as separator in scope ([80fb4](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/80fb4045b2905e4) Tomas Bjerre)  

## 2.0.0 (2024-01-27)

### Breaking changes

-  JGit 6 and Java 11 ([4395d](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/4395d7b962977fa) Tomas Bjerre)  

## 1.81.4 (2023-12-01)

### Bug Fixes

-  mapping commits to lowest possible semantic tag ([3a2bd](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/3a2bd5aa4309aca) Tomas Bjerre)  

## 1.81.3 (2023-09-24)

### Bug Fixes

-  current version ([ed1d9](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/ed1d995e76a80f7) Tomas Bjerre)  [#48](https://github.com/tomasbjerre/git-changelog-gradle-plugin/issues/48)  

## 1.81.2 (2023-09-24)

### Bug Fixes

-  using current version in GitChangelogSemanticVersionTask ([f6b0c](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/f6b0c3066058b1a) Tomas Bjerre)  [#48](https://github.com/tomasbjerre/git-changelog-gradle-plugin/issues/48)  

## 1.81.1 (2023-09-20)

### Bug Fixes

-  **GitChangelogSemanticVersionTask**  Properly close `gradle.properties` ([835da](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/835da6a76abc873) Sebastian Schuberth)  
-  **GitChangelogGradlePlugin**  Make tasks show up in "tasks" ([71b04](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/71b04a1ae8a1b66) Sebastian Schuberth)  

## 1.81.0 (2023-09-11)

### Features

-  add filtering for footer tokens ([e07f9](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/e07f9710351cfd2) Tomas Bjerre)  

## 1.80.0 (2023-08-31)

### Features

-  from/toRevision and prioritizing commits semantically when adding to tags ([b8f27](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/b8f27b45a4525f9) Tomas Bjerre)  

## 1.79.0 (2023-04-22)

### Features

-  stringHelpers ([39183](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/391836431dd84f6) Tomas Bjerre)  

## 1.78.1 (2023-03-12)

### Bug Fixes

-  avoiding stuck execution ([de937](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/de9379c0a235c86) Tomas Bjerre)  

## 1.78.0 (2023-02-28)

### Features

-  add ignoreTagsIfNameMatches to gitChangelogSemanticVersion ([8d766](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/8d766aed4676ac7) Tomas Bjerre)  

## 1.77.3 (2023-02-16)

### Bug Fixes

-  parsing newest commits first ([38237](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/3823765b3001466) Tomas Bjerre)  

## 1.77.2 (2023-01-04)

### Bug Fixes

-  allow space before : in commit message ([0c8b0](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/0c8b08672c8b921) Tomas Bjerre)  

## 1.77.1 (2022-12-28)

## 1.77.0 (2022-12-22)

### Features

-  Move file default to task ([d60f8](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/d60f89a90e7e079) SimonIT)  

### Bug Fixes

-  Set repo for GitChangelogSemanticVersionTask ([f8707](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/f8707ced3aece51) SimonIT)  

## 1.76.1 (2022-12-20)

### Bug Fixes

-  making semantic version match not greedy ([e5b3e](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/e5b3ec9b6f4232a) Tomas Bjerre)  

## 1.76.0 (2022-12-13)

### Features

-  Add root gradle project as default git repository directory ([4b859](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/4b859961321c347) SimonIT)  

## 1.75.0 (2022-12-03)

### Features

-  gitChangelogSemanticVersion ([22af4](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/22af4a7088bc329) Tomas Bjerre)  

## 1.74.0 (2022-12-03)

### Features

-  adjusting to Gradle 7.6 ([f0bc9](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/f0bc9823fa1e5a7) Tomas Bjerre)  [#40](https://github.com/tomasbjerre/git-changelog-gradle-plugin/issues/40)  

## 1.73.0 (2022-05-15)

### Features

-  enable partial templates by exposing missing Git Changelog lib properties ([1d6ed](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/1d6eddd48bd84ac) perrke)  

## 1.72.0 (2022-03-31)

### Features

-  prependToFile ([6fcf0](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/6fcf01c78fa7501) Tomas Bjerre)  

## 1.71.6 (2022-01-16)

### Bug Fixes

-  disable integrations with a boolean useIntegrations ([45e5f](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/45e5ff7ad187a14) Tomas Bjerre)  

## 1.71.5 (2022-01-05)

### Bug Fixes

-  only parse enabled issues ([b11ec](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/b11ec3d3d77758f) Tomas Bjerre)  

## 1.71.4 (2021-06-17)

### Bug Fixes

-  adding default changelog template jenkinsci/git-changelog-plugin#58 ([d0f2c](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/d0f2ce5982797b5) Tomas Bjerre)  

## 1.71.0 (2021-06-09)

### Bug Fixes

-  when file was in a new folder, it created folder ([caa23](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/caa231c47e6aa90) Tomas Bjerre)  

## 1.68.5 (2021-06-01)

### Bug Fixes

-  temporary removing plugins not working with Gradle 7 ([a2937](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/a293732ecf8ee92) Tomas Bjerre)  

## 1.68.2 (2021-05-31)

## 1.68.0 (2021-05-27)

### Features

-  support conventional commits ([ae011](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/ae0117c7db35ca5) Tomas Bjerre)  

### Other changes

**new build script**


[f1da2](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/f1da2169260afa8) Tomas Bjerre *2021-04-04 15:46:18*


## 1.66 (2021-03-29)

### Other changes

**pretty printing output JENKINS-65252**


[d85a2](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/d85a295ac2979fc) Tomas Bjerre *2021-03-29 15:48:00*


## 1.65 (2021-01-18)

### Other changes

**Removing default ignore filter on message**


[6b2f6](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/6b2f6f7d332ff2a) Tomas Bjerre *2021-01-18 17:04:59*

**doc**


[1eeda](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/1eedaff75faae6b) Tomas Bjerre *2019-10-09 16:58:05*

**Create FUNDING.yml**


[035d4](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/035d45bf48bf3fc) Tomas Bjerre *2019-09-28 06:58:22*

**Update README to use Plugin DSL**


[a4cb6](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/a4cb64c0e4c9184) Chad Vincent *2019-09-09 13:14:40*


## 1.64 (2019-08-13)

### Other changes

**Update .travis.yml**


[32f93](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/32f936846588f3b) Tomas Bjerre *2019-08-13 04:35:49*

**Set fromRepo property only if provided and after read settings file.**

* This will provide ability to override path to git repo from gradle script. 

[7d3d5](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/7d3d5d212468ca4) mdolinin *2019-08-13 00:22:29*


## 1.63 (2019-06-11)

### Other changes

**Removing dependency on javax.xml**


[3e003](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/3e0032c3034d3a5) Tomas Bjerre *2019-06-11 17:04:17*


## 1.62 (2019-06-11)

### Other changes

**JDK 11 compatible**


[f6341](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/f63417b07082607) Tomas Bjerre *2019-06-11 16:36:28*

**Updating tests**


[3c83f](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/3c83fe68d95357e) Tomas Bjerre *2019-05-20 15:07:55*


## 1.61 (2019-05-20)

### Other changes

**Gradle 5**


[bd073](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/bd0732f190bf807) Tomas Bjerre *2019-05-20 14:29:54*


## 1.60 (2019-01-08)

### Other changes

**Jira linked issues**


[2efc6](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/2efc65342c971e7) Tomas Bjerre *2019-01-08 18:01:20*


## 1.59 (2018-10-27)

### Other changes

**Correcting GitLab integration after upgrade**


[3954c](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/3954c5f904227ef) Tomas Bjerre *2018-10-27 17:56:49*


## 1.58 (2018-10-27)

### Other changes

**GitLab API v4**


[6cb50](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/6cb50b9bd7820be) Tomas Bjerre *2018-10-27 16:27:04*


## 1.57 (2018-10-27)

### Other changes

**isJira isGitHub...**


[7cc8f](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/7cc8f9e2bf3e675) Tomas Bjerre *2018-10-27 06:05:00*

**doc**


[8048d](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/8048d8372e8ecdf) Tomas Bjerre *2018-09-25 07:22:54*

**using latest version in example**


[9d898](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/9d898a9db72ae6d) Tomas Bjerre *2018-09-13 09:02:58*


## 1.56 (2018-09-13)

### Other changes

**git-changelog-lib 1.82**


[df304](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/df30491510ac279) Tomas Bjerre *2018-09-13 07:20:10*


## 1.55 (2017-12-30)

### Other changes

**Closing RevWalk JENKINS-19994**


[bd848](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/bd848b309dc2e0d) Tomas Bjerre *2017-12-30 20:38:52*

**Doc**


[4c348](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/4c348e84921ce41) Tomas Bjerre *2017-12-19 12:31:47*


## 1.54 (2017-12-19)

### Other changes

**Description available for Jira issues**


[08c31](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/08c318c4fe0b851) Tomas Bjerre *2017-12-19 12:10:36*

**Adjusting to Bintray**


[93d8d](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/93d8d88c9812987) Tomas Bjerre *2017-12-19 12:10:26*

**Doc**


[5ee1f](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/5ee1f247a7f4e79) Tomas Bjerre *2017-11-18 12:39:39*


## 1.53 (2017-11-18)

### Other changes

**Disabling integrations if not used**


[cc80c](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/cc80c59ea5010b1) Tomas Bjerre *2017-11-18 12:35:27*

**Doc**


[67998](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/67998f029dc2650) Tomas Bjerre *2017-11-02 17:18:14*


## 1.52 (2017-11-02)

### Other changes

**Avoiding usage of Guava Objects**


[d7f35](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/d7f352acc81683e) Tomas Bjerre *2017-11-02 17:14:15*

**Doc**


[6976a](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/6976aa12d53049e) Tomas Bjerre *2017-10-28 11:23:02*


## 1.51 (2017-10-28)

### Other changes

**Gradle publish plugin 0.9.9**


[a4f12](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/a4f123715188f61) Tomas Bjerre *2017-10-28 10:49:45*

**doc**


[05d90](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/05d90e9fdb837a6) Tomas Bjerre *2017-07-25 18:31:19*


## 1.50 (2017-07-25)

### Other changes

**Lib 1.71**


[9e423](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/9e42357f0f8a330) Tomas Bjerre *2017-07-25 18:27:12*

**doc**


[4ca8b](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/4ca8b778ad9ee34) Tomas Bjerre *2017-07-24 20:02:45*


## 1.49 (2017-07-24)

### Other changes

**Lib 1.70**


[eb32c](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/eb32cb7c632fd50) Tomas Bjerre *2017-07-24 19:43:57*

**doc**


[bc3d5](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/bc3d55a49f0cd22) Tomas Bjerre *2017-07-09 19:50:09*


## 1.48 (2017-07-08)

### Other changes

**Ignore commits older than #9**


[e185a](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/e185afe0630ecf2) Tomas Bjerre *2017-07-08 06:06:26*

**doc**


[109a6](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/109a63e61305810) Tomas Bjerre *2017-05-22 16:19:24*


## 1.47 (2017-05-22)

### Other changes

**Better handling of relative paths #7**


[a3e98](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/a3e98d30881c76e) Tomas Bjerre *2017-05-22 16:16:38*

**doc**


[ae98f](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/ae98fb5e6e74075) Your Name *2017-05-20 14:47:09*


## 1.46 (2017-05-20)

### Other changes

**Adding fromRepo attribute #8**


[e6560](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/e656098d86f5cbd) Your Name *2017-05-20 14:43:23*

**Using file(..) instead of new File(..) in examples #7**


[278bb](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/278bbaca992f908) Your Name *2017-05-20 14:14:53*

**doc**


[d0754](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/d0754c14ba30320) Tomas Bjerre *2017-04-14 09:24:18*


## 1.45 (2017-04-14)

### Other changes

**tag time added to tag model**


[d2196](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/d21964445069bf0) Tomas Bjerre *2017-04-14 09:20:14*

**doc**


[a9988](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/a998896882677cd) Tomas Bjerre *2017-03-26 05:10:01*


## 1.44 (2017-03-26)

### Other changes

**GitLab integration**


[636a4](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/636a45d1daba1f6) Tomas Bjerre *2017-03-26 05:07:07*

**doc**


[697ff](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/697ffb2c810657c) Tomas Bjerre *2017-03-20 18:43:51*


## 1.43 (2017-03-20)

### Other changes

**doc**


[65bbb](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/65bbb3948850167) Tomas Bjerre *2017-03-20 18:27:20*


## 1.42 (2017-03-20)

### Other changes

**Fix Jira labels**


[fe7e9](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/fe7e9fd812ead29) Tomas Bjerre *2017-03-20 18:20:36*

**doc**


[c542d](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/c542dfe71851922) Tomas Bjerre *2017-03-18 09:35:54*


## 1.41 (2017-03-18)

### Other changes

**Git Changelog Lib 1.58 -> 1.64**

* Jira issueType and labels 
* GitHub labels 
* 10 seconds timeout to GitHub 

[4b11b](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/4b11be4a5b1d298) Tomas Bjerre *2017-03-18 09:33:32*

**Set theme jekyll-theme-slate**


[57ad0](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/57ad0c56ec60af3) Tomas Bjerre *2017-02-07 20:20:13*

**doc**


[0f46e](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/0f46ec14274d48b) Tomas Bjerre *2016-10-22 10:33:53*


## 1.40 (2016-10-22)

### Other changes

**Adding annotation to context of tag**


[8b315](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/8b315d7b4d0c6e0) Tomas Bjerre *2016-10-22 10:27:44*

**doc**


[070be](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/070be300680768f) Tomas Bjerre *2016-10-05 19:30:09*


## 1.39 (2016-10-05)

### Other changes

**Adding merge boolean to commits**


[a91d6](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/a91d6410ac7ab39) Tomas Bjerre *2016-10-05 18:41:43*

**doc**


[da8b7](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/da8b749e115eadc) Tomas Bjerre *2016-08-11 14:40:21*


## 1.38 (2016-08-11)

### Other changes

**Correcting version**


[f2a73](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/f2a73d0ee6e4927) Tomas Bjerre *2016-08-11 14:37:02*


## 0 (2016-08-11)

### Other changes

**Lib 1.56 correcting link to Jira**


[cd6e0](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/cd6e07b6ba370ee) Tomas Bjerre *2016-08-11 14:33:12*

**Doc**


[803a5](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/803a5f64f400ba8) Tomas Bjerre *2016-08-02 18:29:21*


## 1.37 (2016-08-02)

### Other changes

**Adding {{hashFull}} variable**


[a8fef](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/a8fefac12cd4069) Tomas Bjerre *2016-08-02 18:27:12*

**doc**


[4e550](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/4e5509c1c1cf847) Tomas Bjerre *2016-06-25 00:20:39*


## 1.36 (2016-06-25)

### Other changes

**Faster**


[9f100](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/9f10076c152d8cc) Tomas Bjerre *2016-06-25 00:05:41*

**doc**


[d1e5d](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/d1e5df127614552) Tomas Bjerre *2016-06-24 21:19:09*


## 1.35 (2016-06-24)

### Other changes

**Fixing merge commits... again...**


[218dd](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/218ddf1dc0001f5) Tomas Bjerre *2016-06-24 21:17:20*

**doc**


[eb1f2](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/eb1f2d442d74fe5) Tomas Bjerre *2016-06-24 09:34:04*


## 1.34 (2016-06-24)

### Other changes

**Including commits from merges lib issue 49**


[08998](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/0899840508e7952) Tomas Bjerre *2016-06-24 09:32:25*

**Lib 1.49, finding first commit as parents from HEAD**


[31ec0](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/31ec07934bdad52) Tomas Bjerre *2016-06-02 18:28:34*


## 1.33 (2016-06-02)

### Other changes

**Lib 1.49, finding first commit as parents from HEAD**


[780b2](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/780b2da1a68f2bc) Tomas Bjerre *2016-06-02 18:23:12*

**doc**


[842eb](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/842eb75a106dbec) Tomas Bjerre *2016-05-20 19:16:48*


## 1.32 (2016-05-20)

### Other changes

**Ignoring trailing slash in JIRA URL**


[d4c8e](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/d4c8e11e93f50ce) Tomas Bjerre *2016-05-20 19:15:04*

**doc**


[9ab59](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/9ab59a6366cbba9) Tomas Bjerre *2016-04-13 18:47:25*


## 1.31 (2016-04-13)

### Other changes

**Lib 1.45**


[c4976](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/c497663d4baa276) Tomas Bjerre *2016-04-13 18:45:12*

**Lib 1.45**


[278e3](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/278e3ba5f42ef11) Tomas Bjerre *2016-04-13 18:44:42*

**doc**


[640ec](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/640ecdd01433b9f) Tomas Bjerre *2016-04-12 16:58:44*

**doc**


[2c18d](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/2c18de4dd5ab621) Tomas Bjerre *2016-04-12 16:57:43*


## 1.30 (2016-04-12)

### Other changes

**JENKINS-34155 Support short SHA**


[7d641](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/7d6410b3a5b9966) Tomas Bjerre *2016-04-12 16:56:23*

**doc**


[bd4bc](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/bd4bc7d6f9986f9) Tomas Bjerre *2016-04-10 09:15:03*


## 1.29 (2016-04-10)

### Other changes

**Lib 1.43, Parsing commits, oldest first**


[a492b](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/a492b1147ac9cd6) Tomas Bjerre *2016-04-10 09:13:22*


## 1.28 (2016-04-10)

### Other changes

**Lib 1.42, Parsing commits, oldest first**


[e0ff2](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/e0ff26d0d7eecfa) Tomas Bjerre *2016-04-10 09:03:30*

**Updating doc**


[e2e13](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/e2e13910a0a3eac) Tomas Bjerre *2016-04-09 20:41:52*


## 1.27 (2016-04-09)

### Other changes

**Lib 1.41, Commits added to correct tags**


[54707](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/54707a708f1ee79) Tomas Bjerre *2016-04-09 20:40:35*

**Updating example**


[dbfc6](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/dbfc64080f56afd) Tomas Bjerre *2016-04-07 19:08:48*


## 1.26 (2016-04-07)

### Other changes

**Lib 1.40 can ignore tags by regexp**


[87c1d](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/87c1dac2c4a9455) Tomas Bjerre *2016-04-07 19:06:38*

**Updating example**


[51888](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/5188838111d44c8) Tomas Bjerre *2016-03-20 09:55:38*


## 1.25 (2016-03-20)

### Other changes

**Lib 1.39**


[ecf09](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/ecf09f20a68bef2) Tomas Bjerre *2016-03-20 09:53:14*

**Updating example**


[f0117](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/f0117a163d745e4) Tomas Bjerre *2016-03-20 09:04:27*


## 1.24 (2016-03-20)

### Other changes

**Lib 1.38**


[c924b](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/c924b21e276fc6c) Tomas Bjerre *2016-03-20 09:01:00*

**Updating README**


[b26ce](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/b26ceab0de77b82) Tomas Bjerre *2016-03-16 16:21:01*


## 1.23 (2016-03-16)

### Other changes

**Jira integration to get titles**


[ba49a](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/ba49a437a58491c) Tomas Bjerre *2016-03-16 16:19:08*

**Update example**


[1731b](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/1731b0fd836186e) Tomas Bjerre *2016-03-15 21:09:38*


## 1.22 (2016-03-15)

### Other changes

**Updating release and publish plugins**


[6feac](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/6feacb255e8cf21) Tomas Bjerre *2016-03-15 21:07:59*

**Support GitHub OAuth2 token #4**


[e7396](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/e7396385437d9f8) Tomas Bjerre *2016-03-15 20:56:29*

**Updating CHANGELOG.md**


[36550](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/3655040d316782d) Tomas Bjerre *2016-02-28 10:47:04*


## 1.21 (2016-02-20)

### Other changes

**Supplying commit in each issue mentioned in message**


[bdbce](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/bdbce32f910fdc4) Tomas Bjerre *2016-02-20 08:44:05*

**Lib 1.30, supporting multiple tags on same commit**


[28826](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/2882668ea6ff82a) Tomas Bjerre *2016-02-15 18:15:17*


## 1.20 (2016-02-15)

### Other changes

**Lib 1.30, supporting multiple tags on same commit**


[bc538](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/bc538a1e94d21ac) Tomas Bjerre *2016-02-15 18:12:32*


## 1.19 (2016-02-14)

### Other changes

**Lib 1.29**


[32a88](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/32a88b23cc4c42f) Tomas Bjerre *2016-02-14 18:02:39*


## 1.18 (2016-02-13)

### Other changes

**Significant performance improvements**

* Using lib 1.27. 

[5e16e](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/5e16e88cf7a8fbd) Tomas Bjerre *2016-02-13 09:03:51*

**Updating README.md**


[03ae6](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/03ae6c70c40364f) Tomas Bjerre *2016-02-10 18:21:28*


## 1.17 (2016-02-10)

### Other changes

**Git changelog lib 1.25**

* Also updating README.md and changelog tempalte. 

[95a4d](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/95a4d3ea1c8df04) Tomas Bjerre *2016-02-10 18:19:01*

**Updating CHANGELOG.md after release**


[40baf](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/40baf9c5cdb12d8) Tomas Bjerre *2016-02-09 19:35:00*


## 1.16 (2016-02-09)

### Other changes

**Added variables: messageTitle, messageBody, messageItems #5**


[911a9](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/911a92eefbfc04c) Tomas Bjerre *2016-02-09 19:33:06*

**Updating CHANGELOG.md after release**


[8b01a](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/8b01ab7c2cc3510) Tomas Bjerre *2016-02-01 18:07:00*


## 1.15 (2016-02-01)

### Other changes

**Allowing custom issues not to include link**

* Adding example with issues like I123 

[cffcc](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/cffcc84f13f8305) Tomas Bjerre *2016-02-01 18:04:49*

**Updating README.md after release**


[b1e1a](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/b1e1a40dac37696) Tomas Bjerre *2016-01-31 21:23:20*


## 1.14 (2016-01-31)

### Other changes

**Maven Central version badge in README.md**


[f59f6](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/f59f6a980356765) Tomas Bjerre *2016-01-31 21:14:53*

**Updating README.md after release**


[287fc](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/287fce2b6c6d88a) Tomas Bjerre *2016-01-31 19:16:50*


## 1.13 (2016-01-31)

### Other changes

**Implementing custom issues**

* Adding example with 
* QC matching QC1234 
* Incident matching INC1234 

[1faeb](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/1faeb79fd585ebc) Tomas Bjerre *2016-01-31 18:25:09*

**Using readable tag name to extract version in mixed**


[0fceb](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/0fceb845d118e7f) Tomas Bjerre *2016-01-31 12:21:24*

**Updating README.md after release**


[a138c](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/a138c10787f8f38) Tomas Bjerre *2016-01-31 12:18:06*


## 1.12 (2016-01-31)

### Other changes

**Storing settings on each task #3**

* Also using lib 1.23 

[782ca](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/782cace31d3814f) Tomas Bjerre *2016-01-31 12:14:15*


## 1.11 (2016-01-31)

### Other changes

**lib 1.13**


[c5756](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/c57564c99e94ae3) Tomas Bjerre *2016-01-31 11:15:10*

**Documentation and lib 1.22**


[1fb8d](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/1fb8da49aee539f) Tomas Bjerre *2016-01-31 09:30:35*


## 1.10 (2015-12-06)

### Other changes

**Using lib 1.17 #1**


[b5801](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/b58012a56766e79) Tomas Bjerre *2015-12-06 07:40:52*

**doc**


[273b6](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/273b67ba969b42d) Tomas Bjerre *2015-12-04 22:58:53*


## 1.9 (2015-12-04)

### Other changes

**Using lib 1.15 #1**


[6daf3](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/6daf3e46b3c8e4b) Tomas Bjerre *2015-12-04 22:17:54*


## 1.8 (2015-12-01)

### Other changes

**using lib 1.14**


[160b7](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/160b7a55a498b6f) Tomas Bjerre *2015-12-01 21:45:40*

**doc**


[7d88c](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/7d88c89c3575bb8) Tomas Bjerre *2015-11-23 22:11:49*


## 1.7 (2015-11-23)

### Other changes

**using lib 1.13 #1**


[378d5](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/378d5ebbd4a0d29) Tomas Bjerre *2015-11-23 22:09:40*

**doc**


[1303f](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/1303f55cdbf330f) Tomas Bjerre *2015-11-23 18:14:55*


## 1.6 (2015-11-23)

### Other changes

**Using lib 1.12 #1**


[31b0e](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/31b0e8f2ca18e95) Tomas Bjerre *2015-11-23 18:11:30*

**doc**


[02682](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/02682e41e00cef3) Tomas Bjerre *2015-11-21 14:32:43*


## 1.5 (2015-11-21)

### Other changes

**lib 1.10**


[2ed54](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/2ed544c84145163) Tomas Bjerre *2015-11-21 14:31:35*


## 1.4 (2015-11-20)

### Other changes

**lib 1.9 #feature**


[44eea](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/44eea52c090958b) Tomas Bjerre *2015-11-20 22:10:47*

**Updating version in example**


[91674](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/91674a2a04cdc1f) Tomas Bjerre *2015-11-18 19:45:38*


## 1.3 (2015-11-18)

### Other changes

**lib 1.3**


[0e6eb](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/0e6eb5b4d8b359a) Tomas Bjerre *2015-11-18 19:43:32*

**Using 1.3-SNAPSHOT in example**


[087ce](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/087cecc26fdf9b0) Tomas Bjerre *2015-11-17 20:06:50*


## 1.2 (2015-11-17)

### Other changes

**MediaWiki support, using lib 1.2 #feature**


[ecc10](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/ecc10fdaf81330f) Tomas Bjerre *2015-11-17 19:59:29*

**Updating example plugin to use 1.2 snapshot**


[76ebb](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/76ebb6f8015ca43) Tomas Bjerre *2015-11-16 17:44:10*

**Changing release instructions.**

* There is currently a bug in Gradle release plugin plugin that requires the keys to be passed as parameters instead of gradle.properties. GRADLE-3281 

[69146](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/69146dc3ba2bfd7) Tomas Bjerre *2015-11-16 17:33:57*


## 1.1 (2015-11-16)

### Other changes

**Adding plugin plugin**


[3568f](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/3568f412a65a16d) Tomas Bjerre *2015-11-16 17:29:30*

**doc**


[9b485](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/9b485f708e30054) Tomas Bjerre *2015-11-15 13:12:46*


## 1.0 (2015-11-15)

### Other changes

**More work for 1.0**


[60e0d](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/60e0d7e7292969e) Tomas Bjerre *2015-11-15 13:01:25*

**Initial**


[a9bf2](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/a9bf29122e184a1) Tomas Bjerre *2015-11-14 20:15:20*

**Initial commit**


[5d7de](https://github.com/tomasbjerre/git-changelog-gradle-plugin/commit/5d7de6e3c378671) Tomas Bjerre *2015-11-14 19:50:29*


