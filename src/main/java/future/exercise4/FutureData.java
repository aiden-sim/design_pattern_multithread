package future.exercise4;

import java.util.concurrent.ExecutionException;

/**
 * Future(선물) 역할
 * Future 역할은 RealData 역할의 교환권으로, Host 역할에서 Client 역할로 건네진다.
 * RealData의 교환권이 되는 클래스, 다른 쓰레드에서 RealData의 인스턴스를 만든다.
 */
public class FutureData implements Data {
    private RealData realData = null;
    private ExecutionException exception = null;
    private boolean ready = false;

    public synchronized void setRealData(RealData realdata) {
        if (ready) {
            return; // balk
        }
        this.realData = realdata;
        this.ready = true;
        notifyAll();
    }

    public synchronized void setException(Throwable throwable) {
        if (ready) {
            return;
        }
        this.exception = new ExecutionException(throwable);
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized String getContent() throws ExecutionException {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        if (exception != null) {
            throw exception;
        }
        return realData.getContent();
    }
}
