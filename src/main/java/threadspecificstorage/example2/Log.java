package threadspecificstorage.example2;

/**
 * TSObjectProxy(쓰레드 고유 객체의 대리인)
 * TSObjectProxy 역할은 TSObjectCollection 역할을 이용하여 Client 역할에 대응하는 TSObject 역할을 취득
 * 그리고 처리를 TSOBject 역할에 위임한다.
 * 로그를 작성하는 클래스 (쓰레드를 분할한다)
 */
public class Log {
    // 쓰레드를 자동적으로 판별한다.
     // TSObjectCollect(쓰레드 고유 객체의 집합) 역할
    // Client 역할과 TSObject 역할의 대응표를 가지고 있다.
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();

    // 로그를 적는다.
    public static void println(String s) {
        getTSLog().println(s);
    }

    // 로그를 닫는다.
    public static void close() {
        getTSLog().close();
    }

    // 쓰레드 고유의 로그를 구한다.
    private static TSLog getTSLog() {
        TSLog tsLog = tsLogCollection.get();

        // 그 쓰레드에서 처음 호출하는 것이라면 신규로 작성하여 등록한다.
        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }
        return tsLog;
    }
}
