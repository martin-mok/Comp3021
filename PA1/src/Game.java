
import Exceptions.InvalidMapException;
import Map.*;
import Map.Occupant.Crate;
import Map.Occupiable.DestTile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Holds the necessary components for running the game.
 */
public class Game {

    private Map m;
    private int numRows;
    private int numCols;
    private char[][] rep;

    /**
     * Loads and reads the map line by line, instantiates and initializes Map m.
     * Print out the number of rows, then number of cols (on two separate lines).
     *
     * @param filename the map text filename
     * @throws InvalidMapException
     */
    public void loadMap(String filename) throws InvalidMapException {
        //TODO
        Scanner sc= null;
        try {
            sc = new Scanner(new File(filename));

            int row=sc.nextInt();
            int col=sc.nextInt();
            System.out.println(row);//delete
            System.out.println(col);//delete
            this.numRows=row;
            this.numCols=col;
            rep=new char[this.numCols][this.numRows];//[x][y]||||
            sc.nextLine();
            for(int r=0;r<this.numRows;r++){
                String line=sc.nextLine();
                //System.out.println(line);//delete
                for(int c=0;c<this.numCols;c++){
                    rep[c][r]=line.charAt(c);
                }
            }
            m=new Map();
            m.initialize(this.numRows,this.numCols,this.rep);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            sc.close();
        }

    }

    /**
     * Can be done using functional concepts.
     * @return Whether or not the win condition has been satisfied
     */
    public boolean isWin() {
        //TODO
        return false; // You may also modify this line.
    }

    /**
     * When no crates can be moved but the game is not won, then deadlock has occurred.
     *
     * @return Whether deadlock has occurred
     */
    public boolean isDeadlocked() {
        //TODO
        return false; // You may also modify this line.
    }

    /**
     * Print the map to console
     */
    public void display() {
        for(int i=0;i<this.numRows;i++){
            for(int j=0;j<this.numCols;j++){
                System.out.print(this.rep[j][i]);
            }
            System.out.println();
        }
        //TODO

    }

    /**
     * @param c The char corresponding to a move from the user
     *          w: up
     *          a: left
     *          s: down
     *          d: right
     *          r: reload map (resets any progress made so far)
     * @return Whether or not the move was successful
     */
    public boolean makeMove(char c) {
        //TODO
        return false; // You may also modify this line.
    }


}
