
package sample.oop_plus_gamelojik;

import java.util.Random;

import static sample.Main.tearn;

public class game {
    public  static human player[] = new human[2];
    static Random rnd = new Random(System.currentTimeMillis());

    public static int CoinFLip() {
        return rnd.nextInt(1);
    }

    public static int cost(int e) {
        int rez = 1;
        int dProg = 1;
        for (int i = 1; i <= e + 1; i++) {
            rez += dProg++;
        }
        return rez;
    }

    static int count = 0;

    public static String Round(human pl1, human pl2) {
        //try {
          //  TimeUnit.SECONDS.sleep(1);
       // } catch (InterruptedException e) {
        //    e.printStackTrace();}

        if (tearn != 1) {
            if (rnd.nextInt(100) <= pl2.getMiss()) {
                tearn = 2;
                return "miss";
            }
            int hit = pl1.hit();
            if (hit == 642077) {
                pl2.setHp(0);
                return "Лешился головы";
            }
            int rez = (int) pl2.def(hit);
            //урон
            pl2.setHp(pl2.getHp() - rez > 0 ? pl2.getHp() - rez : 0);
            //лечение
            pl1.setHp(pl1.getHp() + pl1.vampirism(hit) > pl1.MaxHp() ? pl1.MaxHp() : (int) (pl1.getHp() + pl1.vampirism(rez)));
            if (pl1.getBush() >= rnd.nextInt(1000)) {
                tearn = 2;
                return rez + " Оглушение";
            } else
                tearn = 1;
            return "-" + rez;
        } else {
            if (rnd.nextInt(100) <= pl1.getMiss()) {
                tearn = 1;
                return "miss";
            }
            int hit = pl2.hit();
            if (hit == 642077) {
                pl1.setHp(0);
                return "Лешился головы";
            }
            int rez = (int) pl1.def(hit);
            //урон
            pl1.setHp(pl1.getHp() - rez > 0 ? pl1.getHp() - rez : 0);
            //лечение
            pl2.setHp(pl2.getHp() + pl2.vampirism(hit) > pl2.MaxHp() ? pl2.MaxHp() : (int) (pl2.getHp() + pl2.vampirism(rez)));
            if (pl2.getBush() >= rnd.nextInt(1000)) {
                tearn = 1;
                return rez + " Оглушение";
            } else
                tearn = 2;
            return "-" + rez;
        }

    }

}
