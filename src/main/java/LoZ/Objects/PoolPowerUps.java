package LoZ.Objects;

import LoZ.Objects.Attributes.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;

import static LoZ.GameController.ScreenController.LevelController.height;
import static LoZ.GameController.ScreenController.LevelController.width;

public class PoolPowerUps {

    private ArrayList<PowerUp> poolPowerUps;

    private int size = 25;
    public PoolPowerUps(PowerUp typePowerUp) {
        poolPowerUps = new ArrayList<>();
        for (int i = 0; i <  size; i++) {
            poolPowerUps.add(new PowerUp(typePowerUp));
            poolPowerUps.get(i).instantKill();
        }

    }

    public void addPowerUp(PowerUp powerupCopy, Position positionPowerUpFinal){
        for (int i = 0; i <  size; i++) {
            if(!poolPowerUps.get(i).isAlive()) {
                    poolPowerUps.get(i).copy(powerupCopy);
                    poolPowerUps.get(i).position.setxPos(positionPowerUpFinal.getxPos());
                    poolPowerUps.get(i).position.setyPos(positionPowerUpFinal.getyPos());
                    break;
            }
        }
    }


    public void drawPowerUps(TextGraphics graphics){
        for (PowerUp powerup : this.poolPowerUps) {
            if(powerup.isAlive()){
                powerup.draw(graphics);
            }
        }
    }

    public ArrayList<PowerUp> getPoolPowerUps(){
        return poolPowerUps;
    }

}
