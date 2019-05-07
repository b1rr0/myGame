package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.DataBase.Db;
import sample.oop_plus_gamelojik.*;

import static sample.Main.tearn;


public class ControllerVhod {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainField;

    @FXML
    private Button buttomVhod;

    @FXML
    private Button buttonRegistr;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField loginField;
    @FXML
    private Label text1;

   public  static Human player[] = new Human[2];

    Db db = new Db();

    @FXML
    void initialize() {


        buttomVhod.setOnAction(
                event -> { text1.setText( " ");
                    String login = loginField.getText().trim();
                    String pass = passwordField.getText().trim();
                    player[tearn] = null;
                    player[tearn] = db.getUser(login, pass);

                    db.upDate(player[tearn]);
                    if (player[tearn] != null) {
                        System.out.println("acces");
                        buttomVhod.getScene().getWindow().hide();
                        openNew("/sample/Sampless/sampleUpdate.fxml");
                    }else   {text1.setText( "Неправильный логин или пароль");}
                }
        );
        buttonRegistr.setOnAction(
                event ->
                {
                    System.out.println("asdasd");
                    buttomVhod.getScene().getWindow().hide();
                    openNew("/sample/Sampless/sampleRegistr.fxml");
                }
        );
    }

    public void openNew(String a) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(a));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}

