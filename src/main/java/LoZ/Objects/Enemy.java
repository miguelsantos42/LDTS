package LoZ.Objects;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TextColor;

public class Enemy extends GameObject{

    public Enemy(Position position, Size size, TextColor textColor, Life life) {
        super(position, size, textColor, life, 50);
    }

    public void moveRandom(int width, int height){
        double rand = Math.random() * 20;
        if (rand>15) {
            moveLeft();
        }
        else if(rand>10) {
            moveRight(width);
        }
        else if(rand > 5 ) {
            moveUp(height);
        }
        else{
            moveDown();
        }
    }
}
