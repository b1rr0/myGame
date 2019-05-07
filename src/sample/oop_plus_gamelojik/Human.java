package sample.oop_plus_gamelojik;

public abstract class Human {

    private int orujie;
    private int shlem;
    private int dospeh;
    private int nogi;
    private int breacer;
    private int dengi;
    private int Hp;
    private String name;
    private String nikName;
    private int level;


    public Human(int orujie, int shlem, int dospeh, int nogi, int breacer, int dengi, int level, String nikName) {
        this.orujie = orujie;
        this.shlem = shlem;
        this.dospeh = dospeh;
        this.nogi = nogi;
        this.breacer = breacer;
        this.dengi = dengi;
        this.level = level;
        this.nikName = nikName;
    }

    public Human(String nikName) {
        this.orujie = 1;
        this.shlem = 1;
        this.dospeh = 1;
        this.nogi = 1;
        this.breacer = 1;
        this.level = 1;
        this.nikName = nikName;
    }

    public int getOrujie() {
        return orujie;
    }

    public int getShlem() {
        return shlem;
    }

    public int getDospeh() {
        return dospeh;
    }

    public int getNogi() {
        return nogi;
    }

    public int getBreacer() {
        return breacer;
    }

    public int getDengi() {
        return dengi;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return Hp;
    }

    public String getName() {
        return name;
    }

    public void setHp(int Hp) {
        this.Hp = Hp;
    }

    public void setDengi(int dengi) {
        this.dengi = dengi;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNikName() {
        return nikName;
    }

    public void upOrujie() {
        this.orujie++;
    }

    public void upShlem() {
        this.shlem++;
    }

    public void upDospeh() {
        this.dospeh++;
    }

    public void upNogi() {
        this.nogi++;
    }

    public void upBreacer() {
        this.breacer++;
    }

    public void buy(int summa) {
        this.dengi -= summa;

    }

    public double Vampir(int i) {
        return 0;
    }

    public int MaxHp() {
        return 40 + ((getLevel() / 3) * 50);
    }

    public abstract int hit();

    public abstract double def(int dmg);

    public abstract int getBush();

    public abstract String Osobennost();

    public int getMiss() {
        return getBreacer();
    }
}

