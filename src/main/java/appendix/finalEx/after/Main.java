package appendix.finalEx.after;

class Something {
    // final한 인스턴스 필드
    private final int x;

    // 클래스 필드
    // last에는 생성자가 종료한 다음의 인스턴스가 대입되므로 final 필드는 정상적으로 초기화가 끝난 상태임을 보증할 수 있게 된다.
    private static Something last = null;

    // 생성자
    private Something() {
        // final 필드를 명시적으로 초기화 한다.
        x = 123;
        // 클래스 필드에 작성중인 인스턴스(this)를 보관한다.
        last = this;
    }

    // new로 구한 인스턴스를 last에 대입한다
    public static Something create() {
        last = new Something();
        return last;
    }

    // last 경유하여 final 필드의 값을 표시한다.
    public static void print() {
        if (last != null) {
            System.out.println(last.x);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 쓰레드 A
        new Thread() {
            public void run() {
                Something.create();
            }
        }.start();

        // 쓰레드 B
        new Thread() {
            public void run() {
                Something.print();
            }
        }.start();
    }
}
