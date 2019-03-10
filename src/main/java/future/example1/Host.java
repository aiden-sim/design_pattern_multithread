package future.example1;

/**
 * Host 역할
 * Host 역할은 새로운 쓰레드를 만들고 RealData 역할을 만들기 시작
 * 그리고 Client 역할에는 Future 역할을 반환한다.
 * 리퀘스트에 대하여 FutureData의 인스턴스를 반환하는 클래스
 */
public class Host {
    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // 1) FutureData의 인스턴스를 만든다.
        final FutureData future = new FutureData();

        // 2) RealData의 인스턴스를 만들기 위한 새로운 쓰레드를 기동한다. (익명 내부 클래스)
        new Thread() {
            public void run() {
                RealData realData = new RealData(count, c);
                // 교환권을 가진 고객이 찾아 왔을 때를 위해 케이크를 준비해두는 것과 같다.
                future.setRealData(realData);
            }
        }.start();

        System.out.println("    request(" + count + ", " + c + ") END");

        // 3) FutureData의 인스턴스를 반환 값으로 한다.
        return future;
    }
}
