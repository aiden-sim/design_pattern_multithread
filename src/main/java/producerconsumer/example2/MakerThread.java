package producerconsumer.example2;

import java.util.Random;

/**
 * Producer (생성자)
 * Data 역할을 작성하여 Channel 역할에 건넨다.
 * 요리사를 나타내는 클래스
 */
public class MakerThread extends Thread {
    private final Random random;
    private final Table table;
    private static int id = 0;

    public MakerThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000)); // 만드는 시간
                // Data
                String cake = "[ Cake No." + nextId() + "by " + getName() + " ]";
                table.put(cake);
            }
        } catch (InterruptedException e) {
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
