package producerconsumer.interrupt;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Alice a1 = new Alice();
        a1.start();
        System.out.println(a1.isInterrupted());
        a1.interrupt();
        System.out.println(a1.isInterrupted());
    }
}

class Alice extends Thread {

    @Override
    public void run() {
        System.out.println("start");
    }
}