package producerconsumer.example1;

/**
 * Channel (통신로) - 배타 제어
 * Producer 역할로부터 Data 역할을 받아서 보관한다.
 * 또한 Consumer 역할이 요구할 때 Data 역할을 건넨다.
 * 테이블을 나타내는 클래스
 */
public class Table {
    private final String[] buffer;
    private int tail;   // 다음에 put할 장소
    private int head;   // 다음에 take할 장소
    private int count;  // buffer 안의 케이크 수

    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = count;
    }

    // 케이크를 놓는다
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= buffer.length) {
            wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    // 케이크를 먹는다
    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " take " + cake);
        return cake;
    }
}
