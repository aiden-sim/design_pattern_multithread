package appendix.volatileEx;

/**
 * Done이라고 표시되지 않을 가능성이 있다.
 */
class Runner extends Thread {
    private volatile boolean quit = false;

    public void run() {
        while (!quit) {
            // ...
        }
        System.out.println("Done");
    }

    public void shutdown() {
        quit = true;
    }
}

public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner();

        // 쓰레드를 기동한다.
        runner.start();

        // 쓰레드를 종료한다.
        runner.shutdown();
    }
}
