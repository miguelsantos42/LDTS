package LoZ.Objects;

import LoZ.GameController.ScreenController.Console;
import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import static java.lang.System.nanoTime;

public class Player extends GameObject{

    Bullet attackType;
    int score;

    double time;

    public Player(Position position, Size size, TextColor textColor, Life life, Bullet bulletType) {

        super(position, size, textColor, life, 10);
        this.attackType = bulletType;
    }

    public void doAttack(PoolBullets poolBullets, Console.Action action){
        double currentTime = (nanoTime()/1000000000);
        if (currentTime - time < (double) speed/250){
            return;
        }
        time = currentTime;
        Bullet bullet = new Bullet(attackType);
        bullet.position.setxPos(this.position.getxPos());
        bullet.position.setyPos(this.position.getyPos());
        if (action==Console.Action.LEFT)
        {
            bullet.direction = Bullet.Direction.LEFT;
            bullet.position.setxPos(-1);
            bullet.position.setyPos(size.getHeight()/2);
        }
        else if (action==Console.Action.RIGHT)
        {
            bullet.direction = Bullet.Direction.RIGHT;
            bullet.position.setxPos(this.size.getWidth());
            bullet.position.setyPos(size.getHeight()/2);
        }

        else if (action==Console.Action.DOWN)
        {
            bullet.direction = Bullet.Direction.DOWN;
            bullet.position.setyPos(-1);
            bullet.position.setxPos(size.getWidth()/2);
        }

        else if (action==Console.Action.UP)
        {
            bullet.direction = Bullet.Direction.UP;
            bullet.position.setyPos(this.size.getHeight());
            bullet.position.setxPos(size.getWidth()/2);
        }

        poolBullets.addBullet(bullet);

    }

    public void drawInfo(TextGraphics screen) {
        screen.setForegroundColor(TextColor.ANSI.RED);
        screen.putString(1 , 1, String.valueOf(life.getCurrentLives()));
        screen.putString(1+1 , 1,"/");
        screen.putString(1+2 , 1, String.valueOf(life.getMaximumLives()));
        screen.putString(1+3 , 1, " lives");

        screen.putString(15 , 1, String.valueOf(score));
        screen.putString(16 , 1, " score");

    }
}
