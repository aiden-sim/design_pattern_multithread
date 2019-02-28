package balking.exercise.exercise1;

public class Main {
    public static void main(String[] args) {
        Thread thread = new TestThread();
        while(true) {
            thread.start();
        }
    }
}
