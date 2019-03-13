package activeobject.example1.activeobject;

/**
 * ConcreateMethodRequest 역할
 * makeString 메소드(문자열 작성)에 대응하는 클래스, MethodRequest 클래스의 서브 클래스 (능동적인 객체)
 */
class MakeStringRequest extends MethodRequest<String> {
	private final int count;
	private final char fillchar;

	public MakeStringRequest(Servant servant, FutureResult<String> future, int count, char fillchar) {
		super(servant, future);
		this.count = count;
		this.fillchar = fillchar;
	}

	// 실행
	@Override public void execute() {
		Result<String> result = servant.makeString(count, fillchar);
		future.setResult(result);
	}
}
