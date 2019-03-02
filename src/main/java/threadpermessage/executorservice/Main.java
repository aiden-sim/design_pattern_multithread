package threadpermessage.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Client(의뢰자) 역할
 * Host 역할에 대하여 요구(request)를 한다. Host 역할이 그 요구를 어떻게 실현하고 있는지 Client는 모른다.
 * Host에 문자표시를 요구하는 클래스
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");

        // ExecutorService 방식
        // Executor 방식도 결국 new Thread를 실행했다. 그러나 잘 생각해보면 쓰레드를 매번 생성해야만 하는 것은 아니다.
        // Executor 인터페이스만 보호하고 있으면 처리의 실행을 마치고 쉬고 있는  쓰레드를 재사용하는 클래스를 사용해도 상관 없다.
        // 그래서 등장한 것이 ExecutorService 인터페이스 이다.
        ExecutorService executorService = Executors.newCachedThreadPool();
        Host host = new Host(
                executorService
        );

        // Before / After 패턴
        try {
            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');
        } finally {
            // ExeuctorServiec 인터페이스의 배후에는 대체로 쓰레드가 항상 동작하고 있기 때문에 서비스 종료용으로 shutdown 메소드가 준비되어 있다.
            executorService.shutdown();
            System.out.println("main END");
        }
    }
}
