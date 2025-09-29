public class Driver3 {
    public static void main(String[] args) {
        Employee e = new Employee("abc", "toronto", 1000);
        System.out.println(e.getName());
        e.foo();
    }
}