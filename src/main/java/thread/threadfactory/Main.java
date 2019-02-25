package thread.threadfactory;

import thread.runnable.Printer;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {
	public static void main(String[] args) {
		ThreadFactory factory = Executors.defaultThreadFactory();
		factory.newThread(new Printer("Nice")).start();
	}
}
