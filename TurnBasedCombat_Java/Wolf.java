

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Wolf extends Enemy
{
    int size;
    public Wolf(ArrayList<Human> toons, int size)
    {
        name = "Wolf";
        this.toons = toons;
        h = 20;
        w = 20;
        hpx = 250;
        hph = 20;
        hp = 300;
        hpmax = 300;
        attack = 50;
        magic = 1;
        speed = 5;
        maxspeed = 5;
        wisdom = 1;
        x = 250;
       if(size == 0)
       {
           y = 300;
           dy = 300;
           hpy = 570;
       }
       if(size == 1)
       {
           y = 400;
           dy = 400;
           hpy = 600;
       }
       if(size == 2)
       {
           y = 500;
           dy = 500;
           hpy = 630;
       }
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillOval((int)x, (int)y, 20, 20);
    }
    public void move()
    {

    }
    public void takeTurn()
    {
        target = findTarget(toons);
        speed = 0;
        phase=PHASE_APPROACHING;
        damage = true;
    }
    public void castSpell1()
    {

    }
    public void castSpell2()
    {

    }
    public void castSpell3()
    {

    }
}
