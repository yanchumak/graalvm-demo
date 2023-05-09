import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;

public class TruffleJs {
  public static void main(String[] args) {
    try (var context = Context.create()) {
      var jsCode = """
          function sum(...theArgs) {
            let total = 0;
            for (const arg of theArgs) {
              total += arg;
            }
            return total;
          }
          sum(1, 2, 3)
          """;
      var source = Source.create("js", jsCode);
      var result = context.eval(source);
      System.out.println("Result: " + result.asInt());
    }
  }
}
