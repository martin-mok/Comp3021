import java.io.*;
import java.util.Optional;
import java.util.Scanner;

public class Map {

    /**
     * This method saves to file a rectangular block of text (representing a map in PA1) based on the given dimensions.
     * Before saving the map, print out the number of rows on the first line, the number of columns on the second line,
     * and the actual block of text starting from the third line.
     *
     * @param filename The filename to save the block of text. Assume it includes the .txt extension.
     * @param map      The grid of chars to save
     * @throws IllegalArgumentException If # of rows < 3 or # cols < 3
     */
    public void createMap(String filename, char[][] map) throws IllegalArgumentException {

        try{
            if(map.length<3){
                throw new IllegalArgumentException();
            }else{
                for(int i=0;i<map.length;i++){
                    if (map[i].length<3) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            System.out.println(map.length);
            System.out.println(map[0].length);
            for(int i=0;i<map.length;i++){
                for(int j=0;j<map[i].length;j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            File f=new File(filename);
            f.createNewFile();
            var fw=new PrintStream(f);
            fw.println(map.length);
            fw.println(map[0].length);
            for(int i=0;i<map.length;i++){
                for(int j=0;j<map[i].length;j++){
                    fw.print(map[i][j]);
                }
                if(i<map.length-1) {
                    fw.println();
                }
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO
    }

    /**
     * Loads a map into a 2d char array. Note that the format of the text file will be the same
     * format as we saved it: first row  has an integer representing how many rows, second row has an integer
     * representing how many columns, and the rest of the rows is the actual block of text.
     *
     * @param filename The filename of the map
     * @param minRows  the minimum number of rows this map must have. If violated, throw BadMapException
     * @param minCols  the minimum number of cols this map must have. If violated, throw BadMapException
     * @return The 2d char representing the map.
     * @throws BadMapException if the minRows or minCols constraints are violated.
     */
    public char[][] loadMap(String filename, int minRows, int minCols) throws BadMapException {
        //TODO
        File f=new File(filename);
        try{
            Scanner sc = new Scanner(f);
            var row=Integer.parseInt(sc.nextLine());
            var col=Integer.parseInt(sc.nextLine());
            if(row<minRows||col<minCols){
                throw new BadMapException();
            }
            //System.out.println("pass");
            char[][] array=new char[row][col];
            for(int i=0;i<row;i++){
                if(sc.hasNextLine()){
                    String temp=sc.nextLine();
                    for(int j=0;j<col;j++){
                        array[i][j]=temp.charAt(j);
                    }
                }
            }
            sc.close();
            return array;
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return null; //You may also need to change this statement

    }


}
