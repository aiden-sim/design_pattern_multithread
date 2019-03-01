package producerconsumer.example2;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Channel (통신로) - 배타 제어
 * Producer 역할로부터 Data 역할을 받아서 보관한다.
 * 또한 Consumer 역할이 요구할 때 Data 역할을 건넨다.
 * 테이블을 나타내는 클래스
 * <p>
 * ArrayBlockingQueue 사용
 */
public class Table extends ArrayBlockingQueue<String> {

    public Table(int capacity) {
        super(capacity);
    }

    @Override
    public void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "puts" + cake);
        super.put(cake);
    }

    @Override
    public String take() throws InterruptedException {
        String cake = super.take();
        System.out.println(Thread.currentThread().getName() + "takes" + cake);
        return cake;
    }
}
