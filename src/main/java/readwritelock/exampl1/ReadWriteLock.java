package readwritelock.exampl1;

/**
 * 읽고 쓰기의 락을 제공하는 클래스
 * 읽기와 쓰기의 충돌 (read-write conflict 고려)
 * 쓰기와 쓰기의 충돌 (write-write conflict 고려)
 */
public final class ReadWriteLock {
    private int readingReaders = 0; // (A) 실제로 읽고 있는 중인 쓰레드의 수
    private int waitingWriters = 0; // (B) 쓰기를 기다리고 있는 쓰레드의 수
    private int writingWriters = 0; // (C) 실제로 쓰고 있는 중인 쓰레드의 수
    private boolean preferWriter = true; // 쓰는 것을 우선하면 true

    // 가드 조건 - 읽기 처리를 하고 있는 쓰레드가 없을 것
    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        readingReaders++;   // (A) 실제로 읽고 있는 쓰레드의 수를 한 개 늘린다.

    }

    public synchronized void readUnlock() {
        readingReaders--;   // (A) 실제로 읽고 있는 쓰레드의 수를 한 개 줄인다.
        preferWriter = true;
        notifyAll();

    }

    // 가드 조건 - 읽기 처리나 쓰기 처리를 하고 있는 쓰레드가 없을 것
    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;   // (B) 쓰기를 기다리고 있는 쓰레드의 수를 한 개 늘린다.
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--;   // (B) 쓰기를 기다리고 있는 쓰레드의 수를 한 개 줄인다.
        }
        writingWriters++;       // (C) 실제로 쓰고 있는 쓰레드의 수를 한 개 늘린다.
    }

    public synchronized void writeUnlock() {
        writingWriters--;   // (C) 실제로 쓰고 있는 쓰레드의 수를 한 개 줄인다.
        preferWriter = false;
        notifyAll();
    }
}
