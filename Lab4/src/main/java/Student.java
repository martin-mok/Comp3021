package main.java;
public class Student extends Person {
    private int id;
    private String major;

    //TODO
    public Student(String name,int age, int id,String major){
        super(name, age);
        this.id=id;
        this.major=new String(major);
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getMajor(){
        return this.major;
    }
    public void setMajor(String major){
        this.major=new String(major);
    }
    public String toString(){
        return "Student:{age:"+super.getAge()+", name:"+super.getName()+"ID:"+this.id+", name:"+this.major+"}";
    }
   }
