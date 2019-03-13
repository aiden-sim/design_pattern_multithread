package activeobject.example1.activeobject;

/**
 * Future(선물) 역할
 * Future 패턴으로 실행결과를 표현하는 클래스 (능동적인 객체)
 */
class FutureResult<T> extends Result {
	private Result<T> result;
	private boolean ready = false;

	public synchronized void setResult(Result<T> result) {
		this.result = result;
		this.ready = true;
		notifyAll();

	}

	@Override public synchronized T getResultValue() {
		while (!ready) {
			try {
				wait();
			} catch (InterruptedException e) {

			}
		}
		return result.getResultValue();
	}
}
