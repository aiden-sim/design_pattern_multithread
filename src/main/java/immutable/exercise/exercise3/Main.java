package immutable.exercise.exercise3;

public class Main {
    private static final long CALL_COUNT = 1000000000L;

    public static void main(String[] args) {
        trial("NotSynch", CALL_COUNT, new NotSynch());
        trial("Synch", CALL_COUNT, new Synch());
    }


    private static void trial(String msg, long count, Object obj) {
        System.out.println(msg + " : BEGIN");
        long start_time = System.currentTimeMillis();
        for (long i = 0; i < count; i++) {
            obj.toString();
        }
        System.out.println(msg + ": END");
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start_time) + "msec.");
    }
}

class NotSynch {
    private final String name = "NotSynch";

    @Override
    public String toString() {
        return "NotSynch{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Synch {
    private final String name = "Synch";

    @Override
    public synchronized String toString() {
        return "Synch{" +
                "name='" + name + '\'' +
                '}';
    }
}