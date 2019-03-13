package activeobject.example1.activeobject;

/**
 * Proxy(대리인) 역할
 * 메소드 호출을 MethodRequest 객체로 변환하는 클래스 (ActiveObject 인터페이스 구현) (능동적인 객체)
 * 메소드의 기동(invocation)과 실행(execution)의 분리에서 Proxy는 기동에 해당하는 처리를 한다.
 * 능동적인 객체에 대하여 기동할 수 있는 메소드 군
 */
class Proxy implements ActiveObject {
	private final SchedulerThread scheduler;
	private final Servant servant;

	public Proxy(SchedulerThread scheduler, Servant servant) {
		this.scheduler = scheduler;
		this.servant = servant;
	}

	@Override public Result<String> makeString(int count, char fillchar) {
		FutureResult<String> future = new FutureResult<String>();
		// Command 패턴과 비슷
		scheduler.invoke(new MakeStringRequest(servant, future, count, fillchar));
		return future;
	}

	@Override public void displayString(String string) {
		scheduler.invoke(new DisplayStringRequest(servant, string));
	}
}
