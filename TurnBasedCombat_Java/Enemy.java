

package finalfantasyfinalproject;

import java.awt.Graphics;
import java.util.ArrayList;


public abstract class Enemy extends Human
{
    int count;
    public Enemy()
    {
        dx = 250;
    }
    public abstract void draw(Graphics g);
    public abstract void move();
    public abstract void takeTurn();
    public void removeTarget(Human target, ArrayList<Human> toons, ArrayList<ArrayList<Human>> waves)
    {
        for(int i = 0; i < toons.size(); i++)
        {
            if(toons.get(i).hp <= 0)
                 count++;
                 
        } 
    }
}
