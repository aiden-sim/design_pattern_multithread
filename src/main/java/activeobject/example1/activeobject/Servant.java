package activeobject.example1.activeobject;

/**
 * Servant(하인) 역할 : 실제 리퀘스트 처리
 * 실제 처리를 실행하는 클래스 (ActiveObject 인터페이스를 구현) (능동적인 객체)
 * 능동적인 객체가 실제로 실행할 수 있는 메소드 군
 */
class Servant implements ActiveObject {
	public Result<String> makeString(int count, char fillchar) {
		char[] buffer = new char[count];
		for (int i = 0; i < count; i++) {
			buffer[i] = fillchar;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
		}
		return new RealResult<String>(new String(buffer));
	}

	public void displayString(String string) {
		try {
			System.out.println("displayString: " + string);
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
	}
}
