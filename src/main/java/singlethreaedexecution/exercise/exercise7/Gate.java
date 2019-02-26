package singlethreaedexecution.exercise.exercise7;

/**
 * Mutext 사용
 */
public class Gate {
	// 통과한 사람 수
	private int counter = 0;
	// 마지막에 통과한 사람의 이름
	private String name = "Nobody";
	// 그 사람의 출신지
	private String address = "Nowhere";

	private final Mutex2 mutext = new Mutex2();

	// 문을 통과하는 메소드
	public void pass(String name, String address) {
		mutext.lock();
		try {
			this.counter++;
			this.name = name;
			this.address = address;
			check();
		} finally {
			mutext.unlock();
		}
	}

	private void check() {
		if (name.charAt(0) != address.charAt(0)) {
			System.out.println("*****BROKEN*****" + toString());
		}
	}

	public String toString() {
		String s = null;
		mutext.lock();
		try {
			s = "No." + counter + " : " + name + ", " + address;
		} finally {
			mutext.unlock();
		}
		return s;
	}
}
