package src.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import src.main.GamePanel;
import src.main.KeyHandler;

public final class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();

    }
    
    public void setDefaultValues(){

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";

    }

    public void getPlayerImage(){

        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/KnightPXL.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/KnightPXL_No_Weapon.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/KnightPXL.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/KnightPXL_No_Weapon.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/KnightPXL.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/KnightPXL_No_Weapon.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/KnightPXL.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/KnightPXL_No_Weapon.png"));
            
        } catch (IOException e) {

            e.printStackTrace();
        
        }

    }

    public void update(){

        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true ){

            if(keyH.upPressed == true){

                direction = "up";
                y -= speed; // playerY = playerY - playerSpeed;
    
            }
            else if(keyH.downPressed == true){
    
                direction = "down";
                y += speed; // playerY = playerY + playerSpeed;
    
            }
            else if(keyH.leftPressed == true){
    
                direction = "left";
                x -= speed; // playerX = playerX - playerSpeed;
    
            }
            else if(keyH.rightPressed == true){
    
                direction = "right";
                x += speed; // playerX = playerX + playerSpeed;
    
            }
    
            spriteCounter++;
            if(spriteCounter > 12){
    
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

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }
    
}
