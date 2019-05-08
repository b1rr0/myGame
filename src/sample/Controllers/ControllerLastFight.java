package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.DataBase.Db;
import sample.oop_plus_gamelojik.Game;

import static sample.Main.tearn;

public class ControllerLastFight {

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

    static int count = 1;
    Db db = new Db();

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

        if (Game.player[1].getName().equals("Bers"))
            Pl1pict.setImage(imgBers);
        if (Game.player[1].getName().equals("Tamplier"))
            Pl1pict.setImage(imgTampl);
        if (Game.player[1].getName().equals("Samurai"))
            Pl1pict.setImage(imgSam);
        if (Game.player[1].getName().equals("Valkiriya"))
            Pl1pict.setImage(imgValk);

        if (Game.player[0].getName().equals("Bers"))
            Pl2pic.setImage(imgBerszer);
        if (Game.player[0].getName().equals("Tamplier"))
            Pl2pic.setImage(imgTamplZer);
        if (Game.player[0].getName().equals("Samurai"))
            Pl2pic.setImage(imgSamZer);
        if (Game.player[0].getName().equals("Valkiriya"))
            Pl2pic.setImage(imgValkZer);
        // ViviodHp2.setText(ControllerVhod.player[1].getHp() + "");
        // VivodHp1.setText(ControllerVhod.player[0].getHp() + "");

        Pl2nikc.setText(Game.player[1].getNikName());
        Pl2nikc1.setText(Game.player[0].getNikName());
        VivodHp1.setText(Game.player[0].getHp() + "");
        ViviodHp2.setText(Game.player[1].getHp() + "");


        Finish.setOnAction(event -> {
            if (Game.player[0].getHp() == 0 || Game.player[1].getHp() == 0) {
                db.upDate(Game.player[0]);
                db.upDate(Game.player[1]);
                Finish.getScene().getWindow().hide();

            } else {
                Pl2nikc.setText("Игра еще не окончена");
            }
        });


        nextRound.setOnAction(
                event -> {
                    if (Game.player[0].getHp() > 0 && Game.player[1].getHp() > 0) {
                        round.setText("Раунд " + count++);
                        round1.setText("Сейчас бьет  " + (tearn == 1 ? Game.player[1].getNikName() : Game.player[0].getNikName()));

                        if (tearn == 1) {
                            int k = Game.player[1].getHp();
                            System.out.println(Game.player[1].getHp() + " hp 2go");
                            Dmg2.setText(Game.Round(Game.player[0], Game.player[1]));
                            System.out.println(Game.player[1].getHp() + " hp 2go");
                            if (k < Game.player[1].getHp()) {
                                ViviodHp2.setText(k + " + " + (Game.player[1].getHp() - k));
                            }
                            VivodHp1.setText(Game.player[0].getHp() + "");
                            System.out.println("bers" + Game.player[1].hit());
                            System.out.println(Game.player[0].def(Game.player[1].hit()));
                        } else {
                            System.out.println(Game.player[0].getHp() + " hp 1go");
                            int k = Game.player[0].getHp();
                            Dmg1.setText(Game.Round(Game.player[0], Game.player[1]));
                            System.out.println(Game.player[0].getHp() + " hp 1go");
                            if (k < Game.player[0].getHp()) {
                                VivodHp1.setText(k + " + " + (Game.player[0].getHp() - k));
                            }
                            ViviodHp2.setText(Game.player[1].getHp() + "");
                            System.out.println("sam" + Game.player[0].hit());
                            System.out.println(Game.player[1].def(Game.player[0].hit()));
                        }
                        System.out.println("W");
                    } else {
                        ViviodHp2.setText("");
                        VivodHp1.setText("");
                        Dmg1.setText("");
                        Dmg2.setText("");
                        String rez = "Конец";
                        rez += Game.player[1].getHp() == 0 ? Game.player[0].getNikName() :
                                Game.player[1].getNikName();
                        round.setText(rez + " Победил");
                        if (count != 0) {

                            if (Game.player[1].getHp() == 0) {
                                Game.player[1].setDengi(Game.player[1].getDengi()+3 + Game.player[0].getLevel() / 2);
                                Game.player[1].setLevel(Game.player[1].getLevel()+ 2 + Game.player[1].getLevel() / 6);

                            } else {
                                Game.player[1].setDengi(Game.player[1].getDengi()+5 + Game.player[0].getLevel());
                                Game.player[1].setLevel(Game.player[1].getLevel()+3 + Game.player[1].getLevel() / 3);
                            }
                            if (Game.player[0].getHp() == 0) {
                                Game.player[0].setDengi(Game.player[0].getDengi()+3 + Game.player[1].getLevel() / 2);
                                Game.player[0].setLevel(Game.player[0].getLevel()+ 2 + Game.player[1].getLevel() / 6);

                            } else {
                                Game.player[0].setDengi(Game.player[0].getLevel()+5 + Game.player[1].getLevel());
                                Game.player[0].setLevel(Game.player[0].getLevel()+3 + Game.player[1].getLevel() / 3);
                            }
                            count = 0;

                        }
                    }
                });
    }
}
