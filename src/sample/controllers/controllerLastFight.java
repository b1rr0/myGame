package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.dataBase.dataBase;
import sample.oop_plus_gamelojik.game;

import static sample.Main.tearn;

public class controllerLastFight {

    @FXML
    private AnchorPane mainField;

    @FXML
    private ImageView Pl2NikLvl;

    @FXML
    private Button nextRound;

    @FXML
    private Label text;

    @FXML
    private ImageView Pl1pict;

    @FXML
    private Label Pl2nikc;

    @FXML
    private ImageView Pl2pic;

    @FXML
    private Label Pl2nikc1;

    @FXML
    private Label ViviodHp2;

    @FXML
    private Label VivodHp1;

    @FXML
    private Label Dmg2;

    @FXML
    private Label Dmg1;

    @FXML
    private Label round;
    @FXML
    private Label round1;

    @FXML
    private Button Finish;

    @FXML
    private Label Pl2nikc11;

    @FXML
    private ImageView pickSword0;

    @FXML
    private ImageView pickSword1;

    static int count = 1;
    dataBase dataBase = new dataBase();

    @FXML
    void initialize() {


        Image imgValk = new Image(getClass().getResourceAsStream("../img/valkiriya.png"));
        Image imgTampl = new Image(getClass().getResourceAsStream("../img/tamplier.png"));
        Image imgSam = new Image(getClass().getResourceAsStream("../img/samurai.png"));
        Image imgBers = new Image(getClass().getResourceAsStream("../img/bers.png"));
        Image imgValkZer = new Image(getClass().getResourceAsStream("../img/ValkiriyaZerkalo.png"));
        Image imgTamplZer = new Image(getClass().getResourceAsStream("../img/TamplierZerkalo.png"));
        Image imgSamZer = new Image(getClass().getResourceAsStream("../img/SamuraiZerkalo.png"));
        Image imgBerszer = new Image(getClass().getResourceAsStream("../img/BersZerkalo.png"));
        Image imgSword = new Image(getClass().getResourceAsStream("../img/anotherSword.png"));
        Image imgShield = new Image(getClass().getResourceAsStream("../img/anotherShield.png"));


        if (game.player[1].getName().equals("Bers"))
            Pl1pict.setImage(imgBers);
        if (game.player[1].getName().equals("Tamplier"))
            Pl1pict.setImage(imgTampl);
        if (game.player[1].getName().equals("Samurai"))
            Pl1pict.setImage(imgSam);
        if (game.player[1].getName().equals("Valkiriya"))
            Pl1pict.setImage(imgValk);

        if (game.player[0].getName().equals("Bers"))
            Pl2pic.setImage(imgBerszer);
        if (game.player[0].getName().equals("Tamplier"))
            Pl2pic.setImage(imgTamplZer);
        if (game.player[0].getName().equals("Samurai"))
            Pl2pic.setImage(imgSamZer);
        if (game.player[0].getName().equals("Valkiriya"))
            Pl2pic.setImage(imgValkZer);
        // ViviodHp2.setText(ControllerVhod.player[1].getHp() + "");
        // VivodHp1.setText(ControllerVhod.player[0].getHp() + "");

        Pl2nikc.setText(game.player[1].getNikName());
        Pl2nikc1.setText(game.player[0].getNikName());
        VivodHp1.setText(game.player[0].getHp() + "");
        ViviodHp2.setText(game.player[1].getHp() + "");


        Finish.setOnAction(event -> {
            if (game.player[0].getHp() == 0 || game.player[1].getHp() == 0) {
                dataBase.upDate(game.player[0]);
                dataBase.upDate(game.player[1]);
                Finish.getScene().getWindow().hide();

            } else {
                Pl2nikc.setText("Игра еще не окончена");
            }
        });


        nextRound.setOnAction(
                event -> {
                    if (game.player[0].getHp() > 0 && game.player[1].getHp() > 0) {
                        round.setText("Раунд " + count++);
                        round1.setText("Сейчас бьет  " + (tearn == 1 ? game.player[1].getNikName() : game.player[0].getNikName()));

                        if (tearn == 1) {
                            pickSword0.setImage(imgShield);
                            pickSword1.setImage(imgSword);
                            int k = game.player[1].getHp();
                            System.out.println(game.player[1].getHp() + " hp 2go");
                            Dmg2.setText(game.Round(game.player[0], game.player[1]));
                            System.out.println(game.player[1].getHp() + " hp 2go");
                            if (k < game.player[1].getHp()) {
                                ViviodHp2.setText(k + " + " + (game.player[1].getHp() - k));
                            }
                            VivodHp1.setText(game.player[0].getHp() + "");
                            System.out.println("bers" + game.player[1].hit());
                            System.out.println(game.player[0].def(game.player[1].hit()));
                        } else {
                            pickSword0.setImage(imgSword);
                            pickSword1.setImage(imgShield);
                            System.out.println(game.player[0].getHp() + " hp 1go");
                            int k = game.player[0].getHp();
                            Dmg1.setText(game.Round(game.player[0], game.player[1]));
                            System.out.println(game.player[0].getHp() + " hp 1go");
                            if (k < game.player[0].getHp()) {
                                VivodHp1.setText(k + " + " + (game.player[0].getHp() - k));
                            }
                            ViviodHp2.setText(game.player[1].getHp() + "");
                            System.out.println("sam" + game.player[0].hit());
                            System.out.println(game.player[1].def(game.player[0].hit()));
                        }
                        System.out.println("W");
                    } else {
                        ViviodHp2.setText("");
                        VivodHp1.setText("");
                        Dmg1.setText("");
                        Dmg2.setText("");
                        String rez = "Конец";
                        rez += game.player[1].getHp() == 0 ? game.player[0].getNikName() :
                                game.player[1].getNikName();
                        round.setText(rez + " Победил");
                        if (count != 0) {

                            if (game.player[1].getHp() == 0) {
                                game.player[1].setMoney(game.player[1].getMoney()+3 + game.player[0].getLevel() / 2);
                                game.player[1].setLevel(game.player[1].getLevel()+ 2 + game.player[1].getLevel() / 6);

                            } else {
                                game.player[1].setMoney(game.player[1].getMoney()+5 + game.player[0].getLevel());
                                game.player[1].setLevel(game.player[1].getLevel()+3 + game.player[1].getLevel() / 3);
                            }
                            if (game.player[0].getHp() == 0) {
                                game.player[0].setMoney(game.player[0].getMoney()+3 + game.player[1].getLevel() / 2);
                                game.player[0].setLevel(game.player[0].getLevel()+ 2 + game.player[1].getLevel() / 6);

                            } else {
                                game.player[0].setMoney(game.player[0].getLevel()+5 + game.player[1].getLevel());
                                game.player[0].setLevel(game.player[0].getLevel()+3 + game.player[1].getLevel() / 3);
                            }
                            count = 0;

                        }
                    }
                });
    }
}
