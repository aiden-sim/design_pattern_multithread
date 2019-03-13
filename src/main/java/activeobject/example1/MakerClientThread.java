package activeobject.example1;

import activeobject.example1.activeobject.ActiveObject;
import activeobject.example1.activeobject.Result;

/**
 * Client(의뢰자) 역할
 * 문자열 작성을 의뢰하는 쓰레드 (이용자측)
 */
public class MakerClientThread extends Thread {
	private final ActiveObject activeObject;
	private final char fillchar;

	public MakerClientThread(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
		this.fillchar = name.charAt(0);
	}

	public void run() {
		try {
			for (int i = 0; true; i++) {
				// 반환 값이 있는 호출
				// 비동기 메시지를 능동적인 객체에게 보내는 것에 해당 (Future)
				Result<String> result = activeObject.makeString(i, fillchar);
				Thread.sleep(10);
				String value = result.getResultValue();
				System.out.println(Thread.currentThread().getName() + ": value = " + value);
			}
		} catch (InterruptedException e) {
		}
	}
}
