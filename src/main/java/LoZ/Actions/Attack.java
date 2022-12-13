package LoZ.Actions;

import LoZ.Game;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Bullet;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Attack {
    public ArrayList<Bullet> bullets = new ArrayList<>();


    public Attack(){
        for (int i = 0; i < 100; i++) {
            Position outside = new Position(-1, -1);
            bullets.add(new Bullet(outside, "z", false));
        }
    }

    public void move(int width) {
        for (Bullet bullet : this.bullets) {
            bullet.moveBullet();
            if(bullet.position.getyPos()<0){
                bullet.notUsed();
            }
            else if(bullet.position.getyPos()>width){
                bullet.notUsed();
            }
        }
        try {
            TimeUnit.MILLISECONDS.sleep(Game.refreshTime / 20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void doAttack(int xPos, int yPos, boolean isFromMonster){
        for (Bullet bullet : bullets) {
            if (!bullet.isValid()) {
                if (isFromMonster) {
                    bullet.used(new Position(xPos + 1, yPos + 1), "z", true);
                } else {
                    bullet.used(new Position(xPos + 1, yPos - 1), "z", false);
                }
                break;
            }
        }
    }
}
