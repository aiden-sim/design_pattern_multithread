package threadpermessage.exampl1;

/**
 * Host(역할)
 * Client 역할로부터 요구(request)를 받으면 새로 쓰레드를 만들어서 기동한다.
 * 새로 만들어진 쓰레드는 Helper 역할을 사용하여 요구를 처리(handle) 한다.
 * 요구에 대하여 쓰레드를 생성하는 클래스
 */
public class Host {
    private final Helper helper = new Helper();

    // 익명 내부 클래스 안에서 메소드의 인수나 지역변수를 이용하는 경우에는 변수를 final로 선언해 두어야 한다.(컴파일 에러)
    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        /**
         * run 메소드를 오버라이드한 Thread의 서브 클래스 선언
         * 그 클래스의 인스턴스를 생성
         * 그 인스턴스의 start 메소드를 호출하여 쓰레드 기동
         */
        new Thread() {
            public void run() {
                helper.handle(count, c);
            }
        }.start();
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
