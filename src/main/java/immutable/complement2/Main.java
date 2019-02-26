package immutable.complement2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections.synchronizedList 메소드에 의한 동기화
 */
public class Main {
    public static void main(String[] args) {
        final List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
