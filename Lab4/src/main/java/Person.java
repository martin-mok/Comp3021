package main.java;
public class Person {
    private String name;
    private int age;
    //TODO
    public Person(String name,int age){
        this.name=new String(name);
        this.age=age;
    }
    public String getName(){
        return new String(this.name);
    }
    public void setName(String name){
        this.name=new String(name);
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public String toString(){
        return "Person:{age:"+this.age+", name:"+this.name+"}";
    }
   }
