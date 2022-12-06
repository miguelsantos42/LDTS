package LoZ.Objects;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;

public class PoolEnemies {

    private ArrayList<Enemy> poolEnemy;

    public PoolEnemies() {
         poolEnemy = new ArrayList<>();
    }

    public void moveEnemies(int width, int height){
        for (Enemy enemy : this.poolEnemy) {
            if(enemy.isAlive()){
                enemy.moveRandom(width, height);
            }
            if(enemy.position.getyPos()<0){
                enemy.instantKill();
            }
            else if(enemy.position.getyPos()>height){
                enemy.instantKill();
            }
            else if(enemy.position.getxPos()>width){
                enemy.instantKill();
            }
            else if(enemy.position.getxPos()<0){
                enemy.instantKill();
            }
        }
    }

    public void addEnemy(Enemy enemy){
        poolEnemy.add(enemy);
    }

    public ArrayList<Enemy> getPoolEnemy() {
        return poolEnemy;
    }

    public void checkCollision(PoolBullets poolBullets, Player player){
        for (Enemy enemy : this.poolEnemy) {
            if(enemy.isAlive()){
                for (Bullet bullet : poolBullets.getPoolBullets()) {
                    enemy.checkCollision(bullet);
                }
            }
            enemy.checkCollision(player);
        }
    }

    public void drawEnemies(TextGraphics graphics){
        for (Enemy enemy : this.poolEnemy) {
            if(enemy.isAlive()){
                enemy.draw(graphics);
            }
        }
    }

    public void moveEnemiesToPlayer(int width, int height, Player player, PoolBullets poolBullets){
        for (Enemy enemy : this.poolEnemy) {
            if(enemy.isAlive()){
                enemy.moveTowardsPlayer(width, height, player, poolBullets);
            }
        }
    }

    public boolean leftAtLeastOneEnemy(){
        for (Enemy enemy : this.poolEnemy) {
            if(enemy.isAlive()){
                return true;
            }
        }
        return false;
    }
}