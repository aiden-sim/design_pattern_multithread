package activeobject.example1.activeobject;

/**
 * ConcreateMethodRequest 역할
 * displayString 메소드(문자열표시)에 대응하는 클래스, MethodRequets 클래스의 서브 클래스 (능동적인 객체)
 */
class DisplayStringRequest extends MethodRequest<Object> {
	private final String string;

	public DisplayStringRequest(Servant servant, String string) {
		super(servant, null);
		this.string = string;
	}

	// 실행
	public void execute() {
		servant.displayString(string);
	}
}
