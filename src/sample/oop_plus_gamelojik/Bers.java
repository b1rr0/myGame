package sample.oop_plus_gamelojik;

import java.util.Random;

public class Bers extends Human {

    public Bers(int orujie, int shlem, int dospeh, int nogi, int breacer, int dengi, int level, String nikName) {
        super(orujie, shlem, dospeh, nogi, breacer, dengi, level, nikName);
        setHp(70+((getLevel()) * 50));
        setName("Bers");
    }

    static Random rnd = new Random(System.currentTimeMillis());


    public int getDmg() {
        int rez = 10;
        int dProg = 8;
        for (int i = 1; i <= this.getDospeh(); i++) {
            rez += dProg++;
            dProg++;
        }
        int s = rnd.nextInt(rez + getLevel() / 10) - (rez + getLevel() / 20);
        System.out.println("bers atack" + +rez + (getLevel()) + s);
        return rez*2 + (getLevel()) + s;
    }

    public int getRezist() {
        int rez = 0;
        int dProg = 2;
        for (int i = 1; i <= this.getDospeh(); i++) {
            rez += dProg++;
            dProg++;
        }
        return 100 - rez;
    }

    public int getBush() {
        return getLevel() > 200 ? 350 : 150 + getLevel() * 2;
    }

    public int getCritChanse() {
        int rez = 100;
        int dProg = 7;
        for (int i = 1; i <= this.getOrujie(); i++) {
            rez += dProg;
            dProg += 7;
        }
        return rez;
    }

    public int getCritKoff() {
        int rez = 3;
        int dProg = 3;
        for (int i = 1; i <= this.getBreacer(); i++) {
            rez += dProg++;
        }
        return rez;
    }


    public int getCritRezist() {
        int rez = 0;
        int dProg = 3;
        for (int i = 1; i <= this.getOrujie(); i++) {
            rez += dProg++;
        }
        return 100 - rez;
    }


    @Override
    public int hit() {
        if (rnd.nextInt(100) <= getCritChanse())
            return -1 * getDmg() * getCritKoff() / 100;
        return getDmg();
    }

    @Override
    public double def(int dmg) {
        if (dmg == 642077)
            return 642077;
        if (dmg < 0)
            return (double) -1 * (3 * dmg * (getCritRezist())) * getRezist() / 10000;
        if (dmg > 0)
            return (double) (dmg * getRezist()) / 100;
        return 0;
    }

    @Override
    public String Osobennost() {
        return "Шанс оглушить соперника " + getBush() / 10 + "%";
    }

}
