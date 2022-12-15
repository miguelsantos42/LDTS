package LoZ.Objects.Attributes;

public class Life {
    private boolean isAlive;
    private final int hearth;
    private int current;


    public Life(int hearth){
        this.hearth = hearth;
        this.current = hearth;
        updateStatus();
    }

    public Life(Life otherLife){
        this.hearth = otherLife.hearth;
        this.current = otherLife.current;
        updateStatus();
    }

    public void kill(){
        if(this.current > 0){
            this.current = this.current - 1;
            updateStatus();
        }
    }

    public void instantKill(){
        this.current = 0;
        updateStatus();
    }

    public void heal(){
        if(this.current < this.hearth){
            this.current = this.current + 1;
            updateStatus();
        }
    }

    public void allHeal(){
        this.current = this.hearth;
    }

    private void updateStatus(){
        if(current >= 1)
            isAlive = true;
        else if (current == 0)
            isAlive = false;
    }


    public int getMaximumLives(){
        return hearth;
    }

    public int getCurrentLives(){
        return current;
    }

    public boolean isAlive(){
        return isAlive;
    }
    
}