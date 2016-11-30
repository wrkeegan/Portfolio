
package finalfantasyfinalproject;

import java.awt.Graphics;


public class Cursor
{
    double x;
    double y;
    double w;
    double h;
    public Cursor(double x, double y)
    {
        x = this.x;
        y = this.y;
        w = 10;
        h = 10;
    }
    public void draw(Graphics g)
    {
        g.fillOval((int)x, (int)y, (int)w, (int)h);
    }
    public void move()
    {

    }
    public double angleTo(Cursor o)
    {
        return Math.atan2(o.y-y,o.x-x);
    }
    public double distanceTo(Cursor o)
    {
        return Math.sqrt((o.x-x)*(o.x-x)+(o.y-y)*(o.y-y));
    }
    public void moveTo(double x, double y, double speed)
    {
        double angle = Math.atan2(y-this.y, x-this.x);
        move(angle, speed);
       // this.x += speed * Math.cos(angle);
       // this.y += speed * Math.sin(angle);
    }
    public void moveTo(Cursor o, double speed)
    {
        moveTo(o.x, o.y, speed);
    }
    public void move(double angle, double speed)
    {
        this.x += speed * Math.cos(angle);
        this.y += speed * Math.sin(angle);
    }
}
