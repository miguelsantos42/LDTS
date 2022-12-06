package LoZ.Objects;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TextColor;

public class Enemy extends GameObject{

    public Enemy(Position position, Size size, TextColor textColor, Life life) {
        super(position, size, textColor, life, 50);
    }

    public void moveRandom(int widht, int height){
        if ((Math.random() * (2000))>1500) {
            moveLeft();
        }
        else if((Math.random() * (2000))>1000) {
            moveRight(widht);
        }
        else if((Math.random() * (2000))>500) {
            moveUp(height);
        }
        else if((Math.random() * (2000))>0) {
            moveDown();
        }
    }
}
