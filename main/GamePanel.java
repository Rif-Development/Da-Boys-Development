package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 TILE
    final int scale = 3;

    final int tileSize = originalTileSize * scale; //48x48 TILE (ACTUAL SCREEN SIZE USING A SCALAR)
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 PIXELS
    final int screenHeight = tileSize * maxScreenRow; // 576 PIXELS

    Thread gameThread; // DECLARING gameThread

    // CONSTRUCTOR FOR GamePanel
    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //SETTING OBJECT SIZE
        this.setBackground(Color.black); // BACKGROUND COLOR: black
        this.setDoubleBuffered(true); //WAS TOLD THIS IS A GOOD BUFFERING SYSTEM FOR RENDERING IN NEW AREAS

    }

    // CONDSTRUCTING gameThread INTO A Thread
    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();

    }

    // Game Loop
    @Override
    public void run() {


        
    }
    
}
