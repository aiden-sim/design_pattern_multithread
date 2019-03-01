package readwritelock.exampl1;

/**
 * 읽으려 하는 쓰레드를 나타내는 클래스
 */
public class ReaderThread extends Thread {
    private final Data data;

    public ReaderThread(Data data) {
        this.data = data;
    }

    public void run() {
        try {
            while (true) {
                char[] readbuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readbuf));
            }
        } catch (InterruptedException e) {
        }
    }
}
