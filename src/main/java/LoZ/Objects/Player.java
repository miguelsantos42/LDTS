package LoZ.Objects;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;

import com.googlecode.lanterna.TextColor;

public class Player extends GameObject{

    public Player(Position position, Size size, TextColor textColor, Life life) {
        super(position, size, textColor, life, 1000);
    }

}
