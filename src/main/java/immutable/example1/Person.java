package immutable.example1;

/**
 * 사람을 나타내는 클래스
 * Immutable(불변의) 역할
 * 필드값을 변경할 수 없고 필드 내용을 변경하는 메소드도 가지고 있지 않은 클래스
 */
public final class Person {
	private final String name;

	private final String address;

	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	@Override public String toString() {
		return "PrintPersonThread{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
