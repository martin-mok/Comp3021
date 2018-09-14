import java.util.Arrays;
import java.util.Objects;


public class BusCompany {
    private String name;
    private int numBusses;
    private static int numCompanies;
    private int arraySize = 5;
    private Bus[] busses;

    BusCompany(String name) {
        this.name = name;
        numCompanies++;
        busses=new Bus[arraySize];
    }

    public String getName(){
        String outname=new String(this.name);
        return outname;
    }

    public boolean createAndAddBus(int id, String model){
        Bus bus=new Bus(id, model);
        for(int i=0;i<arraySize;i++){
            if(busses[i]!=null) {
                if (busses[i].getID() == id) {
                    return false;
                }
            }
        }
        for(int i= 0;i<arraySize;i++){
            if(busses[i]==null){
                busses[i]=bus;
                return true;
            }
        }
        return false;
    }
    public void removeAllBusses(){
        for(int i=0;i<arraySize;i++){
            busses[i]=null;
        }
    }
    public static int getNumCompanies(){
        return numCompanies;
    }

}