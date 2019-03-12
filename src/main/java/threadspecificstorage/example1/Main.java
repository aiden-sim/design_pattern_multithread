package threadspecificstorage.example1;

/**
 * Thread-Specific Storage 패턴을 사용하지 않는 예
 * 동작 테스트용 클래스
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("BEGIN");
        for (int i = 0; i < 10; i++) {
            Log.println("main: i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        Log.close();
        System.out.println("END");
    }
}
