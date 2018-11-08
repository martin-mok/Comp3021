package lab8;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URISyntaxException;

public class Main extends Application {
    public static final int CELL_SIZE = 32;
    private static Image tile = null;
    private static Image crate = null;

    /**
     * TODO: load the images, use static{}
     */
    static{
        tile= new Image("file:src/assets/images/tile.png");
        crate= new Image("file:src/assets/images/crate.png");
    }


    public static void main(String[] args) {
        launch(args);
    }

    /**
     * TODO: set the title to "Lab 8", set the scene, and show the stage
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        int rows = 8;
        int cols = 8;
        primaryStage.setTitle("Lab 8");
        primaryStage.setScene(checkerboardScene(rows,cols));
        primaryStage.show();
    }

    /**
     * TODO:
     * Generate the canvas with the alternating checkerboard pattern of tiles and crates.
     * Place the canvas inside a VBox before returning it in a scene
     *
     * @param rows Number of rows
     * @param cols Number of cols
     * @return The canvas with the images drawn onto it. The top left should always be a crate.
     */
    public Scene checkerboardScene(int rows, int cols) {
        double width = tile.getWidth()*cols;
        double height = tile.getHeight()*rows;
        Canvas canvas=new Canvas(width,height);
        GraphicsContext gc=canvas.getGraphicsContext2D();
        int cell=1;
        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++,cell++) {
                if(i%2==0){
                    if(cell%2==0){
                        gc.drawImage(tile, j * tile.getWidth(), i * tile.getHeight());
                    }else{
                        gc.drawImage(crate, j * tile.getWidth(), i * tile.getHeight());
                    }
                }else{
                    if(cell%2==1){
                        gc.drawImage(tile, j * tile.getWidth(), i * tile.getHeight());
                    }else{
                        gc.drawImage(crate, j * tile.getWidth(), i * tile.getHeight());
                    }
                }

            }
        }
        return new Scene(new Group(canvas));
    }
}
