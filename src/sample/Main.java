package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
    public static int tearn = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Sampless/sample.fxml"));
        primaryStage.setTitle("SwordDuel");
        primaryStage.setScene(new Scene(root, 1440, 900));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();

    }
}
