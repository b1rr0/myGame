package sample.Controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.SendMessageMail;

public class ControllerRegistr {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainField;

    @FXML
    private Button buttonRegistr;


    @FXML
    private TextField loginField;

    @FXML
    private PasswordField loginField1Key;

    @FXML
    private Button buttonRegistr1Checjk;

    @FXML
    private Button buttonBack;


    @FXML
    void initialize() {
        int g = SendMessageMail.generCode();


        buttonRegistr.setOnAction(
                event -> {
                    String s = loginField.getText();
                    if (Pattern.matches("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$", s)) {
                        SendMessageMail.mailRegis(s, g);
                    } else loginField.clear();
                });

        buttonBack.setOnAction(
                event -> {
                     buttonRegistr1Checjk.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/Sampless/sample.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                }
        );

        buttonRegistr1Checjk.setOnAction(
                event -> {
                    String s = loginField1Key.getText();
                    if (s.equals(String.valueOf(g)))
                    {
                        System.out.println("acces");
                        buttonRegistr1Checjk.getScene().getWindow().hide();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/sample/Sampless/sampleRegistr2.fxml"));
                        try {
                            loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                    }
                }
        );

    }
}
