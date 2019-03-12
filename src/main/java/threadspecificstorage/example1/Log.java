package threadspecificstorage.example1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 로그를 작성하는 클래스
 */
public class Log {
    private static PrintWriter writer = null;

    // writer 필드의 초기화
    static {
        try {
            writer = new PrintWriter(new FileWriter("log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 로그를 적는다.
    public static void println(String s) {
        writer.println(s);
    }

    // 로그를 닫는다.
    public static void close() {
        writer.println("=== End of log ===");
        writer.close();
    }
}
