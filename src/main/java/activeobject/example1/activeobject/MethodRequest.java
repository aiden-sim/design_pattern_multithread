package activeobject.example1.activeobject;

/**
 * MethodRequest 역할
 * 리퀘스트를 표현하는 추상 클래스 (능동적인 객체)
 */
abstract class MethodRequest<T> {
	protected final Servant servant; // 실제 처리
	protected final FutureResult<T> future; // 반환 값

	protected MethodRequest(Servant servant, FutureResult<T> future) {
		this.servant = servant;
		this.future = future;
	}

	public abstract void execute();
}
