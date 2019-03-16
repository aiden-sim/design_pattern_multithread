package appendix.synchornized;

/**
 * x < y로 표시될 각능성은 사라진다.
 */
class Something {
    private int x = 0;
    private int y = 0;

    public synchronized void write() {
        x = 100;
        y = 50;
    }

    public synchronized void read() {
        if (x < y) {
            System.out.println("x < y");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        final Something obj = new Something();

        // 쓰기 쓰레드 A
        new Thread() {
            public void run() {
                obj.write();
            }
        }.start();

        // 읽기 쓰레드 B
        new Thread() {
            public void run() {
                obj.read();
            }
        }.start();
    }
}
