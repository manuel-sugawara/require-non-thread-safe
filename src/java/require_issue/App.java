package require_issue;


/**
 */
public class App {

    static final int THREADS = 10;

    public static void main(String[] args) throws Exception {
        Thread t0 = getThread(0);
        Thread t1 = getThread(1);

        t0.start();
        Thread.sleep(500);
        t1.start();
    }

    public static void main0(String[] args) throws Exception {
        Thread[]  threads = new Thread[THREADS];

        for (int x = 0; x < THREADS; x++) {
            threads[x] = getThread(x);
        }

        for (int x = 0; x < THREADS; x++) {
            threads[x].start();
        }
    }

    public static Thread getThread(final int x) {
        if ((x % 2) == 0) {
            return new Thread() {
                public void run() {
                    try {
                        String source = String.format("{\"foobar\": %s, \"barfoo\": %s}", x, x + 1);
                        System.out.printf("source '%s', result '%s'\n", source, FromJava0.readJson(source));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            };
        }

        return new Thread() {
            public void run() {
                try {
                    String source = String.format("{\"foobar\": %s, \"barfoo\": %s}", x, x + 1);
                    System.out.printf("source '%s', result '%s'\n", source, FromJava1.readJson(source));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
