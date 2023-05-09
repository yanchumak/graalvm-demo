#### Compile it and build a native executable from the Java class
```shell
 javac ReflectionExample.java
 native-image ReflectionExample #native-image --no-fallback ReflectionExample
```
#### Run the application
```shell
./reflectionexample
```

### Generate 
```shell
java -agentlib:native-image-agent=config-output-dir=META-INF/native-image ReflectionExample StringReverser reverse "hello"
```