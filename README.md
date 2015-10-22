java-sauce-example
==================

> An example of using the [JUnit](http://junit.org/) test runner with [Sauce Labs](https://saucelabs.com)' automation cloud to run functional tests.

To get started, clone the repo:

```bash
git clone https://github.com/saucelabs/java-sauce-example.git && cd java-sauce-example
```

Then run the following command to build the project and run the assocaited tests (requires Maven to be installed in your PATH):

```bash
mvn test
```

### Example CI integration

This repo demonstrates using Sauce with Travis CI. Here is a status badge which shows the build status of this repo's master branch and links to the latest build:
[![Build Status](https://travis-ci.org/saucelabs/java-sauce-example.png?branch=master)](https://travis-ci.org/saucelabs/java-sauce-example)
