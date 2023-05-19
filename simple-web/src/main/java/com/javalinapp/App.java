package com.javalinapp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.javalin.Javalin;
import io.javalin.http.Context;
import org.graalvm.nativeimage.VMRuntime;

public class App {

  @JsonSerialize
  record Response(String message) {}

  public static void main(String[] args) {
    var app = Javalin.create().start(8080);

    app.get("/", ctx -> ctx.json(new Response("Slava Ukraini!")));

    app.get("/heapdump", App::createHeapDump);
  }

  private static void createHeapDump(Context ctx) throws IOException {
    var dumpFile = File.createTempFile("SVMHeapDumpAPI-", ".hprof");
    VMRuntime.dumpHeap(dumpFile.getAbsolutePath(), false);
    var dumpBytes = Files.readAllBytes(dumpFile.toPath());
    var dumpFileName = dumpFile.getName();
    ctx.contentType("binary")
        .header("Content-Disposition", "attachment; filename=\""+dumpFileName+"\"")
        .result(dumpBytes);

  }
}
