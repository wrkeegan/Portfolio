

package finalfantasyfinalproject;

import java.awt.Graphics;


public abstract class Spell
{
    double x;
    double y;
    double w;
     public double distanceTo(Human o)
    {
        return Math.sqrt((o.x-x)*(o.x-x)+(o.y-y)*(o.y-y));
    }
    public double distanceTo(double x, double y)
    {
        return Math.sqrt((x-this.x)*(x-this.x)+(y-this.y)*(y-this.y));
    }
    public void moveTo(double x, double y, double speed)
    {
        double angle = Math.atan2(y-this.y, x-this.x);
        move(angle, speed);
    }
    public void moveTo(Human o, double speed)
    {
        moveTo(o.x, o.y, speed);
    }
    public void move(double angle, double speed)
    {
        this.x += speed * Math.cos(angle);
        this.y += speed * Math.sin(angle);
    }
    public abstract void draw(Graphics g);
}
