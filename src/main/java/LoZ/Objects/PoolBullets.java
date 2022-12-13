package LoZ.Objects;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;

public class PoolBullets{
    private ArrayList<Bullet> poolBullets;

    public PoolBullets() {
        poolBullets = new ArrayList<>();
        Position outside = new Position(-1, -1);
        Size size = new Size(2, 2);
        TextColor color = new TextColor.RGB(135, 122, 56);
        Life life = new Life(2);
        for (int i = 0; i < 100; i++) {
            poolBullets.add(new Bullet(outside, size, color, life, false,Bullet.Direction.STOP));
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
        for (Bullet bullet : this.poolBullets) {
            if(!bullet.isAlive()){
                bullet.copy(bulletCopy);
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
