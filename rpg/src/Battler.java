public class Battler {
    public String name;
    public int hp;
    public int power;


    public Battler(String name, int hp, int power) {
        this.name = name;
        this.hp = hp;
        this.power = power;
    }

    public void attack(Battler opponent) {
        System.out.println(this.name + " attaque " + opponent.name + " avec une puissance de " + this.power);
        opponent.looseHP(this.power);
    }

    public void looseHP(int amount) {
        this.hp -= amount;
        if (this.hp < 0)
        System.out.println(this.name + " perd " + amount + " HP, il reste " + this.hp + " HP.");
    }

    public int getHp() {
        return this.hp;
    }

    public String getName() {
        return this.name;
    }
}



