
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.util.*;


public class q1 extends Application {
    @Override
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);

        Random ran = new Random();
        int num = ran.nextInt(53) + 1;
        int num2 = ran.nextInt(53) + 1;
        int num3 = ran.nextInt(53) + 1;

        String i1 =  Integer.toString(num);
        i1 = ("Cards/" + i1 +".png");
        String i2 =  Integer.toString(num2);
        i2 = ("Cards/" + i2 +".png");
        String i3 =  Integer.toString(num3);
        i3 = ("Cards/" + i3 +".png");

        ImageView imageView1 = new ImageView(i1);
        ImageView imageView2 = new ImageView(i2);
        ImageView imageView3 = new ImageView(i3);


        pane.add(imageView1, 1, 0);
        pane.add(imageView2, 2, 0);
        pane.add(imageView3, 3, 0);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("AQ1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
