package twophasetermination.example1;

/**
 * TerminationRequester(종료 요구를 제시하는 사람) 역할
 * 동작 테스트용 클래스
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("main : BEGIN");
		try {
			// 쓰레드 기동
			Countupthread t = new Countupthread();
			t.start();

			// 조금 시간을 비워둔다.
			Thread.sleep(10000);

			// 쓰레드의 종료 요구
			System.out.println("main : shutdownRequest");
			t.shutdownRequest();

			System.out.println("main: join");

			//쓰레드의 종료를 기다린다.
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main : END");
	}
}
