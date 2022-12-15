package LoZ.Objects;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TextColor;

public class PowerUp extends GameObject{

    public PowerUp(Position position, Size size, TextColor textColor, Life life) {
        super(position, size, textColor, life, 1);
    }

    public PowerUp(PowerUp powerup){
        super(new Position(powerup.position.getxPos(), powerup.position.getyPos()),
                new Size(powerup.size.getWidth(), powerup.size.getHeight()),
                new TextColor.RGB(powerup.color.toColor().getRed(),
                        powerup.color.toColor().getGreen(),
                        powerup.color.toColor().getBlue()),
                new Life(powerup.life.getMaximumLives()), 1);
    }

    public void copy(PowerUp powerup){
        this.position = new Position(powerup.position.getxPos(), powerup.position.getyPos());
        this.size = new Size(powerup.size.getWidth(), powerup.size.getHeight());
        super.color = new TextColor.RGB(powerup.color.toColor().getRed(),
                powerup.color.toColor().getGreen(),
                powerup.color.toColor().getBlue());
        this.life = new Life(powerup.life.getMaximumLives());

    }


}
