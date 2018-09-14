import java.util.Random;
import java.util.Scanner;
class haha{
    public int radius;
    public haha(){
        this(new Random().nextInt(10));
    }
    public haha(int rad){
        this.radius=rad;
    }
    public void saySomething(){
        System.out.println("haha");
    }
    public void sayrad(){
        System.out.println(radius);
    }
}

public class main {
    public static void main(String args[]){
        var sc=new Scanner(System.in);
        for(int i=0;i<10;i++){
            new haha().sayrad();
        }
    }
}
