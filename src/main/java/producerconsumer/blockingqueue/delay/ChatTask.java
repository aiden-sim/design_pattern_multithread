package producerconsumer.blockingqueue.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class ChatTask implements Delayed {

    private int delayDuration;
    private long startTime;
    private int currentPage;

    public ChatTask(long startTime, int delayDuration, int currentPage) {
        this.startTime = startTime;
        this.delayDuration = delayDuration;
        this.currentPage = currentPage;
    }

    @Override
    public int compareTo(Delayed delayObj) {

        if (this.getDelay(null) > delayObj.getDelay(null)) {
            return 1;
        }
        return -1;
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        if (System.currentTimeMillis() - startTime > delayDuration) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getDelayDuration() {
        return delayDuration;
    }

}