package sample.oop_plus_gamelojik;
import java.util.Random;

public class Samurai extends Human {
    final String name = "Samurai";

    public Samurai(int orujie, int shlem, int dospeh, int nogi, int breacer, int dengi, int level, String nikName) {
        super(orujie, shlem, dospeh, nogi, breacer, dengi, level, nikName);
        setHp(40+ ((getLevel() ) * 50));
        setName("Samurai");
    }


    public int getDmg() {
        int rez = 10;
        int dProg = 8;
        for (int i = 1; i <= this.getDospeh(); i++) {
            rez += dProg++;
            dProg++;
        }
        int s = rnd.nextInt(rez + getLevel() / 10) - (rez + getLevel() / 20);
        return rez*2 + (getLevel())+ s;
    }

    public double getExtraCrit() {
        return getLevel() > 200 ? 50 : 5 + getLevel() / 3;
    }


    public int getRezist() {
        int rez = 0;
        int dProg = 2;
        for (int i = 1; i <= this.getDospeh(); i++) {
            rez += dProg++;
            dProg++;
        }
        return 100 - (rez / 2 + rez / 10);

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

    Random rnd = new Random(System.currentTimeMillis());

    @Override
    public int hit() {
        if (rnd.nextInt(1000) <= getExtraCrit())
            return 642077;
        if (rnd.nextInt(100) <= getCritChanse())
            return -1 * getDmg() * getCritKoff() / 100;
        return getDmg();

    }

    @Override
    public double def(int dmg) {
        System.out.println("rez " + getRezist());
        System.out.println("rez " + getCritRezist());
        if (rnd.nextInt(1000) <= getMiss())
            return 0;
        if (dmg == 642077)
            return 642077;
        if (dmg < 0)
            return (double) -1 * (3 * dmg * (getCritRezist())) * getRezist() / 10000;
        if (dmg > 0) {
            return (double) (dmg * getRezist()) / 100;
        }
        return 0;
    }

    @Override
    public int getBush() {
        return 0;
    }

    @Override
    public String Osobennost() {
        return "Шанс убить " + ((double) getExtraCrit()) / 10 + "%";
    }
}
