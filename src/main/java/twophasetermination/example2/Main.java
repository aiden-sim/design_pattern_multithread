package twophasetermination.example2;

public class Main {
	public static void main(String[] args) {
		System.out.println("main:BEGIN");

		// 1) 캐치되지 않는 예외의 핸들러를 설정한다.
		Thread.setDefaultUncaughtExceptionHandler(
				new Thread.UncaughtExceptionHandler() {
					@Override public void uncaughtException(Thread thread, Throwable exception) {
						System.out.println("****");
						System.out.println("UncaughtExceptionHandler:BEGIN");
						System.out.println("currentThread =" + Thread.currentThread());
						System.out.println("thread = " + thread);
						System.out.println("exception = " + exception);
						System.out.println("UncaughtExceptionHandler:END");
					}
				}
		);

		// 2) 셧다운 후크를 설정한다.
		Runtime.getRuntime().addShutdownHook(
				new Thread() {
					public void run() {
						System.out.println("****");
						System.out.println("shutdown hook:BEGIN");
						System.out.println("currentThread = " + Thread.currentThread());
						System.out.println("shutdown hook:END");
					}
				}
		);

		// 3) 약 3초후에 0에 의한 정수의 나숫셈을 실행하는 쓰레드를 기동한다.
		new Thread("MyThread") {
			public void run() {
				System.out.println("MyThread:BEGIN");
				System.out.println("MyThread:SLEEP...");

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {

				}

				System.out.println("MyThread:DIVIDE");

				// 0에 의한 정수의 나눗셈
				int x = 1 / 0;

				// 여기 호출 안 됨
				System.out.println("MyThread::END");
			}
		}.start();

		System.out.println("main:END");
	}
}
