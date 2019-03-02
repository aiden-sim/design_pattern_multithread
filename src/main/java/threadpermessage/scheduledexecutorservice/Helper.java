package threadpermessage.scheduledexecutorservice;

/**
 * Helper(원조자) 역할
 * 요구를 처리(handle)하는 기능을 Host 역할에게 제공한다.
 * 문자표시라고 하는 기능을 제공하는 수동적인 클래스
 */
public class Helper {
    public void handle(int count, char c) {
        System.out.println("    handle(" + count + ", " + c + ") BEGIN");
        for (int i = 0; i < count; i++) {
            slowly();
            System.out.print(c);
        }
        System.out.println("");
        System.out.println("    handle(" + count + ", " + c + ") END");
    }

    private void slowly() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
