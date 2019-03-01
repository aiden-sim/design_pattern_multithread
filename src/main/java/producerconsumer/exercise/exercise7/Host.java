package producerconsumer.exercise.exercise7;

public class Host {
    public static void main(String[] args) {
        // Host 무거운 처리를 실행하는 쓰레드
        Thread exeuctor = new Thread() {
            public void run() {
                System.out.println("Host.executoe BEGIN");
                try {
                    Host.execute(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Host.executoe END");
            }
        };
        exeuctor.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 취소 실행
        System.out.println("***** interrupt *****");
        exeuctor.interrupt();
    }

    public static void execute(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            doHeavyJob();
        }
    }

    private static void doHeavyJob() {
        System.out.println("doHeavyJob BEGIN");
        long start = System.currentTimeMillis();
        while (start + 10000 > System.currentTimeMillis()) {
            // busy loop
        }
        System.out.println("doHeavyJob END");
    }
}
