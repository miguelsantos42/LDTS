package LoZ.Objects;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;

public class PoolEnemies {

    private ArrayList<Enemy> poolEnemy;

    public PoolEnemies() {
         poolEnemy = new ArrayList<>();
    }


    public void addEnemy(Enemy enemy){
        poolEnemy.add(enemy);
    }

    public ArrayList<Enemy> getPoolEnemy() {
        return poolEnemy;
    }


    public void drawEnemies(TextGraphics graphics){
        for (Enemy enemy : this.poolEnemy) {
            if(enemy.isAlive()){
                enemy.draw(graphics);
            }
        }
    }

    public void moveEnemiesToPlayer(int width, int height, Player player, PoolBullets poolBullets){
        double randomState;
        for (Enemy enemy : this.poolEnemy) {
            if(enemy.isAlive()){
                randomState = (Math.random() * 4);
                enemy.moveTowardsPlayer(width, height, player, poolBullets, randomState);
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