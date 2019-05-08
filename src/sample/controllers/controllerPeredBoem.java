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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.oop_plus_gamelojik.game;

public class controllerPeredBoem {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainField;

    @FXML
    private ImageView Pl2NikLvl;

    @FXML
    private Button buttomVhod;

    @FXML
    private Label text;

    @FXML
    private ImageView Pl2pic;

    @FXML
    private Label Pl2nikc;

    @FXML
    private ImageView Pl1pic;

    @FXML
    private Label Pl2nikc1;

    @FXML
    private Label VivodShlem;

    @FXML
    private Label VivodOrujie;

    @FXML
    private Label VivodBronya;

    @FXML
    private Label VivodBreicer;

    @FXML
    private Label VivodNogi;

    @FXML
    private Label VivodLvl2;

    @FXML
    private Label VivodLvl1;

    @FXML
    private Label VivodNogi1;

    @FXML
    private Label VivodNogi11;


    @FXML
    void initialize() {

        VivodOrujie.setText("Lv." + game.player[0].getSword() + "  =Оружие= Lv." + game.player[1].getSword());
        VivodShlem.setText("Lv." + game.player[0].getHelmet() + "  =Шлем=   Lv." + game.player[1].getHelmet());
        VivodBronya.setText("Lv." + game.player[0].getHelmet() + "  =Броня=  Lv." + game.player[1].getHelmet());
        VivodBreicer.setText("Lv." + game.player[0].getBreacer() + "  =Наручи= Lv." + game.player[1].getBreacer());
        VivodNogi.setText("Lv." + game.player[0].getLeggins() + "  =Ноги=   Lv." + game.player[1].getLeggins());
        VivodLvl1.setText("Lv." + game.player[0].getLevel());
        VivodLvl2.setText("Lv." + game.player[1].getLevel());
        VivodNogi1.setText(game.player[1].properties());
        VivodNogi11.setText(game.player[0].properties());
        Image imgValk = new Image(getClass().getResourceAsStream("../img/valkiriya.png"));
        Image imgTampl = new Image(getClass().getResourceAsStream("../img/tamplier.png"));
        Image imgSam = new Image(getClass().getResourceAsStream("../img/samurai.png"));
        Image imgBers = new Image(getClass().getResourceAsStream("../img/bers.png"));
        Image imgValkZer = new Image(getClass().getResourceAsStream("../img/ValkiriyaZerkalo.png"));
        Image imgTamplZer = new Image(getClass().getResourceAsStream("../img/TamplierZerkalo.png"));
        Image imgSamZer = new Image(getClass().getResourceAsStream("../img/SamuraiZerkalo.png"));
        Image imgBerszer = new Image(getClass().getResourceAsStream("../img/BersZerkalo.png"));

        if (game.player[1].getName().equals("Bers"))
            Pl2pic.setImage(imgBers);
        if (game.player[1].getName().equals("Tamplier"))
            Pl2pic.setImage(imgTampl);
        if (game.player[1].getName().equals("Samurai"))
            Pl2pic.setImage(imgSam);
        if (game.player[1].getName().equals("Valkiriya"))
            Pl2pic.setImage(imgValk);

        if (game.player[0].getName().equals("Bers"))
            Pl1pic.setImage(imgBerszer);
        if (game.player[0].getName().equals("Tamplier"))
            Pl1pic.setImage(imgTamplZer);
        if (game.player[0].getName().equals("Samurai"))
            Pl1pic.setImage(imgSamZer);
        if (game.player[0].getName().equals("Valkiriya"))
            Pl1pic.setImage(imgValkZer);

        Pl2nikc.setText(game.player[1].getNikName());
        Pl2nikc1.setText(game.player[0].getNikName());
        buttomVhod.setOnAction(
                event -> {

                    buttomVhod.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/Sampless/sampleListFight.fxml"));
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
        );

    }
}
