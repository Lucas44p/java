public class Main {
    public static void main(String[] args) {

        Battler playerBattler = new Battler("Equipe1", 100, 20);
        Battler enemyBattler = new Battler("Equipe2", 80, 25);

        Team playerTeam = new Team(playerBattler);
        Team enemyTeam = new Team(enemyBattler);

        Game game = new Game(playerTeam, enemyTeam);
        game.play();
    }
}
