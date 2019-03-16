package appendix.reorder;

/**
 *  x < y로 표시될 가능성이 있는가?
 *  놀랍게도 Java의 메모리 모델에서는 x < y로 표시될 가능성이 있다.
 */
class Something {
    private int x = 0;
    private int y = 0;

    // 둘의 의존관계가 없기 때문에 컴파일러가 대입 순서를 바꾸어버릴 가능성이 있다. (reorder 때문에)
    public void write() {
        x = 100;
        y = 50;
    }

    public void read() {
        if (x < y) {
            System.out.println("x < y");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        final Something obj = new Something();

        // 쓰기 쓰레드 A
        new Thread() {
            public void run() {
                obj.write();
            }
        }.start();

        // 읽기 쓰레드 B
        new Thread() {
            public void run() {
                obj.read();
            }
        }.start();
    }
}
