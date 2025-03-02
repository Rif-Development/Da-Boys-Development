package src.object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject {

    @SuppressWarnings("CallToPrintStackTrace")
    public OBJ_Door(){

        name = "Door";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/door.png"));

        }catch(IOException e){

            e.printStackTrace();

        }

        collision = true;

        /* This is an example on how to change the collision on an object.
           You would need to put it here within the code.

            solidArea.x = 5;

           This is only an example. The 5 can be whatever number you decide.

        */

    }

}
