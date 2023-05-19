Build jar
```shell
mvn clean compile assembly:single
```

Run agent to create build configuration
```shell
java -agentlib:native-image-agent=config-output-dir=src/main/resources/META-INF/native-image -jar ./target/javalin-jar-with-dependencies.jar
```

Build native executable
```shell
mvn clean -Pnative -DskipTests package
```


Build native executable image(buildx can be omitted if you don't have docker-buildx-plugin)
```shell
docker buildx build -t localhost/javalin:native.01 --build-arg EXECUTABLE_PATH=./target/javalin -f dockerfile-native .
```

Build native executable based on disroless image
```shell
docker buildx build -t localhost/javalin:native.01 --build-arg EXECUTABLE_PATH=./target/javalin -f dockerfile-native-distroless .
```

Run docker image with native 
```shell
docker run -p8080:8080 localhost/javalin:native.01
```

