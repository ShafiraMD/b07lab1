public class Employee extends Person{
    double salary;

    public Employee(String name, String address, double salary){
        super(name,address);
        this.salary = salary;
    }

    public void foo(){
        System.out.println("foo in Employee");
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }
}