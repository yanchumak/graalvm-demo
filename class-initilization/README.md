#### Compile and build a native executable from the Java class
```shell
javac HelloWorld.java
native-image -H:+PrintClassInitialization --initialize-at-build-time=HelloCachedTime HelloCachedTime
```

