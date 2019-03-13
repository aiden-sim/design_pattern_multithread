package activeobject.example1;

import activeobject.example1.activeobject.ActiveObject;

/**
 * Client(의뢰자) 역할
 * 문자열 표시를 의뢰하는 쓰레드 (이용자측)
 */
public class DisplayClientThread extends Thread {
	private final ActiveObject activeObject;

	public DisplayClientThread(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
	}

	public void run() {
		try {
			for (int i = 0; true; i++) {
				String string = Thread.currentThread().getName() + " " + i;
				// 반환 값이 없는 호출 (Future 아님)
				activeObject.displayString(string);
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
		}
	}
}
