package producerconsumer.blockingqueue.delay;

import java.util.concurrent.DelayQueue;

public class ChatTaskConsumer {

    private DelayQueue<ChatTask> chatQueue;
    private int currentPage;

    public ChatTaskConsumer(DelayQueue<ChatTask> chatQueue) {
        this.chatQueue = chatQueue;
    }

    public void startChatTaskConsumer() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                //take delayed tasks from the queue and process
                processChatTask();
            }
        }).start();
    }

    public void processChatTask() {
        try {
            while (currentPage < 15) {
                System.out.println("waiting for task");
                ChatTask ct = chatQueue.take();
                System.out.println("processing task page " + ct.getCurrentPage()
                        + " delay " + ct.getDelayDuration());

                //if user is on the same after the delay start chat window
                if (ct.getCurrentPage() == currentPage) {
                    initiateChat(ct);
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initiateChat(ChatTask ct) {
        System.out.println("hello, here to help you on page "
                + ct.getCurrentPage());
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

}
