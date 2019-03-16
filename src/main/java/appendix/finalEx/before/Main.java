package appendix.finalEx.before;

class Something {
    // final한 인스턴스 필드
    private final int x;

    // 클래스 필드
    private static Something last = null;

    // 생성자
    // Java 메모리 모델은 생성자가 종료할 때 final 필드의 값이 정상적으로 초기화되고 다른 쓰레드에 visible 됨을 보증한다.
    // 그러나 생성자가 종료하기 전 단계는 this가 완성되지 않은 상태여서 final 필드의 올바른 값이 다른 쓰레드에 visible 된다고 장담할 수 없다.
    public Something() {
        // final 필드를 명시적으로 초기화 한다.
        x = 123;
        // 클래스 필드에 작성중인 인스턴스(this)를 보관한다.
        last = this;
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
                new Something();
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
