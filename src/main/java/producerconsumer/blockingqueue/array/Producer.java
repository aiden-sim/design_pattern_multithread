package producerconsumer.blockingqueue.array;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        // We are adding elements using offer() in order to check if
        // it actually managed to insert them.
        for (int i = 0; i < 8; i++) {
            System.out.println("Trying to add to queue: String " + i +
                    " and the result was " + queue.offer("String " + i));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}