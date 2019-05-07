package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerRegistr2 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainField;

    @FXML
    private Button buttonRegistrNewAcc;

    @FXML
    private PasswordField newPass;

    @FXML
    private TextField newLogin;

    @FXML
    private PasswordField newPass1;

    static String newpas;
    static String newlog;

    @FXML
    void initialize() {
        buttonRegistrNewAcc.setOnAction(
                event ->
                {
                    if ((newPass.getText().equals(newPass1.getText())) && (newPass.getText().length() > 5) && (newLogin.getText().length() > 4)) {
                        newpas = newPass.getText();
                        newlog = newLogin.getText();
                        buttonRegistrNewAcc.getScene().getWindow().hide();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/sample/Sampless/sampleChooseHero.fxml"));
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
