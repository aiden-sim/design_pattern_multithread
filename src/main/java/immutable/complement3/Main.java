package immutable.complement3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList
 * 카피 온 라이트(copy-on-write) 라는 시스템을 이용해 읽고 쓰기의 충돌을 억제한다.
 */
public class Main {
    public static void main(String[] args) {
        final List<Integer> list = new CopyOnWriteArrayList<>();
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
