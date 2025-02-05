package src.main;


import javax.swing.JFrame;

public class Main{

    public static void main(String[] args) {
        
        // window OBJECT CREATION AND SETTINGS
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ALLOWS EXIT WHEN CLOSING THE WINDOW
        window.setResizable(false); // RESIZING THE WINDOW IS SET TO false
        window.setTitle("2D Adventure"); //TITLE OF THE GAME

        // CREATION OF NEW OBJECT gamePanel && ADDING IT TO window OBJECT
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        // SETTING LOCATION OF WINDOW
        window.setLocationRelativeTo(null); // WITH null YOU MAKE THE WINDOW DEFAULT TO THE CENTER OF THE SCREEN
        // MAKING THE SCREEN VISABLE
        window.setVisible(true);

        gamePanel.startGameThread();

    }
    
}