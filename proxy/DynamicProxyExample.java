import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class DynamicProxyExample {

  public static void main(String[] args) throws Exception {
    var proxy = new DynamicProxyExample();
    var interfaces = new Class<?>[]{Callable.class};
    var callable = proxy.wrap(() -> "Hello dynamic proxy", interfaces);
    System.out.println(callable.call());
  }

  public Callable<?> wrap(Callable<?> callable, Class<?>[] interfaces) {
    var classLoader = DynamicProxyExample.class.getClassLoader();
    var handler = new LoggingInvocationHandler<Callable<?>>(callable);
    return (Callable<?>)
        Proxy.newProxyInstance(classLoader, interfaces, handler);
  }

  private record LoggingInvocationHandler<T>(T wrapped) implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      System.out.println(
          "Before invocation of " + method.getName() + ", parameters: " + Arrays.toString(args));
      var result = method.invoke(wrapped, args);
      System.out.println("After invocation of " + method.getName() + ", result: " + result);
      return result;
    }
  }
}