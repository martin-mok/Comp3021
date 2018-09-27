package main.java;
public class Teacher extends Person {
    private String subject;
    private double salary;

    //TODO
    public Teacher(String name,int age, String subject,double salary){
        super(name, age);
        this.subject=new String(subject);
        this.salary=salary;
    }
    public String getSubject(){
        return new String(this.subject);
    }
    public void setSubject(String subject){
        this.subject=new String(subject);
    }
    public double getSalary(){
        return this.salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public String toString(){
        return "Teacher:{age:"+super.getAge()+", name:"+super.getName()+"ID:"+this.subject+", name:"+this.salary+"}";
    }
}
