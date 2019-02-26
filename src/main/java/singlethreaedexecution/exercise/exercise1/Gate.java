package singlethreaedexecution.exercise.exercise1;

/**
 * Counter 값이 커지기 전에 에러를 검출하게 수정
 */
public class Gate {
	// 통과한 사람 수
	private int counter = 0;
	// 마지막에 통과한 사람의 이름
	private String name = "Nobody";
	// 그 사람의 출신지
	private String address = "Nowhere";

	// 문을 통과하는 메소드
	public void pass(String name, String address) {
		this.counter++;
		this.name = name;
		// 크리티컬 섹션을 길게 만들면 에러 검출 가능성을 높일 수 있다. 동일 락에서 전체 Sleep이 걸린다.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.address = address;
		check();
	}

	public String toString() {
		return "No." + counter + " : " + name + ", " + address;
	}

	private void check() {
		if (name.charAt(0) != address.charAt(0)) {
			System.out.println("*****BROKEN*****" + toString());
		}
	}
}
