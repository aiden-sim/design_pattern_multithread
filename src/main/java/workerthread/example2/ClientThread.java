package workerthread.example2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/**
 * Client(의뢰자) 역할
 * 업무를 리퀘스트 하는 쓰레드를 나타내는 클래스
 * Request 인스턴스를 만든다
 * 만든 Request 인스턴스를 Channel 클래스의 putRequest 메소드에 전달한다.
 */
public class ClientThread extends Thread {
    private final ExecutorService executorService;
    private static final Random random = new Random();

    public ClientThread(String name, ExecutorService executorService) {
        super(name);
        this.executorService = executorService;
    }

    public void run() {
        try {
            for (int i = 0; true; i++) {
                Request request = new Request(getName(), i);
                executorService.execute(request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {

        } catch (RejectedExecutionException e) {
            System.out.println(getName() + " : " + e);
        }
    }
}
