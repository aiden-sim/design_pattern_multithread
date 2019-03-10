package guardedsuspension.example1;

import java.util.Random;

/**
 * 리퀘스트를 접수하는 클래스
 */
public class ServerThread extends Thread {
    private final Random random;

    private final RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = requestQueue.getReuqest();
            System.out.println(Thread.currentThread().getName() + " handles " + request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {

            }
        }
    }
}
