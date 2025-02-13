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
        solidArea.x = 12;
        solidArea.y = 20;
        solidArea.width = 24;
        solidArea.height = 27;

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

            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/CatUp1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/CatUp2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/CatDown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/CatDown2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/CatLeft1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/CatLeft2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/CatRight1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/CatRight2.png"));
            
        } catch (IOException e) {

            e.printStackTrace();
        
        }

    }

    public void update(){

        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){

            if(keyH.upPressed == true){

                direction = "up";
    
            }
            else if(keyH.rightPressed == true){
    
                direction = "right";
    
            }
            else if(keyH.downPressed == true){
    
                direction = "down";
    
            }
            else if(keyH.leftPressed == true){
    
                direction = "left";
    
            } 

            //CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //IF COLLISION IS FALSE, PLAYER CAN MOVE
            if(collisionOn == false){

                switch(direction){

                case "up" -> worldY -= speed; // playerY = playerY - playerSpeed;
                case "down" -> worldY += speed; // playerY = playerY + playerSpeed;
                case "left" -> worldX -= speed; // playerX = playerX - playerSpeed;
                case "right" -> worldX += speed; // playerX = playerX + playerSpeed;

                }

            }
    
            spriteCounter++;
            if(spriteCounter > 14){
    
                if(spriteNum == 1){
    
                    spriteNum = 2;
    
                }
                else if(spriteNum == 2){
    
                    spriteNum = 1;
    
                }
    
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
