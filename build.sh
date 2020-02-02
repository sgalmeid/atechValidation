find . -name "pom.xml" -exec mvn clean verify -f '{}' \;
find . -name "pom.xml" -exec mvn -Dmaven.test.skip package -f '{}' \;

