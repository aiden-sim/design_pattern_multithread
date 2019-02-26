package singlethreaedexecution.example2;

/**
 * SharedResource (공유자원)
 * 문을 표현하는 클래스, 사람이 지나갈 때 이름과 출신지를 기록한다.
 * thread-safe 하다.
 */
public class Gate {
	// 통과한 사람 수
	private int counter = 0;
	// 마지막에 통과한 사람의 이름
	private String name = "Nobody";
	// 그 사람의 출신지
	private String address = "Nowhere";

	// 문을 통과하는 메소드 (synchronized 추가)
	public synchronized void pass(String name, String address) {
		this.counter++;
		this.name = name;
		this.address = address;
		check();
	}

	// synchronized 추가
	// toString이 synchronized한 이유는 잘못된 디버깅 정보를 줄 수 있기 때문에
	public synchronized String toString() {
		return "No." + counter + " : " + name + ", " + address;
	}

	// private 하고 pass에서만 호출하기 때문에 synchronized 하지 않아도 안전하다.
	private void check() {
		if (name.charAt(0) != address.charAt(0)) {
			System.out.println("*****BROKEN*****" + toString());
		}
	}

	// Gate 관점에서 이름과 출신지를 한번에 대입해야 되는데, 이렇게 되면 필드의 값이 달라질 수 있게 된다.
	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized void setAddress(String address) {
		this.address = address;
	}
}
