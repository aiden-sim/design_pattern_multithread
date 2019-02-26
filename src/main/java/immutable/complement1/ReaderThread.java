package immutable.complement1;

import java.util.List;

public class ReaderThread extends Thread {
    private List<Integer> list;

    public ReaderThread(List<Integer> list) {
        super("ReaderThread");
        this.list = list;
    }

    public void run() {
        while (true) {
            for (int n : list) {
                System.out.println(n);
            }
        }
    }
}
