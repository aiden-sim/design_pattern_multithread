package activeobject.example1.activeobject;

/**
 * ActiveObject(능동적인 객체)역할
 * 능동적인 객체의 인터페이스(API)를 규정하는 인터페이스 (능동적인 객체)
 */
public interface ActiveObject {
	public abstract Result<String> makeString(int count, char fillchar);

	public abstract void displayString(String string);
}
