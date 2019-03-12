package threadspecificstorage.example2;

/**
 * 동작 테스트용 클래스
 */
public class Main {
    public static void main(String[] args) {
        new ClientThread("Alice").start();
        new ClientThread("Bobby").start();
        new ClientThread("Chris").start();
    }
}
