package LoZ.Objects;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;

public class PoolBullets{
    private ArrayList<Bullet> poolBullets;

    public PoolBullets(Bullet typeBullet) {
        poolBullets = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            poolBullets.add(new Bullet(typeBullet));
            poolBullets.get(i).instantKill();
        }
    }

    public void moveBullets(int width, int height){
        for (Bullet bullet : this.poolBullets) {
            if(bullet.isAlive()){
                bullet.moveBullet(width, height);
            }
        }
    }

    public void addBullet(Bullet bulletCopy){
        for (int i = 0; i < 25; i++) {
            if(!poolBullets.get(i).isAlive()) {
                poolBullets.get(i).copy(bulletCopy);
                break;
            }
        }
    }



    public void drawBullets(TextGraphics graphics){
        for (Bullet bullet : this.poolBullets) {
            if (bullet.isAlive()){
                bullet.draw(graphics);
            }
        }
    }
    public ArrayList<Bullet> getPoolBullets(){
        return poolBullets;
    }
}
