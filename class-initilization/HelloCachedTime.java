import java.util.Date;

public class HelloCachedTime {

  static final Date CACHED_TIME = Startup.TIME;

  public static void main(String[] args) {
    System.out.println("Startup: " + CACHED_TIME);
    System.out.println("Now:     " + new Date());
  }
}

class Startup {
  static final Date TIME = new Date();
}
