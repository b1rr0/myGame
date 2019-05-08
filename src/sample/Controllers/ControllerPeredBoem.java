package sample.Controllers;

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
import sample.oop_plus_gamelojik.Game;

import static sample.Main.tearn;

public class ControllerPeredBoem {


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

        VivodOrujie.setText("Lv." + Game.player[0].getOrujie() + "  =Оружие= Lv." + Game.player[1].getOrujie());
        VivodShlem.setText("Lv." + Game.player[0].getShlem() + "  =Шлем=   Lv." + Game.player[1].getShlem());
        VivodBronya.setText("Lv." + Game.player[0].getDospeh() + "  =Броня=  Lv." + Game.player[1].getDospeh());
        VivodBreicer.setText("Lv." + Game.player[0].getBreacer() + "  =Наручи= Lv." + Game.player[1].getBreacer());
        VivodNogi.setText("Lv." + Game.player[0].getNogi() + "  =Ноги=   Lv." + Game.player[1].getNogi());
        VivodLvl1.setText("Lv." + Game.player[0].getLevel());
        VivodLvl2.setText("Lv." + Game.player[1].getLevel());
        VivodNogi1.setText(Game.player[1].Osobennost());
        VivodNogi11.setText(Game.player[0].Osobennost());
        Image imgValk = new Image(getClass().getResourceAsStream("../img/valkiriya.png"));
        Image imgTampl = new Image(getClass().getResourceAsStream("../img/tamplier.png"));
        Image imgSam = new Image(getClass().getResourceAsStream("../img/samurai.png"));
        Image imgBers = new Image(getClass().getResourceAsStream("../img/bers.png"));
        Image imgValkZer = new Image(getClass().getResourceAsStream("../img/ValkiriyaZerkalo.png"));
        Image imgTamplZer = new Image(getClass().getResourceAsStream("../img/TamplierZerkalo.png"));
        Image imgSamZer = new Image(getClass().getResourceAsStream("../img/SamuraiZerkalo.png"));
        Image imgBerszer = new Image(getClass().getResourceAsStream("../img/BersZerkalo.png"));

        if (Game.player[1].getName().equals("Bers"))
            Pl2pic.setImage(imgBers);
        if (Game.player[1].getName().equals("Tamplier"))
            Pl2pic.setImage(imgTampl);
        if (Game.player[1].getName().equals("Samurai"))
            Pl2pic.setImage(imgSam);
        if (Game.player[1].getName().equals("Valkiriya"))
            Pl2pic.setImage(imgValk);

        if (Game.player[0].getName().equals("Bers"))
            Pl1pic.setImage(imgBerszer);
        if (Game.player[0].getName().equals("Tamplier"))
            Pl1pic.setImage(imgTamplZer);
        if (Game.player[0].getName().equals("Samurai"))
            Pl1pic.setImage(imgSamZer);
        if (Game.player[0].getName().equals("Valkiriya"))
            Pl1pic.setImage(imgValkZer);

        Pl2nikc.setText(Game.player[1].getNikName());
        Pl2nikc1.setText(Game.player[0].getNikName());
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
