package sample.controllers;

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
import sample.dataBase.dataBase;
import sample.oop_plus_gamelojik.*;

import static sample.Main.tearn;

public class controllerChouseHero {

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
    private RadioButton but2 = new RadioButton("valkiriya");

    @FXML
    private RadioButton but3 = new RadioButton("tamplier");

    @FXML
    private RadioButton but4 = new RadioButton("bers");


    @FXML
    void initialize() {
        dataBase dataBase = new dataBase();


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
                        game.player[tearn] = new samurai(1, 1, 1, 1, 1, 15, 1,
                                controllerRegistr2.newlog);
                    if (but2.isSelected())
                        game.player[tearn] = new valkiriya(1, 1, 1, 1, 1, 15, 1,
                                controllerRegistr2.newlog);
                    if (but3.isSelected())
                        game.player[tearn] = new tamplier(1, 1, 1, 1, 1, 15, 1,
                                controllerRegistr2.newlog);
                    if (but4.isSelected())
                        game.player[tearn] = new bers(1, 1, 1, 1, 1, 15, 1,
                                controllerRegistr2.newlog);

                    dataBase.signUpUser(1, 1, 1, 1, 1, 15, 1, controllerRegistr2.newlog,
                            (int) controllerRegistr2.newpas.hashCode(), game.player[tearn].getName());

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
