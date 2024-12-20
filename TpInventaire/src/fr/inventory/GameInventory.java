package fr.inventory;

public class GameInventory {

    public String name;
    public String quantity;

    public GameInventory(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + " : " + quantity;
    }



}