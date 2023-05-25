Build native executable
```shell
mvn -Pnative native:compile
```

Build docker image 
```shell
mvn -Pnative spring-boot:build-image
```

Start application with AOT 
```shell
java -Dspring.aot.enabled=true -jar ./target/spring-native-test-0.0.1-SNAPSHOT.jar
```

Build docker image using Paketo Buildpacks
```shell 
pack build --builder paketobuildpacks/builder:tiny --path target/spring-native-0.0.1-SNAPSHOT.jar  --env 'BP_NATIVE_IMAGE=true' spring-native:0.0.1-SNAPSHOT
```