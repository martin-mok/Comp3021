package Map;

import Exceptions.InvalidMapException;
import Exceptions.InvalidNumberOfPlayersException;
import Exceptions.UnknownElementException;
import Map.Occupant.Crate;
import Map.Occupant.Player;
import Map.Occupiable.DestTile;
import Map.Occupiable.Occupiable;
import Map.Occupiable.Tile;

import java.util.ArrayList;

/**
 * A class holding a the 2D array of cells, representing the world map
 */
public class Map {
    private Cell[][] cells;
    private ArrayList<DestTile> destTiles = new ArrayList<>();
    private ArrayList<Crate> crates = new ArrayList<>();

    private Player player;

    /**
     * This function instantiates and initializes cells, destTiles, crates to the correct map elements (the # char
     * means a wall, @ the player, . is unoccupied Tile, lowercase letter is crate on a Tile,
     * uppercase letter is an unoccupied DestTile).
     *
     * @param rows The number of rows in the map
     * @param cols The number of columns in the map
     * @param rep  The 2d char array read from the map text file
     * @throws InvalidMapException Throw the correct exception when necessary. There should only be 1 player.
     */
    public void initialize(int rows, int cols, char[][] rep) throws InvalidMapException {
        //TODO
        cells=new Cell[cols][rows];
        ArrayList<Cell> walllist=new ArrayList<Cell>();
        ArrayList<Character> destlist=new ArrayList<Character>();
        ArrayList<Character> cratelist=new ArrayList<Character>();
        int numplayer=0;//check whether there are only 1 player
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                if(rep[i][j]=='#'){
                    cells[i][j]=new Wall();
                    walllist.add(cells[i][j]);
                }else if(Character.isUpperCase(rep[i][j])) {
                    cells[i][j] = new DestTile(rep[i][j]);
                    destlist.add(rep[i][j]);
                }else{
                    //cells[i][j]=new Tile();
                    if(rep[i][j]=='@') {
                        Tile tile = new Tile();
                        this.player=new Player(j, i);
                        tile.setOccupant(this.player);
                        cells[i][j] = tile;
                        numplayer++;
                    }else if(rep[i][j]=='.'){
                        cells[i][j] = new Tile();
                    }else if(Character.isLowerCase(rep[i][j])){
                        Tile tile=new Tile();
                        tile.setOccupant(new Crate(j,i,rep[i][j]));
                        cells[i][j]=tile;
                        cratelist.add(rep[i][j]);
                    }else {
                        throw new UnknownElementException("there is a unknown element on your map: "+rep[i][j]);
                    }
                }
            }
        }
        //error check
        //multiple player
        //crate dest id missmatch;
        ////wall not close(start with the first wall on the list, check nearby have wall or not, if have add this to list, and move to the other for check then compare list)
        if(numplayer>1){
            throw new InvalidNumberOfPlayersException("you have number of Player>1");
        }else{
            for(char c:destlist) {
                if (!cratelist.contains(Character.toLowerCase(c))){
                    throw new UnknownElementException("your crate id is mismatch with dest id");
                }
            }
        }
    }

    public ArrayList<DestTile> getDestTiles() {
        return destTiles;
    }

    public ArrayList<Crate> getCrates() {
        return crates;
    }

    public Cell[][] getCells() {
        return cells;
    }

    /**
     * Attempts to move the player in the specified direction. Note that the player only has the strength to push
     * one crate. It cannot push 2 or more crates simultaneously. The player cannot walk through walls or walk beyond
     * map coordinates.
     *
     * @param d The direction the player wants to move
     * @return Whether the move was successful
     */
    public boolean movePlayer(Direction d) {
        //TODO
        if(d==Direction.UP) {
            if(player.getR()==0){
                return false;
            }else if(cells[player.getC()][player.getR()-1]instanceof Wall){
                return false;
            }else if(cells[player.getC()][player.getR()-1]instanceof Tile){
                var tile=(Tile)cells[player.getC()][player.getR()-1];
                if(tile.getOccupant().isPresent()){
                    if(moveCrate((Crate) tile.getOccupant().get(),d)){
                        tile.setOccupant(player);
                        Tile orgtile=(Tile)cells[player.getC()][player.getR()];
                        orgtile.removeOccupant();
                        player.setPos(player.getR()-1,player.getC());
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    tile.setOccupant(player);
                    Tile orgtile=(Tile)cells[player.getC()][player.getR()];
                    orgtile.removeOccupant();
                    player.setPos(player.getR()-1,player.getC());
                    return true;
                }
            }
        }else if(d==Direction.DOWN) {
            if(player.getR()==cells[0].length){
                return false;
            }else if(cells[player.getC()][player.getR()+1]instanceof Wall){
                return false;
            }else if(cells[player.getC()][player.getR()+1]instanceof Tile){
                var tile=(Tile)cells[player.getC()][player.getR()+1];
                if(tile.getOccupant().isPresent()){
                    if(moveCrate((Crate) tile.getOccupant().get(),d)){
                        tile.setOccupant(player);
                        Tile orgtile=(Tile)cells[player.getC()][player.getR()];
                        orgtile.removeOccupant();
                        player.setPos(player.getR()+1,player.getC());
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    tile.setOccupant(player);
                    Tile orgtile=(Tile)cells[player.getC()][player.getR()];
                    orgtile.removeOccupant();
                    player.setPos(player.getR()+1,player.getC());
                    return true;
                }
            }
        }else if(d==Direction.LEFT) {
            if(player.getC()==0){
                return false;
            }else if(cells[player.getC()-1][player.getR()]instanceof Wall){
                return false;
            }else if(cells[player.getC()-1][player.getR()]instanceof Tile){
                var tile=(Tile)cells[player.getC()-1][player.getR()];
                if(tile.getOccupant().isPresent()){
                    if(moveCrate((Crate) tile.getOccupant().get(),d)){
                        tile.setOccupant(player);
                        Tile orgtile=(Tile)cells[player.getC()][player.getR()];
                        orgtile.removeOccupant();
                        player.setPos(player.getR(),player.getC()-1);
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    tile.setOccupant(player);
                    Tile orgtile=(Tile)cells[player.getC()][player.getR()];
                    orgtile.removeOccupant();
                    player.setPos(player.getR(),player.getC()-1);
                    return true;
                }
            }
        }else if(d==Direction.RIGHT) {
            if(player.getC()==cells.length){
                return false;
            }else if(cells[player.getC()+1][player.getR()]instanceof Wall){
                return false;
            }else if(cells[player.getC()+1][player.getR()]instanceof Tile){
                var tile=(Tile)cells[player.getC()+1][player.getR()];
                if(tile.getOccupant().isPresent()){
                    if(moveCrate((Crate) tile.getOccupant().get(),d)){
                        tile.setOccupant(player);
                        Tile orgtile=(Tile)cells[player.getC()][player.getR()];
                        orgtile.removeOccupant();
                        player.setPos(player.getR(),player.getC()+1);
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    tile.setOccupant(player);
                    Tile orgtile=(Tile)cells[player.getC()][player.getR()];
                    orgtile.removeOccupant();
                    player.setPos(player.getR(),player.getC()+1);
                    return true;
                }
            }
        }
        return false; // You may also modify this line.
    }

    /**
     * Attempts to move the crate into the specified direction by 1 cell. Will only succeed if the destination
     * implements the occupiable interface and is not currently occupied.
     *
     * @param c The crate to be moved
     * @param d The desired direction to move the crate in
     * @return Whether or not the move was successful
     */
    private boolean moveCrate(Crate c, Direction d) {
        //TODO
        if(d==Direction.UP){
            if(c.getR()==0){
                return false;
            }
            var postarget=cells[c.getC()][c.getR()-1];
            if(postarget instanceof Wall) {
                return false;
            }
            if(((Tile) postarget).getOccupant().isPresent()){
                return false;
            }else{
                ((Tile) postarget).setOccupant(c);
                ((Tile)cells[c.getC()][c.getR()]).removeOccupant();
                c.setPos(c.getR()-1,c.getC());
                return true;
            }
        }
        if(d==Direction.DOWN){
            if(c.getR()==cells[0].length){
                return false;
            }
            var postarget=cells[c.getC()][c.getR()+1];
            if(postarget instanceof Wall) {
                return false;
            }
            if(((Tile) postarget).getOccupant().isPresent()){
                return false;
            }else{
                ((Tile) postarget).setOccupant(c);
                ((Tile)cells[c.getC()][c.getR()]).removeOccupant();
                c.setPos(c.getR()+1,c.getC());
                return true;
            }
        }
        if(d==Direction.LEFT){
            if(c.getC()==0){
                return false;
            }
            var postarget=cells[c.getC()-1][c.getR()];
            if(postarget instanceof Wall) {
                return false;
            }
            if(((Tile) postarget).getOccupant().isPresent()){
                return false;
            }else{
                ((Tile) postarget).setOccupant(c);
                ((Tile)cells[c.getC()][c.getR()]).removeOccupant();
                c.setPos(c.getR(),c.getC()-1);
                return true;
            }
        }
        if(d==Direction.RIGHT){
            if(c.getC()==cells.length){
                System.out.println("length");
                return false;
            }
            var postarget=cells[c.getC()+1][c.getR()];
            if(postarget instanceof Wall) {
                System.out.println("wall");
                return false;
            }
            if(((Tile) postarget).getOccupant().isPresent()){
                System.out.println("have stuff");
                return false;
            }else{
                System.out.println("move");
                ((Tile) postarget).setOccupant(c);
                ((Tile)cells[c.getC()][c.getR()]).removeOccupant();
                c.setPos(c.getR(),c.getC()+1);
                return true;
            }
        }
        return false; // You may also modify this line.
    }

    private boolean isValid(int r, int c) {
        return (r >= 0 && r < cells.length && c >= 0 && c < cells[0].length);
    }

    /**
     * @param r The row coordinate
     * @param c The column coordinate
     * @return Whether or not the specified location on the grid is a location which implements Occupiable,
     * yet does not currently have a crate in it. Will return false if out of bounds.
     */
    public boolean isOccupiableAndNotOccupiedWithCrate(int r, int c) {
        //TODO
        return false; // You may also modify this line.
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}
