package readwritelock.exampl1;

import java.util.Random;

/**
 * 쓰려고 하는 쓰레드를 나타내는 클래스
 */
public class WriterThread extends Thread {
    private static final Random random = new Random();
    private final Data data;
    private final String filter;
    private int index = 0;

    public WriterThread(Data data, String filter) {
        this.data = data;
        this.filter = filter;
    }

    public void run() {
        try {
            while (true) {
                char c = nextchar();
                data.write(c);
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextchar() {
        char c = filter.charAt(index);
        index++;
        if (index >= filter.length()) {
            index = 0;
        }
        return c;
    }

}
