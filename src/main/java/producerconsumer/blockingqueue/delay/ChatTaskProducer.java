package producerconsumer.blockingqueue.delay;

import java.util.concurrent.DelayQueue;

public class ChatTaskProducer {

    private DelayQueue<ChatTask> chatQueue;

    public ChatTaskProducer(DelayQueue<ChatTask> chatQueue) {
        this.chatQueue = chatQueue;
    }

    public void produceChatTask(int delay, int currentPage) {

        ChatTask ct = new ChatTask(System.currentTimeMillis(),
                delay, currentPage);

        chatQueue.add(ct);
        System.out.println("added new task, page " + currentPage
                + " delay " + delay);
    }
}