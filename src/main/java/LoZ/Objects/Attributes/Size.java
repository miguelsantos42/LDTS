package LoZ.Objects.Attributes;

public class Size {

    int height;
    int width;


    public Size(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public Size(Size otherSize) {
        this.height = otherSize.height;
        this.width = otherSize.width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
