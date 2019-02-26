package singlethreaedexecution.exercise.exercise6;

/**
 * 식기(스푼 또는 포크) 를 나타내는 클래스
 */
public class Tool {
	private final String name;

	public Tool(String name) {
		this.name = name;
	}

	@Override public String toString() {
		return "Tool{" +
				"name='" + name + '\'' +
				'}';
	}
}
