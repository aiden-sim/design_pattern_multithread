package balking.guardedtimed;

import java.util.concurrent.TimeoutException;

/**
 * 타임아웃이 설정된 Host 클래스
 */
public class Host {
    private final long timeout; // 타임아웃 값
    private boolean read = false; // 메소드를 실행해도 되면 true

    public Host(long timeout) {
        this.timeout = timeout;
    }

    // 상태를 변경한다.
    public synchronized void setExecutable(boolean on) {
        read = on;
        notifyAll();
    }

    // 상태를 고려하여 실행한다.
    public synchronized void execute() throws InterruptedException, TimeoutException {
        long start = System.currentTimeMillis(); // 개시 시작
        while (!read) {
            long now = System.currentTimeMillis(); // 현재 시각
            long rest = timeout - (now - start);

            if (rest <= 0) {
                new TimeoutException("now - start = " + (now - start) + ", timeout = " + timeout);
            }
            wait(rest);
        }
        doExecute();
    }

    // 실제 처리
    private void doExecute() {
        System.out.println(Thread.currentThread().getName() + " calls doExecute");
    }
}
