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
import sample.dataBase.dataBase;
import sample.oop_plus_gamelojik.game;

import static sample.Main.tearn;


public class controllerUpdate {

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
    dataBase dataBase = new dataBase();

    @FXML
    void initialize() {
        Image imgValk = new Image(getClass().getResourceAsStream("../img/valkiriya.png"));
        Image imgTampl = new Image(getClass().getResourceAsStream("../img/tamplier.png"));
        Image imgSam = new Image(getClass().getResourceAsStream("../img/samurai.png"));
        Image imgBers = new Image(getClass().getResourceAsStream("../img/bers.png"));
        ///////
        goldBreacer.setText(game.cost(game.player[tearn].getBreacer()) > 65 ? "макс " :
                game.cost(game.player[tearn].getBreacer()) + " ");
        goldBronya.setText(game.cost(game.player[tearn].getArmor()) > 65 ? "макс " :
                game.cost(game.player[tearn].getArmor()) + " ");
        goldOrujie.setText(game.cost(game.player[tearn].getSword()) > 65 ? "макс " :
                game.cost(game.player[tearn].getSword()) + " ");
        goldNogi.setText(game.cost(game.player[tearn].getLeggins()) > 65 ? "макс " :
                +game.cost(game.player[tearn].getLeggins()) + " ");
        goldShelm.setText(game.cost(game.player[tearn].getHelmet()) > 65 ? "макс " :
                game.cost(game.player[tearn].getHelmet()) + " ");
        ////////
        if (game.player[tearn].getName().equals("bers"))
            hepoImg.setImage(imgBers);
        if (game.player[tearn].getName().equals("tamplier"))
            hepoImg.setImage(imgTampl);
        if (game.player[tearn].getName().equals("samurai"))
            hepoImg.setImage(imgSam);
        if (game.player[tearn].getName().equals("valkiriya"))
            hepoImg.setImage(imgValk);


        //
        LabelMany.setText(game.player[tearn].getMoney() + " ");
        lvl.setText("lvl " + game.player[tearn].getLevel());
        ////
        breyserText.setText("Наручи " + game.player[tearn].getBreacer() + "/10");
        shlemText.setText("Шлем " + game.player[tearn].getHelmet() + "/10");
        bronyaText.setText("Броня " + game.player[tearn].getArmor() + "/10");
        bnaruchiText.setText("Тапки " + game.player[tearn].getLeggins() + "/10");
        orujieText.setText("Оружие " + game.player[tearn].getSword() + "/10");

        //////
        buttomUluchShlem.setOnAction(
                event -> {
                    System.out.println(game.player[tearn].getMoney());
                    if ((game.player[tearn].getMoney() >= game.cost(game.player[tearn].getHelmet()))
                            && (game.player[tearn]).getHelmet() < 10) {
                        game.player[tearn].buy(game.cost(game.player[tearn].getHelmet()));
                        game.player[tearn].upShlem();
                        System.out.println(game.player[0].getName());
                        System.out.println(game.player[0].getHelmet());
                        shlemText.setText("Шлем " + game.player[tearn].getHelmet() + "/10");
                        LabelMany.setText(game.player[tearn].getMoney() + " ");
                        goldShelm.setText(game.cost(game.player[tearn].getHelmet()) > 65 ? "макс " :
                                game.cost(game.player[tearn].getHelmet()) + " ");
                    }
                });
        //////
        buttomUluchBronya.setOnAction(
                event -> {
                    System.out.println(game.player[tearn].getMoney());
                    if ((game.player[tearn].getMoney() >= game.cost(game.player[tearn].getArmor()))
                            && (game.player[tearn]).getArmor() < 10) {
                        game.player[tearn].buy(game.cost(game.player[tearn].getArmor()));
                        game.player[tearn].upDospeh();
                        bronyaText.setText("Броня " + game.player[tearn].getArmor() + "/10");
                        LabelMany.setText(game.player[tearn].getMoney() + " ");
                        goldBronya.setText(game.cost(game.player[tearn].getArmor()) > 65 ? "макс " :
                                game.cost(game.player[tearn].getArmor()) + " ");
                    }
                });
        //////
        buttomUluchNogi.setOnAction(
                event -> {
                    if ((game.player[tearn].getMoney() >= game.cost(game.player[tearn].getLeggins()))
                            && (game.player[tearn]).getLeggins() < 10) {
                        game.player[tearn].buy(game.cost(game.player[tearn].getLeggins()));
                        game.player[tearn].upNogi();
                        bnaruchiText.setText("Тапки " + game.player[tearn].getLeggins() + "/10");
                        LabelMany.setText(game.player[tearn].getMoney() + " ");
                        goldNogi.setText(game.cost(game.player[tearn].getLeggins()) > 65 ? "макс " :
                                game.cost(game.player[tearn].getLeggins()) + " ");
                    }
                });
/////
        buttomUluchPonoji.setOnAction(
                event -> {
                    if ((game.player[tearn].getMoney() >= game.cost(game.player[tearn].getBreacer()))
                            && (game.player[tearn]).getBreacer() < 10) {
                        game.player[tearn].buy(game.cost(game.player[tearn].getBreacer()));
                        game.player[tearn].upBreacer();
                        breyserText.setText("Наручи " + game.player[tearn].getBreacer() + "/10");
                        LabelMany.setText(game.player[tearn].getMoney() + " ");
                        goldBreacer.setText(game.cost(game.player[tearn].getBreacer()) > 65 ? "макс " :
                                game.cost(game.player[tearn].getBreacer()) + " ");
                    }
                });
///
        buttomUluchOrijie.setOnAction(
                event -> {
                    if ((game.player[tearn].getMoney() >= game.cost(game.player[tearn].getSword()))
                            && (game.player[tearn]).getSword() < 10) {
                        game.player[tearn].buy(game.cost(game.player[tearn].getSword()));
                        game.player[tearn].upSword();
                        orujieText.setText("Оружие " + game.player[tearn].getSword() + "/10");
                        LabelMany.setText(game.player[tearn].getMoney() + " ");
                        goldOrujie.setText(game.cost(game.player[tearn].getSword()) > 65 ? "макс " :
                                game.cost(game.player[tearn].getSword()) + " ");
                    }
                });

        buttomVhod.setOnAction(
                event -> {
                    dataBase.upDate(game.player[tearn]);
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
