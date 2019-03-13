package activeobject.example1.activeobject;

/**
 * 능동적인 객체를 생성하는 클래스 (능동적인 객체)
 */
public class ActiveObjectFactory {
	public static ActiveObject createActiveObject() {
		Servant servant = new Servant(); // 실제 처리를 수행하는 클래스(ActiveObject 구현)
		ActivationQueue queue = new ActivationQueue(); // MethodRequest 객체를 질서 정연하게 보관하는 클래스
		SchedulerThread scheduler = new SchedulerThread(queue); // MethdRequest 객체를 execute 하는 클래스
		Proxy proxy = new Proxy(scheduler, servant);    // 메소드 호출을 MethodRequest의 객체로 변환하는 클래스(ActiveObject 인터페이스 구현)
		scheduler.start();
		return proxy;
	}
}
