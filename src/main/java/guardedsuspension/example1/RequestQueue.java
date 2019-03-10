package guardedsuspension.example1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * GuardedObject(보호받고 있는 객체)
 * 리퀘스트를 순서대로 비축해 두는 클래스
 * FIFO 구조 (선입선출)
 */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();

    // Single Threaded Execution
    // guardMethod : 조건 만족하면 실행, 조건 만족하지 않으면 wait
    public synchronized Request getReuqest() {
        while (queue.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        // 요소가 없으면 NoSuchElementException
        return queue.remove();
    }

    // Single Threaded Execution
    // stateChangingMethod : 인스턴스의 상태 변화 notifyAll
    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
}
