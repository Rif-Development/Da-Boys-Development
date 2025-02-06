package src.main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import src.entity.Player;
import src.tile.TileManager;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 TILE
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; //48x48 TILE (ACTUAL SCREEN SIZE USING A SCALAR)
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 PIXELS
    public final int screenHeight = tileSize * maxScreenRow; // 576 PIXELS

    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread; // DECLARING gameThread
    public Player player = new Player(this,keyH);

    // CONSTRUCTOR FOR GamePanel
    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //SETTING OBJECT SIZE
        this.setBackground(Color.black); // BACKGROUND COLOR: black
        this.setDoubleBuffered(true); //WAS TOLD THIS IS A GOOD BUFFERING SYSTEM FOR RENDERING IN NEW AREAS
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    // CONDSTRUCTING gameThread INTO A Thread
    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();

    }

    // Game Loop
    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0; // FPS

        while(gameThread != null){

            // long currentTime = System.nanoTime(); // TIME IN GAME RUN MY NANO SECONDS
            // long currentTime2 = System.currentTimeMillis(); // THIS IS A WAY TO DO IT IN MILLI SECONDS BUT IS NOT AS ACCURATE
            // System.out.println("Current time: " + currentTime); //THIS PRINTS OUT CURRENT TIME

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){

                // 1 UPDATE: update information such as character poisitions
                update();

                // 2 DRAW: draw screen with the updated information
                repaint(); // THIS CALLS FUNCTION paintComponent

                delta--;

                drawCount++;
            }

            // FPS DISPLAYER
            if(timer >= 1000000000){

                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;

            }
            
        }

    }

    public void update(){

        player.update();

    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);

        player.draw(g2);

        g2.dispose();

    }

}
