public class Character {

    String pseudo;
    public int[] attributes;

    // encapsulation
    // le pseudo est privatee pour forcer les dev
    // a modifier le pseudo uniquement en passant par une fonction @param value

    public void setPseudo (String value) {
        pseudo = value;

        System.out.println("le pseudo a ete modifier") ;
    }
}