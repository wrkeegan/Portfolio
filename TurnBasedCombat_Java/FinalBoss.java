

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class FinalBoss extends Enemy
{
    public FinalBoss(ArrayList<Human> toons)
    {
        name = "OMG LAST BOSS";
        this.toons = toons;
        h = 30;
        w = 30;
        hpx = 250;
        hph = 20;
        hp = 8000;
        hpmax = 8000;
        attack = 500;
        magic = 1;
        speed = 5;
        maxspeed = 5;
        wisdom = 1;
        x = 250;
        y = 400;
        dy = 400;
        hpy = 600;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillOval((int)x, (int)y, 90, 90);
    }
    public void move()
    {

    }
    public void takeTurn()
    {
        target = findTarget(toons);
        speed = 0;
       // hp = hpmax;
        barlength = (hp / hpmax) * maxbarlength;
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
