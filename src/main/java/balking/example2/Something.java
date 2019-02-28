package balking.example2;

/**
 * 초기화 처리를 한 번만 실행하는 클래스 (stateChangingMethod 가 없는 경우)
 */
public class Something {
    // 이 처럼 단 한 번만 상태가 변하는 변수를 일반적으로 래치(latch)라고 합니다.
    private boolean initialized = false;

    public synchronized void init() {
        // Guarded Suspension 패턴을 사용할 경우
        // 여기서 Guarded Suspension 패턴을 사용하는 것은 잘못된 것이다.
        // 이 클래스에서는 한 번 충족되지 못한 가드 조건이 다시 충족되는 일은 절대 없기 때문이다.
        /*
        while(initialized) {
            wait();
        }
        */

        if (initialized) {
            return;
        }
        doInit();
        initialized = true;
    }

    private void doInit() {
        // 실제 초기화 처리
    }
}
