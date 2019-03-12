package threadspecificstorage.example2;

/**
 * Client(의뢰자) 역할
 * Log를 호출하는 쓰레드를 나타내는 클래스
 */
public class ClientThread extends Thread {
    public ClientThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(getName() + " BEGIN");
        for (int i = 0; i < 10; i++) {
            Log.println("i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        Log.close();
        System.out.println(getName() + " END");
    }
}
