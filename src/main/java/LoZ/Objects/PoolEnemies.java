package LoZ.Objects;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;

public class PoolEnemies {

    private ArrayList<Enemy> poolEnemy;

    public PoolEnemies(Enemy typeEnemy) {
        poolEnemy = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            poolEnemy.add(new Enemy(typeEnemy));
            poolEnemy.get(i).instantKill();
        }
    }
    public void addEnemy(Enemy enemyCopy, Player player,int width,int height){
        for (Enemy enemy : this.poolEnemy) {
            if(!enemy.isAlive()) {
                enemy = new Enemy(enemyCopy);
                enemy.position.randomizePosition(player, enemy.getSize(), width, height);
                System.out.println(enemy.isAlive());
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
                System.out.println("draw");
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