package threadpermessage.executor;

import java.util.concurrent.Executor;

/**
 * Host(역할)
 * Client 역할로부터 요구(request)를 받으면 새로 쓰레드를 만들어서 기동한다.
 * 새로 만들어진 쓰레드는 Helper 역할을 사용하여 요구를 처리(handle) 한다.
 * 요구에 대하여 쓰레드를 생성하는 클래스
 */
public class Host {
    private final Helper helper = new Helper();
    private final Executor executor;

    public Host(Executor executor) {
        this.executor = executor;
    }

    // 익명 내부 클래스 안에서 메소드의 인수나 지역변수를 이용하는 경우에는 변수를 final로 선언해 두어야 한다.(컴파일 에러)
    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        // ThreadFactory 인터페이스는 쓰레드 생성의 상세 내용을 감추고 있지만 쓰레드를 생성하는 것 자체는 감추지 않았다.
        // Executor 인터페이스를 이용하면 쓰레드의 생성까지도 감출 수 있다.
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count, c);
                    }
                }
        );
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
