package producerconsumer.blockingqueue.priority;

public class Employee implements Comparable<Employee> {

    private Long id;

    private String name;

    public Employee(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Employee emp) {
        return this.getId().compareTo(emp.getId());
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }
}
