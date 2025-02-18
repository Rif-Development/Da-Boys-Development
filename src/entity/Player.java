package src.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import src.main.GamePanel;
import src.main.KeyHandler;

public final class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 14;
        solidArea.y = 16;
        solidArea.width = 35;
        solidArea.height = 44;

        setDefaultValues();
        getPlayerImage();

    }
    
    public void setDefaultValues(){

        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";

    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void getPlayerImage(){

        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/GutsUp1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/GutsUp2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/GutsDown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/GutsDown2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/GutsLeft1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/GutsLeft2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/GutsRight1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/GutsRight2.png"));
            
        } catch(IOException e) {

            e.printStackTrace();
        
        }

    }

    public void update(){

        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {

            // Determine movement direction (priority order matters)
            if(keyH.upPressed && !keyH.downPressed && !keyH.leftPressed && !keyH.rightPressed) {

                direction = "up";

            }else if(keyH.downPressed && !keyH.upPressed && !keyH.leftPressed && !keyH.rightPressed) {

                direction = "down";

            }else if(keyH.leftPressed && !keyH.rightPressed && !keyH.upPressed && !keyH.downPressed) {

                direction = "left";

            }else if(keyH.rightPressed && !keyH.leftPressed && !keyH.upPressed && !keyH.downPressed) {

                direction = "right";

            }
        
            // Check for tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
        
            // Move if no collision
            if(!collisionOn) {

                switch(direction) {

                    case "up" -> worldY -= speed;
                    case "down" -> worldY += speed;
                    case "left" -> worldX -= speed;
                    case "right" -> worldX += speed;

                }

            }
        
            // Sprite Animation Logic
            if(++spriteCounter > 14) {

                spriteNum = (spriteNum == 1) ? 2 : 1;
                spriteCounter = 0;

            }

        }

    }

    public void draw(Graphics2D g2){

//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize); // OUR WHITE SQUARE

        BufferedImage image = null;

        switch(direction){

        case "up" -> {
            if(spriteNum == 1){

                image = up1;

            }

            if(spriteNum == 2){

                image = up2;

            }
            }

        case "down" -> {
            if(spriteNum == 1){

                image = down1;

            }

            if(spriteNum == 2){

                image = down2;

            }
            }

        case "left" -> {
            if(spriteNum == 1){

                image = left1;

            }

            if(spriteNum == 2){

                image = left2;

            }
            }

        case "right" -> {
            if(spriteNum == 1){

                image = right1;

            }

            if(spriteNum == 2){

                image = right2;

            }
            }

        }

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }
    
}
