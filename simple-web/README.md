Build jar
```shell
mvn clean compile assembly:single
```
```shell
java -agentlib:native-image-agent=config-output-dir=target/META-INF/native-image -jar ./tar
get/javalin-jar-with-dependencies.jar
```

Build native executable
```shell
mvn clean -Pnative -DskipTests package
```

