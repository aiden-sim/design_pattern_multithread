package future.example2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Future(선물) 역할
 * Future 역할은 RealData 역할의 교환권으로, Host 역할에서 Client 역할로 건네진다.
 * RealData의 교환권이 되는 클래스, 다른 쓰레드에서 RealData의 인스턴스를 만든다.
 */
public class FutureData extends FutureTask<RealData> implements Data {
    public FutureData(Callable<RealData> callable) {
        super(callable);
    }

    @Override
    public String getContent() {
        String string = null;
        try {
            string = get().getContent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return string;
    }
}
