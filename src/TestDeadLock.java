import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestDeadLock {

    String str1 = "Java";
    String str2 = "UNIX";


    Runnable runnable1 = () -> {
        while (true) {
            synchronized (str1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (str2) {
                    System.out.println(str1 + str2);
                }
            }
        }
    };
    Thread thread1 = new Thread(runnable1);

    Runnable runnable2 = () ->  {
        while (true) {
            synchronized (str2) {
                synchronized (str1) {
                    System.out.println(str2 + str1);
                }
            }
        }
    };
    Thread thread2 = new Thread(runnable2);


    public static void main(String a[]) {
        TestDeadLock mdl = new TestDeadLock();
        mdl.thread1.start();
        mdl.thread2.start();

        HashMap<String, String> test = new HashMap<>(1);
        test.forEach((k,v)-> System.out.println(k+v));
        test.entrySet().stream().forEach((k) -> System.out.println(k.getKey()+k.getValue()));

        Set<String> strings = test.keySet();
        Collection<String> values = test.values();



        Optional<String> r = Optional.of(name());

        r.ifPresent(n -> System.out.println(n));

        Executor executor = Executors.newFixedThreadPool(10);

        ((ExecutorService) executor).submit(()->{

        });

    }

    public static String name(){
        return "rahul";
    }
}
