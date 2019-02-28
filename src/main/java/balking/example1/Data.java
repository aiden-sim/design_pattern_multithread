package balking.example1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * GuardedObject (가드 되어 있는 객체 역할)
 * 변경, 저장이 가능한 데이터를 나타내는 클래스
 */
public class Data {
    private final String filename; // 저장하는 파일명

    private String content;        // 데이터 내용

    private boolean changed;       // 변경한 내용이 저장되어 있으면 true (flag)

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    /**
     * 여기서 synchronized는 content와 changed를 보호 한다.
     */

    // 데이터 내용을 수정한다.
    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    // 데이터의 내용이 변경되었으면 파일에 저장한다.
    public synchronized void save() throws IOException {
        if (!changed) {
            System.out.println("balk");
            return; // 변경되지 않았으면 저장하지 않기 때문에 실제 balk 처리
        }
        doSave();
        changed = false;
    }

    // 데이터의 내용을 실제로 파일에 저장한다.
    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
