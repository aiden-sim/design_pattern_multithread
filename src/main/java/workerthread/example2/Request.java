package workerthread.example2;

import java.util.Random;

/**
 * Request(의뢰) 역할, Worker(작업자) 역할
 */
public class Request implements Runnable {
    private final String name;  // 의뢰자
    private final int number;   // 리퀘스트 번호
    private static final Random random = new Random();

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " execute " + this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
        }
    }

    public String toString() {
        return "[ Request from " + name + " No." + number + " ]";
    }
}
