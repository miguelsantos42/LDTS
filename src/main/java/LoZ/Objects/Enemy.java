package LoZ.Objects;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TextColor;

public class Enemy extends GameObject{

    public Enemy(Position position, Size size, TextColor textColor, Life life) {
        super(position, size, textColor, life, 50);
    }
    public void moveTowardsPlayer(int widht, int height, Player player){
        double rand = Math.random() * 20;

        if (rand>3) {
            moveRandom(width, heigth);
        }
        else if(rand>2) {
            moveRight(widht);
        }
        else if(rand > 1 ) {
            moveUp(height);
        }
        else{
            moveDown();
        }
        if(playerX > this.position.getxPos()){
            this.moveRight(100);
        }
        else if(playerX < this.position.getxPos()){
            this.moveLeft();
        }
        if(playerY > this.position.getyPos()){
            this.moveDown();
        }
        else if(playerY < this.position.getyPos()){
            this.moveUp(100);
        }
    }
    public void moveRandom(int widht, int height){
        double rand = Math.random() * 4;
        if (rand>3) {
            moveLeft();
        }
        else if(rand>2) {
            moveRight(widht);
        }
        else if(rand > 1 ) {
            moveUp(height);
        }
        else{
            moveDown();
        }
    }
}
