package guardedsuspension.exercise.exercise5;

public class TalkThread extends Thread {
	private final RequestQueue input;

	private final RequestQueue output;

	public TalkThread(RequestQueue input, RequestQueue output, String name) {
		super(name);
		this.input = input;
		this.output = output;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + ":BEGIN");
		for (int i = 0; i < 20; i++) {
			// 상대로부터 리퀘스트를 받는다
			Request request1 = input.getReuqest();
			System.out.println(Thread.currentThread().getName() + " gets : " + request1);

			// 느낌표(!)를 한 개 붙여서 상대방에서 돌려준다.
			Request request2 = new Request(request1.getName() + ":");
			System.out.println(Thread.currentThread().getName() + " puts : " + request2);
			output.putRequest(request2);
		}
		System.out.println(Thread.currentThread().getName() + ":END");
	}
}
