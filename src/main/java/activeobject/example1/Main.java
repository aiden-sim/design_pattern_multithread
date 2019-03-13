package activeobject.example1;

import activeobject.example1.activeobject.ActiveObject;
import activeobject.example1.activeobject.ActiveObjectFactory;

/**
 * 동작 테스트용 클래스
 */
public class Main {
	public static void main(String[] args) {
		ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
		new MakerClientThread("Alice", activeObject).start();
		new MakerClientThread("Bobby", activeObject).start();
		new DisplayClientThread("Chris", activeObject).start();
	}
}
