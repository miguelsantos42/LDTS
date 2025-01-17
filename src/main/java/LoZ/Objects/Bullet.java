package LoZ.Objects;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Bullet extends GameObject{

    public enum Direction{
        LEFT, RIGHT, STOP, UP, DOWN
    }

    private String sprite;

    private boolean isEnemyBullet;

    protected static final int SHOT_VELOCITY = 5;

    public Direction direction = Direction.STOP;


    public Bullet(Position position, Size size, TextColor textColor, Life life, Boolean isEnemyBullet, Direction direction) {
        super(position, size, textColor, life, SHOT_VELOCITY);
        this.instantKill();
        this.isEnemyBullet = isEnemyBullet;
        this.direction = direction;
    }

    public void moveBullet(int widht, int height){
        if (position.getxPos() <= 0 || position.getxPos() + size.getWidth() >= widht
                || position.getyPos() <= 0 || position.getyPos() + size.getHeight() >= height){
            life.instantKill();
            return;
        }
        if(direction == Direction.LEFT){
            moveLeft();
        }
        else if(direction == Direction.RIGHT){
            moveRight(widht);
        }
        else if(direction == Direction.UP){
            moveUp(height);
        }
        else if(direction == Direction.DOWN){
            moveDown();
        }
    }



    public boolean isEnemy() {
        return isEnemyBullet;
    }

    public Bullet returnCopy(){
        Position newPosition = new Position(position.getxPos(), position.getyPos());
        Size newSize = new Size(size.getWidth(), size.getHeight());
        TextColor newTextColor = new TextColor.RGB(color.toColor().getRed(), color.toColor().getGreen(), color.toColor().getBlue());
        Life newLife = new Life(life.getMaximumLives());

        Bullet bullet = new Bullet(newPosition, newSize, newTextColor, newLife, this.isEnemyBullet, Bullet.Direction.STOP);

        bullet.sprite = this.sprite;
        bullet.isEnemyBullet = this.isEnemyBullet;
        bullet.direction = this.direction;
        return bullet;
    }


    public Bullet(Bullet bullet){
        super(new Position(bullet.position),
                new Size(bullet.size.getWidth(), bullet.size.getHeight()),
                new TextColor.RGB(bullet.color.toColor().getRed(),
                        bullet.color.toColor().getGreen(),
                        bullet.color.toColor().getBlue()),
                new Life(bullet.life.getMaximumLives()), SHOT_VELOCITY);

        this.isEnemyBullet = bullet.isEnemyBullet;
        this.direction = bullet.direction;
        this.sprite = bullet.sprite;
    }



    public void copy(Bullet bullet){
        this.position = new Position(bullet.position);
        this.size = new Size(bullet.size);
        super.color = new TextColor.RGB(bullet.color.toColor().getRed(),
                bullet.color.toColor().getGreen(),
                bullet.color.toColor().getBlue());
        this.life = new Life(bullet.life);

        this.isEnemyBullet = bullet.isEnemyBullet;
        this.direction = bullet.direction;
        this.sprite = bullet.sprite;
    }

    @Override
    public void draw(TextGraphics screen) {
        if (!life.isAlive()){
            return;
        }
        screen.setForegroundColor(this.color);
        for (int i = 0; i < size.getWidth(); i++) {
            for (int j = 0; j < size.getHeight(); j++) {
                screen.putString(position.getxPos()+i, position.getyPos()+j, "-");

            }

        }
        screen.putString(position.getxPos(), position.getyPos(), "-");
    }
}