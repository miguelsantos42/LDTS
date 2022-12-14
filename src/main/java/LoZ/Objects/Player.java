package LoZ.Objects;

import LoZ.GameController.ScreenController.Console;
import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;

public class Player extends GameObject{

    Bullet attackType1;
    public static Console.Action lastMovement;
    public Player(Position position, Size size, TextColor textColor, Life life, Bullet bulletType) {

        super(position, size, textColor, life, 10);
        this.attackType1 = bulletType;
    }

    public void doAttackPlayer(PoolBullets poolBullets){
        Bullet bullet = attackType1.returnCopy();
        bullet.position.setxPos(this.position.getxPos());
        bullet.position.setyPos(this.position.getyPos());
        if (lastMovement==Console.Action.LEFT)
        {
            bullet.direction = Bullet.Direction.LEFT;
            bullet.position.setyPos(this.size.getWidth());
        }
        else if (lastMovement==Console.Action.RIGHT)
        {
            bullet.direction = Bullet.Direction.RIGHT;
            bullet.position.setyPos(-1);
        }

        else if (lastMovement==Console.Action.DOWN)
        {
            bullet.direction = Bullet.Direction.DOWN;
            bullet.position.setxPos(this.size.getHeight());
        }

        else if (lastMovement==Console.Action.UP)
        {
            bullet.direction = Bullet.Direction.UP;
            bullet.position.setxPos(-1);
        }

        poolBullets.addBullet(bullet);
    }
}
