import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class aq2 extends Application {
    // Variables that we need to use
    private TextField _text1;
    private TextField _text2;
    private TextField _text3;
    private TextField _text4;
    private Button _btn1;

    // Fake Console

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("AQ2");

        // Grid Pane
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(10,10,10,10));

        // Set our variables
        Label textLabel = new Label("Investment Amount ");
        _text1 = new TextField();
        gp.add(textLabel, 0,0);
        gp.add(_text1, 1, 0);

        Label textLabel2 = new Label("Years ");
        _text2 = new TextField();
        gp.add(textLabel2, 0,3);
        gp.add(_text2, 1, 3);

        Label textLabel3 = new Label("Annual Interest Rate");
        _text3 = new TextField();
        gp.add(textLabel3, 0,4);
        gp.add(_text3, 1, 4);

        Label textLabel4 = new Label("Future Value");
        _text4 = new TextField();
        gp.add(textLabel4, 0,5);
        gp.add(_text4, 1, 5);

        Label btnLabel = new Label(null);
        _btn1 = new Button("Calculate");

        // Set pressing "enter" to submit
        _btn1.setDefaultButton(true);

        gp.add(btnLabel, 0, 6);
        gp.add(_btn1, 1, 6);

        // Button handler
        _btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double t1 =  Double.parseDouble(_text1.getText());
                double t2 =  Double.parseDouble(_text2.getText());
                double t3 =  Double.parseDouble(_text3.getText())/12/100;
                double future = t1*Math.pow((1 + t3),(12.0*t2));
                future = Math.round(future * 100.0) / 100.0;
                _text4.setText(Double.toString(future));
            }
        });
        Scene scene = new Scene(gp, 325, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

