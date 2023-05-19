#### Compile and build a native executable from the Java class
```shell
 javac HelloWorld.java
 native-image --native-image-info HelloWorld
```

#### Compile with dump for Dashboard tool
```shell
native-image -H:DashboardDump=dashboard.dump -H:+DashboardAll HelloWorld
```

#### Run the application
```shell
./helloworld
```

#### Compile, build native image and run for thread dump
```shell
javac HelloWorldLoop.java
native-image -g -H:+SourceLevelDebug  HelloWorldLoop
gdb ./helloworldloop
```

#### Compile and build native image for recording CPU/RAM samples
```shell
javac HelloWorldLoop.java
native-image -H:-DeleteLocalSymbols -H:+PreserveFramePointer HelloWorldLoop exec-for-perf
```

Record CPU samples
```shell
ps aux | grep exec-for-perf # take PID
perf record  -p <PID> -g  --call-graph dwarf sleep 10
```