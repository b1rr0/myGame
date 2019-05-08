package sample.oop_plus_gamelojik;

public abstract class human {

    private int sword;
    private int helmet;
    private int armor;
    private int leggings;
    private int breacer;
    private int money;
    private int hp;
    private String name;
    private String nikName;
    private int level;


    public human(int orujie, int shlem, int dospeh, int nogi, int breacer, int dengi, int level, String nikName) {
        this.sword = orujie;
        this.helmet = shlem;
        this.armor = dospeh;
        this.leggings = nogi;
        this.breacer = breacer;
        this.money = dengi;
        this.level = level;
        this.nikName = nikName;
    }

    public human(String nikName) {
        this.sword = 1;
        this.helmet = 1;
        this.armor = 1;
        this.leggings = 1;
        this.breacer = 1;
        this.level = 1;
        this.nikName = nikName;
    }

    public int getSword() {
        return sword;
    }

    public int getHelmet() {
        return helmet;
    }

    public int getArmor() {
        return armor;
    }
    
    public int getLeggins() {
        return leggings;
    }

    public int getBreacer() {
        return breacer;
    }

    public int getMoney() {
        return money;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public void setHp(int Hp) {
        this.hp = Hp;
    }

    public void setMoney(int money) {
        this.money = money;
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

    public void upSword() {
        this.sword++;
    }
    
    public void upShlem() {
        this.helmet++;
    }

    public void upDospeh() {
        this.armor++;
    }

    public void upNogi() {
        this.leggings++;
    }

    public void upBreacer() {
        this.breacer++;
    }

    public void buy(int summa) {
        this.money -= summa;

    }

    public double vampirism(int i) {
        return 0;
    }

    public int MaxHp() {
        return 70+((getLevel()) * 50);
    }

    public abstract int hit();

    public abstract double def(int dmg);

    public abstract int getBush();

    public abstract String properties();

    public int getMiss() {
        return getBreacer();
    }
}

