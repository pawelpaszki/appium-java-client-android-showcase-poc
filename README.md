# appium-java-client-android-showcase-poc

This is a POC automation test written using Appium and Java Client

## Prerequisites

- Appium installed 

```npm install -g appium```

and Appium server running

```appium```

- Java and Android studio installed and paths configured -> verify by executing the following:

```
echo $JAVA_HOME
echo $ANDROID_HOME
```

- Android Emulator running (tested on emulator running Android 8.1 -> emulator config is present in src/test/java/data/Config.java class and might need to be changed, if your emulator has different settings)

- Maven installed -> verify by:

```mvn --version```

Note:

As this is a POC, not all of the concepts are polished. The following needs attention:
- the first start of a webview during authentication test will end up in showing the 'accept and continue' screen, which will break the tests.
- without PIN set on an emulator, warning will also be shown and may break the tests
- in src/test/java/data/AuthPage.java you need to provide values for USERNAME and PASSWORD constants
- it may occur that the tests will fail some time, even though they usually pass - this still needs to be investigated

## To run the tests from Eclipse:

right click on test package and select *Run As JUnit test*

## To run from the terminal, enter into the root of the project and and execute the following command:

```mvn test```
