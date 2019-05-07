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

        if (ControllerVhod.player[1].getName().equals("Bers"))
            Pl1pict.setImage(imgBers);
        if (ControllerVhod.player[1].getName().equals("Tamplier"))
            Pl1pict.setImage(imgTampl);
        if (ControllerVhod.player[1].getName().equals("Samurai"))
            Pl1pict.setImage(imgSam);
        if (ControllerVhod.player[1].getName().equals("Valkiriya"))
            Pl1pict.setImage(imgValk);

        if (ControllerVhod.player[0].getName().equals("Bers"))
            Pl2pic.setImage(imgBerszer);
        if (ControllerVhod.player[0].getName().equals("Tamplier"))
            Pl2pic.setImage(imgTamplZer);
        if (ControllerVhod.player[0].getName().equals("Samurai"))
            Pl2pic.setImage(imgSamZer);
        if (ControllerVhod.player[0].getName().equals("Valkiriya"))
            Pl2pic.setImage(imgValkZer);
        // ViviodHp2.setText(ControllerVhod.player[1].getHp() + "");
        // VivodHp1.setText(ControllerVhod.player[0].getHp() + "");

        Pl2nikc.setText(ControllerVhod.player[1].getNikName());
        Pl2nikc1.setText(ControllerVhod.player[0].getNikName());

        Finish.setOnAction(event -> {
            if (ControllerVhod.player[0].getHp() == 0 || ControllerVhod.player[1].getHp() == 0) {
                db.upDate(ControllerVhod.player[0]);
                db.upDate(ControllerVhod.player[1]);
                Finish.getScene().getWindow().hide();

            } else {
                Pl2nikc.setText("Игра еще не окончена");
            }
        });


        nextRound.setOnAction(
                event -> {
                    if (ControllerVhod.player[0].getHp() > 0 && ControllerVhod.player[1].getHp() > 0) {
                        round.setText("Раунд " + count++);
                        round1.setText("Сейчас бьет  " + (tearn == 1 ? ControllerVhod.player[1].getNikName() : ControllerVhod.player[0].getNikName()));

                        if (tearn == 1) {
                            int k = ControllerVhod.player[1].getHp();
                            System.out.println(ControllerVhod.player[1].getHp() + " hp 2go");
                            Dmg2.setText(Game.Round(ControllerVhod.player[0], ControllerVhod.player[1]));
                            System.out.println(ControllerVhod.player[1].getHp() + " hp 2go");
                            if (k < ControllerVhod.player[1].getHp()) {
                                ViviodHp2.setText(k + " + " + (ControllerVhod.player[1].getHp() - k));
                            }
                            VivodHp1.setText(ControllerVhod.player[0].getHp() + "");
                            System.out.println("bers" + ControllerVhod.player[1].hit());
                            System.out.println(ControllerVhod.player[0].def(ControllerVhod.player[1].hit()));
                        } else {
                            System.out.println(ControllerVhod.player[0].getHp() + " hp 1go");
                            int k = ControllerVhod.player[0].getHp();
                            Dmg1.setText(Game.Round(ControllerVhod.player[0], ControllerVhod.player[1]));
                            System.out.println(ControllerVhod.player[0].getHp() + " hp 1go");
                            if (k < ControllerVhod.player[0].getHp()) {
                                VivodHp1.setText(k + " + " + (ControllerVhod.player[0].getHp() - k));
                            }
                            ViviodHp2.setText(ControllerVhod.player[1].getHp() + "");
                            System.out.println("sam" + ControllerVhod.player[0].hit());
                            System.out.println(ControllerVhod.player[1].def(ControllerVhod.player[0].hit()));
                        }
                        System.out.println("W");
                    } else {
                        ViviodHp2.setText("");
                        VivodHp1.setText("");
                        Dmg1.setText("");
                        Dmg2.setText("");
                        String rez = "Конец";
                        rez += ControllerVhod.player[1].getHp() == 0 ? ControllerVhod.player[0].getNikName() :
                                ControllerVhod.player[1].getNikName();
                        round.setText(rez + " Победил");
                        if (count != 0) {

                            if (ControllerVhod.player[1].getHp() == 0) {
                                ControllerVhod.player[1].setDengi(3 + ControllerVhod.player[0].getLevel() / 2);
                                ControllerVhod.player[1].setLevel(2 + ControllerVhod.player[1].getLevel() / 6);

                            } else {
                                ControllerVhod.player[1].setDengi(5 + ControllerVhod.player[0].getLevel());
                                ControllerVhod.player[1].setLevel(3 + ControllerVhod.player[1].getLevel() / 3);
                            }
                            if (ControllerVhod.player[0].getHp() == 0) {
                                ControllerVhod.player[0].setDengi(3 + ControllerVhod.player[1].getLevel() / 2);
                                ControllerVhod.player[0].setLevel(2 + ControllerVhod.player[0].getLevel() / 6);

                            } else {
                                ControllerVhod.player[0].setDengi(5 + ControllerVhod.player[1].getLevel());
                                ControllerVhod.player[0].setLevel(3 + ControllerVhod.player[0].getLevel() / 3);
                            }
                            count = 0;

                        }
                    }
                });
    }
}
