#### Compile it and build a native executable from the Java class
```shell
 javac DynamicProxyExample.java
 native-image DynamicProxyExample #native-image --no-fallback DynamicProxyExample
```
#### Run the application
```shell
./dynamicproxyexample
```

### Generate 
```shell
java -agentlib:native-image-agent=config-output-dir=META-INF/native-image DynamicProxyExample
```