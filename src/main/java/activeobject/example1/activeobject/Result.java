package activeobject.example1.activeobject;

/**
 * VirtualResult(가상의 결과) 역할
 * 실행결과를 표현하는 추상 클래스 (능동적인 객체)
 * Future 패턴의 VirtualData 역할
 */
public abstract class Result<T> {
	public abstract T getResultValue();
}
