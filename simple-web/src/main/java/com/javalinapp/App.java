package com.javalinapp;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.javalin.Javalin;
import org.graalvm.nativeimage.VMRuntime;

public class App {

  @JsonSerialize
  record Response(String message) {}

  public static void main(String[] args) {
    var app = Javalin.create().start(8080);
    app.get("/", ctx -> ctx.json(new Response("Slava Ukraini!")));
    app.get("/heapdump", ctx -> ctx.json(new Response(createHeapDump())));
  }

  private static String createHeapDump() throws IOException {
    File file = File.createTempFile("SVMHeapDumpAPI-", ".hprof");
    VMRuntime.dumpHeap(file.getAbsolutePath(), false);
    return file.getAbsolutePath();
  }
}
