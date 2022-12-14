package LoZ.Objects;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;

public class PoolEnemies {

    private ArrayList<Enemy> poolEnemy;
    private int size = 25;
    public PoolEnemies(Enemy typeEnemy) {
        poolEnemy = new ArrayList<>();
        for (int i = 0; i <  size; i++) {
            poolEnemy.add(new Enemy(typeEnemy));
            poolEnemy.get(i).instantKill();
        }

    }
    public void addEnemy(Enemy enemyCopy, Player player,int width,int height){
        for (int i = 0; i <  size; i++) {
            if(!poolEnemy.get(i).isAlive()) {
                poolEnemy.get(i).copy(enemyCopy);
                poolEnemy.get(i).getPosition().randomizePosition(player,
                        poolEnemy.get(i).size,width,height);
                break;
            }
        }
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