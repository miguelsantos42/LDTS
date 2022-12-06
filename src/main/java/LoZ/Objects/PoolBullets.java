package LoZ.Objects;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;

public class PoolBullets{
    private ArrayList<Bullet> poolBullets;

    public PoolBullets() {
        poolBullets = new ArrayList<>();
    }

    public void moveBullets(int width, int height, int time){
        for (Bullet bullet : this.poolBullets) {
            if(bullet.speed%time!=0){
                continue;
            }
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

    public void addBullet(Bullet bullet){
        poolBullets.add(bullet);
    }

    public void checkCollision(PoolEnemies poolEnemies, Player player){
        for (Bullet bullet : this.poolBullets) {

            if(bullet.isAlive() && bullet.isEnemy()){
                player.checkCollision(bullet);
            }
            if (bullet.isAlive() && !bullet.isEnemy()) {
                for (Enemy enemy : poolEnemies.getPoolEnemy()) {
                    enemy.checkCollision(bullet);
                }
            }
        }
    }

    public void drawBullets(TextGraphics graphics){
        for (Bullet bullet : this.poolBullets) {
            if(bullet.isAlive()){
                bullet.draw(graphics);
            }
        }
    }
    public ArrayList<Bullet> getPoolBullets(){
        return poolBullets;
    }
}
