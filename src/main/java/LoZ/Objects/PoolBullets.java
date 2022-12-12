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
        Size size = new Size(1, 1);
        TextColor color = TextColor.ANSI.BLACK;
        Life life = new Life(1);
        for (int i = 0; i < 100; i++) {
            poolBullets.add(new Bullet(outside, size, color, life, false,Bullet.Direction.STOP));
        }
    }

    public void moveBullets(int width, int height){
        for (Bullet bullet : this.poolBullets) {
            if(bullet.isAlive()){
                bullet.moveBullet(width, height);
            }
            if(bullet.position.getyPos()<0){
                bullet.instantKill();
            }
            else if(bullet.position.getyPos()>height){
                bullet.instantKill();
            }
            else if(bullet.position.getxPos()>width){
                bullet.instantKill();
            }
            else if(bullet.position.getxPos()<0){
                bullet.instantKill();
            }
        }
    }

    public void addBullet(Bullet bulletCopy){
        for (Bullet bullet : this.poolBullets) {
            if(!bullet.isValid()){
                bullet = bulletCopy;
                bullet.setValid(true);
                System.out.println(bullet.isAlive());
                break;
            }
        }
    }

    public void checkCollision(PoolEnemies poolEnemies, Player player){
        for (Bullet bullet : this.poolBullets) {
            if (!bullet.isValid()){
                continue;
            }
            if(bullet.isAlive() && bullet.isEnemy()){
                player.checkCollision(bullet);
            }
            else if (bullet.isAlive() && !bullet.isEnemy()) {
                for (Enemy enemy : poolEnemies.getPoolEnemy()) {
                    enemy.checkCollision(bullet);
                }
            }
            if(!bullet.isAlive()){
                bullet.setValid(false);
            }
        }
    }

    public void drawBullets(TextGraphics graphics){
        for (Bullet bullet : this.poolBullets) {
            if (bullet.isValid() && bullet.isAlive()){
                bullet.draw(graphics);
            }
        }
    }
    public ArrayList<Bullet> getPoolBullets(){
        return poolBullets;
    }
}
