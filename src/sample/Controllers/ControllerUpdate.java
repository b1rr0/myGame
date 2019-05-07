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
import sample.DataBase.Db;
import sample.oop_plus_gamelojik.Bers;
import sample.oop_plus_gamelojik.Game;

import static sample.Main.tearn;


public class ControllerUpdate {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainField;

    @FXML
    private Label text;

    @FXML
    private Button buttomVhod;

    @FXML
    private ImageView hepoImg;

    @FXML
    private Label bronyaText;

    @FXML
    private Label bronyaText1;

    @FXML
    private Label breyserText;

    @FXML
    private Label bnaruchiText;

    @FXML
    private Label orujieText;

    @FXML
    private Label shlemText;

    @FXML
    private Label bronyaText11;

    @FXML
    private Label bronyaText12;

    @FXML
    private Label bronyaText121;

    @FXML
    private Label bronyaText1211;

    @FXML
    private Button buttomUluchShlem;

    @FXML
    private Button buttomUluchBronya;

    @FXML
    private Button buttomUluchPonoji;

    @FXML
    private Button buttomUluchNogi;

    @FXML
    private Button buttomUluchOrijie;

    @FXML
    private Label LabelMany;

    @FXML
    private Label goldShelm;

    @FXML
    private Label goldBronya;

    @FXML
    private Label goldBreacer;

    @FXML
    private Label goldNogi;

    @FXML
    private Label lvl;

    @FXML
    private Label goldOrujie;
    Db db = new Db();

    @FXML
    void initialize() {
        Image imgValk = new Image(getClass().getResourceAsStream("../img/valkiriya.png"));
        Image imgTampl = new Image(getClass().getResourceAsStream("../img/tamplier.png"));
        Image imgSam = new Image(getClass().getResourceAsStream("../img/samurai.png"));
        Image imgBers = new Image(getClass().getResourceAsStream("../img/bers.png"));
        ///////
        goldBreacer.setText(Game.cost(ControllerVhod.player[tearn].getBreacer()) > 65 ? "макс " :
                Game.cost(ControllerVhod.player[tearn].getBreacer()) + " ");
        goldBronya.setText(Game.cost(ControllerVhod.player[tearn].getDospeh()) > 65 ? "макс " :
                Game.cost(ControllerVhod.player[tearn].getDospeh()) + " ");
        goldOrujie.setText(Game.cost(ControllerVhod.player[tearn].getOrujie()) > 65 ? "макс " :
                Game.cost(ControllerVhod.player[tearn].getOrujie()) + " ");
        goldNogi.setText(Game.cost(ControllerVhod.player[tearn].getNogi()) > 65 ? "макс " :
                +Game.cost(ControllerVhod.player[tearn].getNogi()) + " ");
        goldShelm.setText(Game.cost(ControllerVhod.player[tearn].getShlem()) > 65 ? "макс " :
                Game.cost(ControllerVhod.player[tearn].getShlem()) + " ");
        ////////
        if (ControllerVhod.player[tearn].getName().equals("Bers"))
            hepoImg.setImage(imgBers);
        if (ControllerVhod.player[tearn].getName().equals("Tamplier"))
            hepoImg.setImage(imgTampl);
        if (ControllerVhod.player[tearn].getName().equals("Samurai"))
            hepoImg.setImage(imgSam);
        if (ControllerVhod.player[tearn].getName().equals("Valkiriya"))
            hepoImg.setImage(imgValk);


        //
        LabelMany.setText(ControllerVhod.player[tearn].getDengi() + " ");
        lvl.setText("lvl " + ControllerVhod.player[tearn].getLevel());
        ////
        breyserText.setText("Наручи " + ControllerVhod.player[tearn].getBreacer() + "/10");
        shlemText.setText("Шлем " + ControllerVhod.player[tearn].getShlem() + "/10");
        bronyaText.setText("Броня " + ControllerVhod.player[tearn].getDospeh() + "/10");
        bnaruchiText.setText("Тапки " + ControllerVhod.player[tearn].getNogi() + "/10");
        orujieText.setText("Оружие " + ControllerVhod.player[tearn].getOrujie() + "/10");

        //////
        buttomUluchShlem.setOnAction(
                event -> {
                    System.out.println(ControllerVhod.player[tearn].getDengi());
                    if ((ControllerVhod.player[tearn].getDengi() >= Game.cost(ControllerVhod.player[tearn].getShlem()))
                            && (ControllerVhod.player[tearn]).getShlem() < 10) {
                        ControllerVhod.player[tearn].buy(Game.cost(ControllerVhod.player[tearn].getShlem()));
                        ControllerVhod.player[tearn].upShlem();
                        System.out.println(ControllerVhod.player[0].getName());
                        System.out.println(ControllerVhod.player[0].getShlem());
                        shlemText.setText("Шлем " + ControllerVhod.player[tearn].getShlem() + "/10");
                        LabelMany.setText(ControllerVhod.player[tearn].getDengi() + " ");
                        goldShelm.setText(Game.cost(ControllerVhod.player[tearn].getShlem()) > 65 ? "макс " :
                                Game.cost(ControllerVhod.player[tearn].getShlem()) + " ");
                    }
                });
        //////
        buttomUluchBronya.setOnAction(
                event -> {
                    System.out.println(ControllerVhod.player[tearn].getDengi());
                    if ((ControllerVhod.player[tearn].getDengi() >= Game.cost(ControllerVhod.player[tearn].getDospeh()))
                            && (ControllerVhod.player[tearn]).getDospeh() < 10) {
                        ControllerVhod.player[tearn].buy(Game.cost(ControllerVhod.player[tearn].getDospeh()));
                        ControllerVhod.player[tearn].upDospeh();
                        bronyaText.setText("Броня " + ControllerVhod.player[tearn].getDospeh() + "/10");
                        LabelMany.setText(ControllerVhod.player[tearn].getDengi() + " ");
                        goldBronya.setText(Game.cost(ControllerVhod.player[tearn].getDospeh()) > 65 ? "макс " :
                                Game.cost(ControllerVhod.player[tearn].getDospeh()) + " ");
                    }
                });
        //////
        buttomUluchNogi.setOnAction(
                event -> {
                    if ((ControllerVhod.player[tearn].getDengi() >= Game.cost(ControllerVhod.player[tearn].getNogi()))
                            && (ControllerVhod.player[tearn]).getNogi() < 10) {
                        ControllerVhod.player[tearn].buy(Game.cost(ControllerVhod.player[tearn].getNogi()));
                        ControllerVhod.player[tearn].upNogi();
                        bnaruchiText.setText("Тапки " + ControllerVhod.player[tearn].getNogi() + "/10");
                        LabelMany.setText(ControllerVhod.player[tearn].getDengi() + " ");
                        goldNogi.setText(Game.cost(ControllerVhod.player[tearn].getNogi()) > 65 ? "макс " :
                                Game.cost(ControllerVhod.player[tearn].getNogi()) + " ");
                    }
                });
/////
        buttomUluchPonoji.setOnAction(
                event -> {
                    if ((ControllerVhod.player[tearn].getDengi() >= Game.cost(ControllerVhod.player[tearn].getBreacer()))
                            && (ControllerVhod.player[tearn]).getBreacer() < 10) {
                        ControllerVhod.player[tearn].buy(Game.cost(ControllerVhod.player[tearn].getBreacer()));
                        ControllerVhod.player[tearn].upBreacer();
                        breyserText.setText("Наручи " + ControllerVhod.player[tearn].getBreacer() + "/10");
                        LabelMany.setText(ControllerVhod.player[tearn].getDengi() + " ");
                        goldBreacer.setText(Game.cost(ControllerVhod.player[tearn].getBreacer()) > 65 ? "макс " :
                                Game.cost(ControllerVhod.player[tearn].getBreacer()) + " ");
                    }
                });
///
        buttomUluchOrijie.setOnAction(
                event -> {
                    if ((ControllerVhod.player[tearn].getDengi() >= Game.cost(ControllerVhod.player[tearn].getOrujie()))
                            && (ControllerVhod.player[tearn]).getOrujie() < 10) {
                        ControllerVhod.player[tearn].buy(Game.cost(ControllerVhod.player[tearn].getOrujie()));
                        ControllerVhod.player[tearn].upOrujie();
                        orujieText.setText("Оружие " + ControllerVhod.player[tearn].getOrujie() + "/10");
                        LabelMany.setText(ControllerVhod.player[tearn].getDengi() + " ");
                        goldOrujie.setText(Game.cost(ControllerVhod.player[tearn].getOrujie()) > 65 ? "макс " :
                                Game.cost(ControllerVhod.player[tearn].getOrujie()) + " ");
                    }
                });

        buttomVhod.setOnAction(
                event -> {
                    db.upDate(ControllerVhod.player[tearn]);
                    if (tearn == 0) {
                        buttomVhod.getScene().getWindow().hide();
                        openNEw("/sample/Sampless/sample.fxml");
                        tearn++;
                    } else {
                        buttomVhod.getScene().getWindow().hide();
                        openNEw("/sample/Sampless/samplePeredBoem.fxml");
                    }
                });
    }

    public void openNEw(String s) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(s));
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
