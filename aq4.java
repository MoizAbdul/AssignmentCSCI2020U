import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.FileReader;
import java.io.BufferedReader;
import javafx.geometry.Pos;


public class aq4 extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {


        Label textLabel = new Label("Filename");
        TextField _text1 = new TextField();
        Button _btn1;
        _btn1 = new Button("View");
        // Set pressing "enter" to submit
        _btn1.setDefaultButton(true);



        BorderPane bp = new BorderPane();
        bp.setLeft(textLabel);
        bp.setCenter(_text1);
        bp.setRight(_btn1);
        bp.setAlignment(textLabel,Pos.BOTTOM_LEFT);
        bp.setAlignment(_text1,Pos.BOTTOM_CENTER);
        bp.setAlignment(_btn1,Pos.BOTTOM_RIGHT);



        _btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                char letters[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
                int occurence[] = new int[26];
                for (int i = 0; i < letters.length; i++) {
                    try (BufferedReader br = new BufferedReader(new FileReader(_text1.getText()))) {
                        int ch;
                        char charToSearch = letters[i];
                        int counter = 0;
                        while ((ch = br.read()) != -1) {
                            if (charToSearch == Character.toUpperCase((char) ch)) {
                                counter++;
                            }
                        }
                        occurence[i] = counter;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                stage.setTitle("Aq4");
                final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                final BarChart bc = new BarChart<>(xAxis, yAxis);
                bc.setTitle("Letter Occurence");
                bc.setLegendVisible(false);
                bc.setCategoryGap(0.5);
                bc.setVerticalGridLinesVisible(false);
                bc.setHorizontalGridLinesVisible(false);

                XYChart.Series series1 = new XYChart.Series();

                for(int i = 0; i < letters.length;i++){
                    series1.getData().add(new XYChart.Data(Character.toString(letters[i]), occurence[i]));
                }

                bc.getData().add(series1);
                bp.setTop(bc);
                bp.setAlignment(bc,Pos.TOP_CENTER);

            }
        });

        Scene scene = new Scene(bp,200, 200);
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(800);
        stage.show();
    }
}