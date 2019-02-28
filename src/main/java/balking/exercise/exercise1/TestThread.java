package balking.exercise.exercise1;

/**
 * Thread start는 한번만 호출할 수 있고 start 내부에서 threadStatus로 상태 체크 하고 있다. balking
 * if (threadStatus != 0)
 * throw new IllegalThreadStateException();
 */
public class TestThread extends Thread {
    public void run() {
        System.out.println("BEGIN");
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("END");
    }
}
