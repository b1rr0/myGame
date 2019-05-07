package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.DataBase.Db;
import sample.oop_plus_gamelojik.Bers;
import sample.oop_plus_gamelojik.Samurai;
import sample.oop_plus_gamelojik.Tamplier;
import sample.oop_plus_gamelojik.Valkiriya;

import static sample.Main.tearn;

public class ControllerChouseHero {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainField;

    @FXML
    private Button buttomVhod;

    @FXML
    private Label text;

    @FXML
    private ImageView puttPichHere;

    @FXML
    private RadioButton but1 = new RadioButton("Samuira");

    @FXML
    private RadioButton but2 = new RadioButton("Valkiriya");

    @FXML
    private RadioButton but3 = new RadioButton("Tamplier");

    @FXML
    private RadioButton but4 = new RadioButton("Bers");


    @FXML
    void initialize() {
        Db db = new Db();


        ToggleGroup group = new ToggleGroup();
        but1.setToggleGroup(group);
        but2.setToggleGroup(group);
        but3.setToggleGroup(group);
        but4.setToggleGroup(group);

        but1.setUserData("../img/samurai.png");
        but2.setUserData("../img/valkiriya.png");
        but3.setUserData("../img/tamplier.png");
        but4.setUserData("../img/bers.png");

        group.selectedToggleProperty().addListener(event -> {
            Image img = new Image(getClass().getResourceAsStream(group.getSelectedToggle().getUserData() + ""));
            puttPichHere.setImage(img);
        });


        buttomVhod.setOnAction(
                event -> {
                    if (but1.isSelected())
                        ControllerVhod.player[tearn] = new Samurai(1, 1, 1, 1, 1, 15, 1,
                                ControllerRegistr2.newlog);
                    if (but2.isSelected())
                        ControllerVhod.player[tearn] = new Valkiriya(1, 1, 1, 1, 1, 15, 1,
                                ControllerRegistr2.newlog);
                    if (but3.isSelected())
                        ControllerVhod.player[tearn] = new Tamplier(1, 1, 1, 1, 1, 15, 1,
                                ControllerRegistr2.newlog);
                    if (but4.isSelected())
                        ControllerVhod.player[tearn] = new Bers(1, 1, 1, 1, 1, 15, 1,
                                ControllerRegistr2.newlog);

                    db.signUpUser(1, 1, 1, 1, 1, 15, 1, ControllerRegistr2.newlog,
                            (int) ControllerRegistr2.newpas.hashCode(), ControllerVhod.player[tearn].getName());

                    System.out.println("acces");
                    buttomVhod.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/Sampless/sampleUpdate.fxml"));
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


    }
}
