package LoZ.GameController.LevelStateController;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import LoZ.Objects.Bullet;
import LoZ.Objects.Enemy;
import LoZ.Objects.Player;
import LoZ.Objects.PowerUp;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.Random;

public class LeveLCreator {

    Random random = new Random();
    PowerUp typePowerUp;
    ArrayList<Enemy> kindEnemies  = new ArrayList<>();
    ArrayList<PowerUp> kindPowerUps  = new ArrayList<>();
    ArrayList<Bullet> kindBullets = new ArrayList<>();

    Player player;

    private final TextColor playerColor = new TextColor.RGB(255, 255, 255);
    private final TextColor bulletPlayerColor = new TextColor.RGB(148, 0, 211);
    private final TextColor powerupColor = new TextColor.RGB(50, 205, 50);


    public LeveLCreator(){

        Position initialPosition = new Position(0,0);

        Size bulletSizeSmall = new Size(1,1);
        Size bulletSizeMedium = new Size(2,2);
        Size bulletSizeBig = new Size(3,3);

        ArrayList<Life> lifeMonsters = new ArrayList<>();
        ArrayList<TextColor> colorMonsters = new ArrayList<>();
        ArrayList<Size> sizeMonsters = new ArrayList<>();
        ArrayList<Bullet> bulletsMonsters = new ArrayList<>();

        lifeMonsters.add(new Life(2));
        colorMonsters.add(new TextColor.RGB(135, 20, 20));
        sizeMonsters.add(new Size(2,2));
        bulletsMonsters.add(new Bullet(initialPosition, bulletSizeSmall, colorMonsters.get(0), new Life(1), true, Bullet.Direction.STOP, 3));


        lifeMonsters.add(new Life(3));
        colorMonsters.add(new TextColor.RGB(20, 150, 20));
        sizeMonsters.add(new Size(3,3));
        bulletsMonsters.add(new Bullet(initialPosition, bulletSizeSmall, colorMonsters.get(1), new Life(1), true, Bullet.Direction.STOP, 5));

        lifeMonsters.add(new Life(5));
        colorMonsters.add(new TextColor.RGB(50, 50, 50));
        sizeMonsters.add(new Size(2,2));
        bulletsMonsters.add(new Bullet(initialPosition, bulletSizeMedium, colorMonsters.get(2), new Life(2), true, Bullet.Direction.STOP, 5));

        lifeMonsters.add(new Life(3));
        colorMonsters.add(new TextColor.RGB(200, 200, 200));
        sizeMonsters.add(new Size(5,5));
        bulletsMonsters.add(new Bullet(initialPosition, bulletSizeSmall, colorMonsters.get(3), new Life(3), true, Bullet.Direction.STOP, 5));

        lifeMonsters.add(new Life(10));
        colorMonsters.add(new TextColor.RGB(20, 150, 20));
        sizeMonsters.add(new Size(6,4));
        bulletsMonsters.add(new Bullet(initialPosition, bulletSizeBig, colorMonsters.get(4), new Life(2), true, Bullet.Direction.STOP, 10));

        lifeMonsters.add(new Life(15));
        colorMonsters.add(new TextColor.RGB(200, 150, 20));
        sizeMonsters.add(new Size(4,8));
        bulletsMonsters.add(new Bullet(initialPosition, bulletSizeSmall, colorMonsters.get(5), new Life(1), true, Bullet.Direction.STOP, 10));

        lifeMonsters.add(new Life(10));
        colorMonsters.add(new TextColor.RGB(200, 200, 50));
        sizeMonsters.add(new Size(5,5));
        bulletsMonsters.add(new Bullet(initialPosition, bulletSizeSmall, colorMonsters.get(6), new Life(1), true, Bullet.Direction.STOP, 15));

        lifeMonsters.add(new Life(5));
        colorMonsters.add(new TextColor.RGB(20, 150, 20));
        sizeMonsters.add(new Size(2,2));
        bulletsMonsters.add(new Bullet(initialPosition, bulletSizeMedium, colorMonsters.get(7), new Life(1), true, Bullet.Direction.STOP, 5));

        lifeMonsters.add(new Life(10));
        colorMonsters.add(new TextColor.RGB(250, 250, 250));
        sizeMonsters.add(new Size(5,5));
        bulletsMonsters.add(new Bullet(initialPosition, bulletSizeBig, colorMonsters.get(8), new Life(1), true, Bullet.Direction.STOP, 5));


        lifeMonsters.add(new Life(20));
        colorMonsters.add(new TextColor.RGB(0,0,0));
        sizeMonsters.add(new Size(4,4));
        bulletsMonsters.add(new Bullet(initialPosition, bulletSizeBig, colorMonsters.get(9), new Life(1), true, Bullet.Direction.STOP, 10));



        for (int i = 0; i < 10; i++) {
            kindEnemies.add(new Enemy(initialPosition, sizeMonsters.get(i), colorMonsters.get(i), lifeMonsters.get(i), bulletsMonsters.get(i)));

        }



        //poweruptype
        Position powerupPosition = new Position(20,20);
        Size powerupSize = new Size(1,1);
        Life powerupLife = new Life(1);
        typePowerUp = new PowerUp(powerupPosition, powerupSize, powerupColor, powerupLife);
    }

    public Enemy getEnemy(int level){
        int i = (int) random.nextGaussian()*5+level/2;
        if (i < 0) i = 0;
        else if (i > 9) i = 9;
        return kindEnemies.get(i);
    }

    public PowerUp getPowerUp(int level){
        return typePowerUp;
    }



}
