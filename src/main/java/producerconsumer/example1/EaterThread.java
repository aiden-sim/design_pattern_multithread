package producerconsumer.example1;

import java.util.Random;

/**
 * Consumer (소비자)
 * Channel 역할로부터 Data 역할을 받아 이용한다.
 * 손님을 나타내는 클래스
 */
public class EaterThread extends Thread {
    private final Random random;

    private final Table table;

    public EaterThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while (true) {
                String cake = table.take();
                // Data
                Thread.sleep(random.nextInt(1000)); // 먹는 시간
            }
        } catch (InterruptedException e) {
        }
    }
}
