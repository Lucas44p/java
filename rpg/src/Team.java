import java.util.List;

public class Team {
    private Battler battler;

    public Team(Battler battler) {
        this.battler = battler;
    }

    public boolean isLoose() {
        return this.battler.getHp() <= 0;
    }

    public Battler getBattler() {
        return this.battler;
    }
}
