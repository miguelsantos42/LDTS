package LoZ.Objects;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;

import com.googlecode.lanterna.TextColor;

public class Player extends GameObject{

    Bullet attackType;
    public Player(Position position, Size size, TextColor textColor, Life life) {

        super(position, size, textColor, life, 10);
    }

    public void doAttackPlayer(PoolBullets poolBullets){
        /*Bullet bullet = attackType.returnCopy();
        bullet.position.setxPos(this.position.getxPos());
        bullet.position.setyPos(this.position.getyPos());
        if ()
        {
            bullet.direction = Bullet.Direction.LEFT;
            bullet.position.setyPos(this.size.getWidth());
        }
        else if ()
        {
            bullet.direction = Bullet.Direction.RIGHT;
            bullet.position.setyPos(-1);
        }

        else if ()
        {
            bullet.direction = Bullet.Direction.DOWN;
            bullet.position.setxPos(this.size.getHeight());
        }

        else if ()
        {
            bullet.direction = Bullet.Direction.UP;
            bullet.position.setxPos(-1);
        }

        poolBullets.addBullet(bullet);*/
    }
}
