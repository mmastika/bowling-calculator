# bowling-calculator
- Calculates the current score of a game given a string of input
- If game is not complete, assumes 0 for the rest of the rolls

## Dependency
- Java 1.8+
- Gradle

## How to test & compile
Windows: gradlew.bat clean build
Mac(OSX) / Linux : ./gradlew clean build

## How to run app after compilation
java -cp build/libs/bowling-calculator-1.0-SNAPSHOT.jar vda.App "<space separated values>"

e.g. java -cp build/libs/bowling-calculator-1.0-SNAPSHOT.jar vda.App "1 2 3 4"