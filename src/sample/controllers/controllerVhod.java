package sample.controllers;

import java.io.IOException;
import java.net.URL;
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
import sample.dataBase.dataBase;
import sample.oop_plus_gamelojik.*;

import static sample.Main.tearn;


public class controllerVhod {
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
    dataBase dataBase = new dataBase();

    @FXML
    void initialize() {
        buttomVhod.setOnAction(
                event -> {
                    text1.setText(" ");
                    String login = loginField.getText().trim();
                    String pass = passwordField.getText().trim();
                    game.player[tearn] = null;
                    game.player[tearn] = dataBase.getUser(login, pass);
                    System.out.println(game.player[tearn]);
                 //   dataBase.upDate(game.player[tearn]);
                    if (game.player[tearn] != null) {
                        System.out.println("acces");
                        buttomVhod.getScene().getWindow().hide();
                        openNew("/sample/Sampless/sampleUpdate.fxml");
                    } else {
                        text1.setText("Неправильный логин или пароль");
                    }
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

