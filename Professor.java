public class Professor extends Employee{
    String rank;
    
    public Professor(String name, String address, double salary, String rank){
        //System.out.println();
        super(name, address, salary);
        this.rank = rank;
    }

    

}