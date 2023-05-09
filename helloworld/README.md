#### Compile it and build a native executable from the Java class
```shell
 javac HelloWorld.java
 native-image --native-image-info HelloWorld
```
#### Run the application
```shell
./helloworld
```