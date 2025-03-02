package src.main;

import src.object.OBJ_Chest;
import src.object.OBJ_Door;
import src.object.OBJ_Key;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){

        this.gp = gp;

    }

    //Manual way to place objects into world. Have to specify the tile it is on
    public void setObject(){

        //Keys
        gp.obj[0] = new OBJ_Key();              //This is creating the object
        gp.obj[0].worldX = 23 * gp.tileSize;    //This is placing the object on the x-axis (the number being multiplied by the tileSize is the tile number of which the object will be placed on)
        gp.obj[0].worldY = 7 * gp.tileSize;     //This is placing the object on the y-axis (the number being multiplied by the tileSize is the tile number of which the object will be placed on)

        gp.obj[1] = new OBJ_Key();              //This is creating the object
        gp.obj[1].worldX = 23 * gp.tileSize;    //This is placing the object on the x-axis (the number being multiplied by the tileSize is the tile number of which the object will be placed on)
        gp.obj[1].worldY = 40 * gp.tileSize;    //This is placing the object on the y-axis (the number being multiplied by the tileSize is the tile number of which the object will be placed on)

        gp.obj[2] = new OBJ_Key();              //This is creating the object
        gp.obj[2].worldX = 37 * gp.tileSize;    //This is placing the object on the x-axis (the number being multiplied by the tileSize is the tile number of which the object will be placed on)
        gp.obj[2].worldY = 7 * gp.tileSize;     //This is placing the object on the y-axis (the number being multiplied by the tileSize is the tile number of which the object will be placed on)

        //Doors
        gp.obj[3] = new OBJ_Door();             //This is creating the object
        gp.obj[3].worldX = 10 * gp.tileSize;    //This is placing the object on the x-axis (the number being multiplied by the tileSize is the tile number of which the object will be placed on)
        gp.obj[3].worldY = 11 * gp.tileSize;     //This is placing the object on the y-axis (the number being multiplied by the tileSize is the tile number of which the object will be placed on)

        gp.obj[4] = new OBJ_Door();             //This is creating the object
        gp.obj[4].worldX = 8 * gp.tileSize;     //This is placing the object on the x-axis (the number being multiplied by the tileSize is the tile number of which the object will be placed on)
        gp.obj[4].worldY = 28 * gp.tileSize;    //This is placing the object on the y-axis (the number being multiplied by the tileSize is the tile number of which the object will be placed on)

        gp.obj[5] = new OBJ_Door();             //This is creating the object
        gp.obj[5].worldX = 12 * gp.tileSize;    //This is placing the object on the x-axis (the number being multiplied by the tileSize is the tile number of which the object will be placed on)
        gp.obj[5].worldY = 22 * gp.tileSize;    //This is placing the object on the y-axis (the number being multiplied by the tileSize is the tile number of which the object will be placed on)

        //Chests
        gp.obj[6] = new OBJ_Chest();            //This is creating the object
        gp.obj[6].worldX = 10 * gp.tileSize;    //This is placing the object on the x-axis (the number being multiplied by the tileSize is the tile number of which the object will be placed on)
        gp.obj[6].worldY = 8 * gp.tileSize;     //This is placing the object on the y-axis (the number being multiplied by the tileSize is the tile number of which the object will be placed on)

    }
    
}
