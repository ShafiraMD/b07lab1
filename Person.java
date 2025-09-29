public class Person {
    String name;
    String address;

    public Person(){

    }

    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    public void foo(){
        System.out.println("foo in Person");
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(String address){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }
}