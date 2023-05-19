import java.util.Random;

public class HelloWorldLoop {
  public static void main(String[] args) throws InterruptedException {
    while (true) {
      System.out.println("Iteration...");
      someImportantMethod();
    }
  }
  static void someImportantMethod() {
    System.out.println("Random " + new Random().nextInt());
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
