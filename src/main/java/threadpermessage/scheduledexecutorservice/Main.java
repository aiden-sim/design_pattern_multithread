package threadpermessage.scheduledexecutorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Client(의뢰자) 역할
 * Host 역할에 대하여 요구(request)를 한다. Host 역할이 그 요구를 어떻게 실현하고 있는지 Client는 모른다.
 * Host에 문자표시를 요구하는 클래스
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");

        // ScheduledExecutorService 인터페이스는 ExecutorService의 서브 인터페이스이며 처리의 실행을 지연시킨다.
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        Host host = new Host(
                scheduledExecutorService
        );

        // Before / After 패턴
        try {
            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');
        } finally {
            scheduledExecutorService.shutdown();
            System.out.println("main END");
        }
    }
}
