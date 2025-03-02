package src.object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_Chest extends SuperObject {

    @SuppressWarnings("CallToPrintStackTrace")
    public OBJ_Chest(){

        name = "Chest";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/chest.png"));

        }catch(IOException e){

            e.printStackTrace();

        }

        /* This is an example on how to change the collision on an object.
           You would need to put it here within the code.

            solidArea.x = 5;

           This is only an example. The 5 can be whatever number you decide.

        */

    }

}
