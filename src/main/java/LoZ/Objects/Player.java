package LoZ.Objects;

import LoZ.GameController.ScreenController.Console;
import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Player extends GameObject{

    Bullet attackType;
    TerminalPosition lastMovement = Console.lastMovement;

    int score;
    public Player(Position position, Size size, TextColor textColor, Life life) {

        super(position, size, textColor, life, 10);
        score = 0;
    }

    public void doAttackPlayer(PoolBullets poolBullets){
        Bullet bullet = attackType.returnCopy();
        bullet.position.setxPos(this.position.getxPos());
        bullet.position.setyPos(this.position.getyPos());
        if (lastMovement.getColumn()==-1)
        {
            bullet.direction = Bullet.Direction.LEFT;
            bullet.position.setyPos(this.size.getWidth());
        }
        else if (lastMovement.getColumn()==1)
        {
            bullet.direction = Bullet.Direction.RIGHT;
            bullet.position.setyPos(-1);
        }

        else if (lastMovement.getRow()==1)
        {
            bullet.direction = Bullet.Direction.DOWN;
            bullet.position.setxPos(this.size.getHeight());
        }

        else if (lastMovement.getRow()==-1)
        {
            bullet.direction = Bullet.Direction.UP;
            bullet.position.setxPos(-1);
        }

        poolBullets.addBullet(bullet);
    }

    public void drawInfo(TextGraphics screen) {
        screen.setForegroundColor(TextColor.ANSI.RED);
        screen.putString(1 , 1, String.valueOf(life.getCurrentLives()));
        screen.putString(1+1 , 1,"/");
        screen.putString(1+2 , 1, String.valueOf(life.getMaximumLives()));
        screen.putString(1+3 , 1, " lifes");

        screen.putString(15 , 1, String.valueOf(score));
        screen.putString(16 , 1, " score");

    }
}
