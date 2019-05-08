package sample.oop_plus_gamelojik;

import java.util.Random;

public class tamplier extends human {
    final String name = "Tamplier";

    public tamplier(int orujie, int shlem, int dospeh, int nogi, int breacer, int dengi, int level, String nikName) {
        super(orujie, shlem, dospeh, nogi, breacer, dengi, level, nikName);
        setHp(40 + ((getLevel()) * 50));
        setName("Tamplier");
    }

    public int getDmg() {
        int rez = 10;
        int dProg = 8;
        for (int i = 1; i <= this.getArmor(); i++) {
            rez += dProg++;
            dProg++;
        }
        int s = rnd.nextInt(rez + getLevel() / 10) - (rez + getLevel() / 20);
        return rez*2 + (getLevel()) + s;
    }

    public int getRezist() {
        int rez = 0;
        int dProg = 2;
        for (int i = 1; i <= this.getArmor(); i++) {
            rez += dProg++;
            dProg++;
        }
        return 100 - rez;

    }

    public int getShildBlock() {
        return (10 + getLevel() * 4) / 3;
    }


    public int getCritChanse() {
        int rez = 100;
        int dProg = 7;
        for (int i = 1; i <= this.getSword(); i++) {
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
        for (int i = 1; i <= this.getSword(); i++) {
            rez += dProg++;
        }
        return 100 - rez;
    }

    Random rnd = new Random(System.currentTimeMillis());

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
            dmg = dmg + getShildBlock() > 0 ? 0 : dmg + getShildBlock();
        if (dmg > 0)
            dmg = dmg - getShildBlock() < 0 ? 0 : dmg - getShildBlock();

        if (dmg < 0)
            return (double) -1 * (3 * dmg * getCritRezist() * getRezist() / 10000);
        if (dmg > 0)
            return (double) (dmg * getRezist()) / 100;
        return 0;
    }

    @Override
    public int getBush() {
        return 0;
    }

    @Override
    public String properties() {
        return "Щит блокирует " + getShildBlock() + " единиц";
    }


}
