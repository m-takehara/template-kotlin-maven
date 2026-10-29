# Gauge Kotlin / Maven template

A template for writing [Gauge](https://docs.gauge.org/) specifications in Kotlin using the Gauge Java runner.

## Prerequisites

- JDK 25 or later
- Gauge 1.6.41 and its Java and HTML report plugins
- Maven 3.9 or later

Install the plugins matching the dependencies in `pom.xml`:

```sh
gauge install java --version 1.0.3
gauge install html-report --version 4.4.7
```

## Create a project

Download `kotlin_maven.zip` from the [latest release](https://github.com/m-takehara/template-kotlin-maven/releases/latest), create an empty directory and run:

```sh
gauge init /path/to/kotlin_maven.zip
```

## Run specifications

```sh
mvn clean test
```

The HTML report is in `reports/html-report/`. To filter scenarios, use `mvn test -Dtags="single word"`. Run `mvn test-compile` after changing Kotlin steps when using Gauge's IDE integration.

## Release

CI tests both the repository and a project created from the packaged template. Push a version tag such as `v0.0.5` to run those checks and publish the ZIP and its SHA-256 checksum as a GitHub release. Update `metadata.json` to the same version before tagging.
