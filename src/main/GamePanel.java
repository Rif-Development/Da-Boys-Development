package src.main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import src.entity.Player;
import src.object.SuperObject;
import src.tile.TileManager;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 TILE
    final int scale = 4;

    public final int tileSize = originalTileSize * scale; //48x48 TILE (ACTUAL SCREEN SIZE USING A SCALAR)
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 15;
    public final int screenWidth = tileSize * maxScreenCol; // 3456 PIXELS
    public final int screenHeight = tileSize * maxScreenRow; // 2234 PIXELS

    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    // public final int worldWidth = tileSize * maxWorldCol;    Might not need but saving it just in case
    // public final int worldHeight = tileSize * maxWorldRow;   Might not need but saving it just in case

    // FPS
    int FPS = 60;

    // SYSTEM
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound sound = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    Thread gameThread; // DECLARING gameThread

    // ENTITY AND OBJECT
    public Player player = new Player(this,keyH);
    public SuperObject obj[] = new SuperObject[10]; //THE "10" MEANS HOW MANY OBJECTS CAN BE DISPLAYED AT THE SAME TIME. WE CAN ALWAYS INCREASE THIS NUMBER


    // CONSTRUCTOR FOR GamePanel
    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //SETTING OBJECT SIZE
        this.setBackground(Color.black); // BACKGROUND COLOR: black
        this.setDoubleBuffered(true); //WAS TOLD THIS IS A GOOD BUFFERING SYSTEM FOR RENDERING IN NEW AREAS
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    //Setts objects into world. Pulls from AssetSetter.java
    public void setUpGame(){

        aSetter.setObject();

        playMusic(0); // Grabs index from Sound.java

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
        @SuppressWarnings("unused")
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

                // System.out.println("FPS: " + drawCount); This displays the FPS in the terminal
                drawCount = 0;
                timer = 0;

            }
            
        }

    }

    public void update(){

        player.update();

    }

    // This calls all draw functions
    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        // Draws Tiles
        tileM.draw(g2);

        /* Object: if objects are having errors later on change this for loop back to
        for(int i = 0; i < obj.length; i++) */
        for (SuperObject obj1 : obj) {
            // By checking null, we make sure we don't get a null pointer error
            if (obj1 != null) {
                obj1.draw(g2, this);
            }
        }

        // Draws player
        player.draw(g2);

        g2.dispose();

    }

    // Sounds
    public void playMusic(int i){

        sound.setFile(i);
        sound.play();
        sound.loop();

    }

    public void stopMusic(){

        sound.stop();

    }

    // Play sound effect
    public void playSE(int i){

        sound.setFile(i);
        sound.play();

    }

}
