public class Game {
    private Team playerTeam;
    private Team enemyTeam;

    public Game(Team playerTeam, Team enemyTeam) {
        this.playerTeam = playerTeam;
        this.enemyTeam = enemyTeam;
    }
    public void play() {
        System.out.println("Le jeu commence!");

        while (!playerTeam.isLoose() && !enemyTeam.isLoose()) {
            Battler playerBattler = playerTeam.getBattler();
            Battler enemyBattler = enemyTeam.getBattler();

            playerBattler.attack(enemyBattler);
            if (!enemyTeam.isLoose()) {
                enemyBattler.attack(playerBattler);
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Team winner = getWinnerTeam();
        System.out.println("L'équipe gagnante est : " + winner.getBattler().getName());
    }
    public Team getWinnerTeam() {
        if (playerTeam.isLoose()) {
            return enemyTeam;
        } else {
            return playerTeam;
        }
    }
}
