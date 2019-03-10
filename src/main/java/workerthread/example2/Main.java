package workerthread.example2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 동작 테스트용 클래스
 */
public class Main {
    public static void main(String[] args) {
        // Channel 역할
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try {
            new ClientThread("Alice", executorService).start();
            new ClientThread("Bobby", executorService).start();
            new ClientThread("Chris", executorService).start();

            // 5초 기다린다.
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        } finally {
            executorService.shutdown();
        }

    }
}