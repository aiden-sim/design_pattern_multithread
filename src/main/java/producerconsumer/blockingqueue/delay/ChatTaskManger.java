package producerconsumer.blockingqueue.delay;

import java.util.Random;
import java.util.concurrent.DelayQueue;

/**
 * 참고) http://www.zoftino.com/java-delayqueue-example
 */
public class ChatTaskManger {
    private int currentPage;

    public static void main(String[] args) {
        ChatTaskManger taskManger = new ChatTaskManger();
        taskManger.initiateChat();
    }

    public void initiateChat() {
        DelayQueue<ChatTask> chatQueue = new DelayQueue<ChatTask>();

        //start consumer
        ChatTaskConsumer consumer = new ChatTaskConsumer(chatQueue);
        consumer.startChatTaskConsumer();

        //instantiate producer
        ChatTaskProducer producer = new ChatTaskProducer(chatQueue);

        //limit number of elements being sent to queue
        while (currentPage < 15) {
            //simulate user clicking next page
            //after spending some time on current page
            waitForPageChange();

            currentPage++;
            System.out.println("user on page " + currentPage);

            //produce chat task delayed element and add it to queue
            producer.produceChatTask(getWaitTime(), currentPage);
            consumer.setCurrentPage(currentPage);
        }
    }

    public void waitForPageChange() {
        try {
            Thread.sleep(getWaitTime() * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getWaitTime() {
        Random random = new Random();
        int rval = random.nextInt((10 - 1) + 1) + 1;
        return rval * 100;
    }
}
