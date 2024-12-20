import fr.inventory.GameInventory;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        // Créer une fenêtre
        JFrame frame = new JFrame();

        // Définir le titre de la fenêtre
        frame.setTitle("Inventory");

        // Taille de la fenêtre
        frame.setSize(800, 600);

        // Comportement à la fermeture
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JTextField nameField = new JTextField("Nom du jeu", 15);
        JTextField quantityField = new JTextField("Quantité", 10);
        JButton addButton = new JButton("Ajouter");
        JButton removeButton = new JButton("Supprimer");

        DefaultListModel<GameInventory> listModel = new DefaultListModel<>();
        JList<GameInventory> gameList = new JList<>( listModel);
        JScrollPane listScrollPane = new JScrollPane(gameList);


        JPanel inputPanel = new JPanel();
        inputPanel.add(nameField);
        inputPanel.add(quantityField);
        inputPanel.add(addButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeButton);


        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(listScrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);




        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String quantity =  quantityField.getText();

            if(name.isEmpty() || quantity.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Les champs ne peuvent pas être vides", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try{
                int quantityInt = Integer.parseInt(quantity);
                if (quantityInt < 0) {
                    JOptionPane.showMessageDialog(frame, "La quantité doit être un nombre entier supérieur ou égal à 0", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "La quantité doit être un nombre entier", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            GameInventory gameInventory = new GameInventory(name, quantity);


            listModel.addElement(gameInventory);


            nameField.setText("");
            quantityField.setText("");


            gameList.revalidate();
            gameList.repaint();
        });


        removeButton.addActionListener(e -> {
            GameInventory selectedGame = gameList.getSelectedValue();

            if (selectedGame == null) {
                JOptionPane.showMessageDialog(frame, "Veuillez sélectionner un jeu à supprimer", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            listModel.removeElement(selectedGame);

            gameList.revalidate();
            gameList.repaint();
        });


        frame.setVisible(true);
    }

}
