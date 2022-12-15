package LoZ.Objects;

import java.util.ArrayList;

import static LoZ.GameController.ScreenController.LevelController.height;
import static LoZ.GameController.ScreenController.LevelController.width;

public class PoolPowerUps {

    private ArrayList<Enemy> poolPowerUps;

    /*private int size = 25;
    public PoolPowerUps(PowerUp typePowerUp) {
        poolPowerUps = new ArrayList<>();
        for (int i = 0; i <  size; i++) {
            poolPowerUps.add(new PowerUp(typePowerUp));
            poolPowerUps.get(i).instantKill();
        }

    }*/

    /*public void addPowerUp(PowerUp powerupCopy){
        for (int i = 0; i <  size; i++) {
            if(!poolPowerUps.get(i).isAlive()) {
                poolPowerUps.get(i).copy(powerupCopy);
                //poolPowerUps.get(i).getPosition().randomizePosition(player,
                       // poolPowerUps.get(i).size);
                break;
            }
        }
    }*/

}
