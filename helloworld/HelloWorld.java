import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello, Native World!");

    Thread thread1 = new Thread(() -> {
      try {
        System.out.println("Thread 1 is sleeping...");
        Thread.sleep(TimeUnit.MINUTES.toMillis(10));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }, "Thread-1");
    thread1.start();

    Thread thread2 = new Thread(() -> {
      try {
        System.out.println("Thread 2 is sleeping...");
        Thread.sleep(TimeUnit.MINUTES.toMillis(10));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }, "Thread-2");
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();

    }
  }

}