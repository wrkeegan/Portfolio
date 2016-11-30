

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Squareman extends Enemy
{
    public Squareman(ArrayList<Human> toons)
    {
        name = "Square Man";
        this.toons = toons;
        h = 20;
        w = 20;
        hpx = 250;
        hph = 20;
        hp = 5000;
        hpmax = 5000;
        attack = 200;
        magic = 1;
        speed = 2;
        maxspeed = 2;
        wisdom = 1;
        x = 250;
        y = 400;
        dy = 400;
        hpy = 600;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect((int)x, (int)y, 30, 30);
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
