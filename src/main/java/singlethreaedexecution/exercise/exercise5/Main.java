package singlethreaedexecution.exercise.exercise5;

public class Main {
	public static void main(String[] args) {
		System.out.println("Testing SecurityGate...");
		for (int trial = 0; true; trial++) {
			SecurityGate gate = new SecurityGate();
			CrackerThread[] t = new CrackerThread[5];
			// CrackerThread 기동
			for (int i = 0; i < t.length; i++) {
				t[i] = new CrackerThread(gate);
				t[i].start();
			}
			// CrackerThread 종료 대기
			for (int i = 0; i < t.length; i++) {
				try {
					t[i].join();
				} catch (InterruptedException e) {
				}
			}
			// 확인
			if (gate.getCounter() == 0) {
				// 모순되지 않는다
				System.out.print(".");
			} else {
				// 모순을 발견했다
				System.out.println("SecurityGate is NOT safe !");
				System.out.println("getCounter() == " + gate.getCounter());
				System.out.println("trial = " + trial);
				break;
			}
		}
	}
}
