package future.exercise4;

import java.util.concurrent.ExecutionException;

/**
 * Client(의뢰자) 역할
 * Client는 Host 역할에 하여 리퀘스트(request)를 제시한다.
 * 그 리퀘스트의 결과(반환 값)로서 Client 역할은 곧바로 VirtualData를 받아들인다. (Future)
 * Host에 리퀘스트를 제시하고 데이터를 구하는 클래스
 */
public class Main {
    public static void main(String[] args) throws ExecutionException {
        System.out.println("main BEGIN");
        Host host = new Host();
        // 교환권
        Data data1 = host.request(-1, 'N');

        System.out.println("main otherJob BEGIN");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("main otherJob END");

        // 교환권을 사용해서 결과값 얻어옴
        System.out.println("data1 = " + data1.getContent());
        System.out.println("main END");
    }
}
