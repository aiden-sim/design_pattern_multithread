package producerconsumer.blockingqueue.priority;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        // Comparable
        PriorityBlockingQueue<Employee> PriorityBlockingQueue = new PriorityBlockingQueue<>();

        PriorityBlockingQueue.add(new Employee(1L, "AAA"));
        PriorityBlockingQueue.add(new Employee(4L, "CCC"));
        PriorityBlockingQueue.add(new Employee(5L, "BBB"));
        PriorityBlockingQueue.add(new Employee(2L, "FFF"));
        PriorityBlockingQueue.add(new Employee(3L, "DDD"));
        PriorityBlockingQueue.add(new Employee(6L, "EEE"));

        while (true) {
            Employee e = PriorityBlockingQueue.poll();
            System.out.println(e);

            if (e == null) break;
        }

        // Comparator
        Comparator<Employee> nameSorter = Comparator.comparing(Employee::getName);
        PriorityBlockingQueue<Employee> PriorityBlockingQueue2 = new PriorityBlockingQueue<>(11, nameSorter);

        PriorityBlockingQueue2.add(new Employee(1l, "AAA"));
        PriorityBlockingQueue2.add(new Employee(4l, "CCC"));
        PriorityBlockingQueue2.add(new Employee(5l, "BBB"));
        PriorityBlockingQueue2.add(new Employee(2l, "FFF"));
        PriorityBlockingQueue2.add(new Employee(3l, "DDD"));
        PriorityBlockingQueue2.add(new Employee(6l, "EEE"));

        while (true) {
            Employee e = PriorityBlockingQueue2.poll();
            System.out.println(e);

            if (e == null) break;
        }
    }
}
