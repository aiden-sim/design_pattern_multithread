package activeobject.example1.activeobject;

/**
 * RealResult(실제 결과) 역할
 * 실제 실행결과를 표현하는 클래스 (능동적인 객체)
 */
class RealResult<T> extends Result<T> {
	private final T resultValue;

	public RealResult(T resultValue) {
		this.resultValue = resultValue;
	}

	public T getResultValue() {
		return resultValue;
	}
}
