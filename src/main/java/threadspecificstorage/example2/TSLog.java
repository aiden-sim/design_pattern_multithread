package threadspecificstorage.example2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TSObject(쓰레드 고유의 객체) 역할 (메소드는 싱글 쓰레드에서 호출)
 * 쓰레드 고유의 정보를 보관한다.
 * 로그를 작성하는 클래스 (인스턴스는 각 쓰레드에서 소유한다.)
 */
public class TSLog {
    private PrintWriter writer = null;

    // writer 필드의 초기화
    public TSLog(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 로그를 적는다
    public void println(String s) {
        writer.println(s);
    }

    // 로그를 닫는다.
    public void close() {
        writer.println("=== End Of Log ===");
        writer.close();
    }
}
