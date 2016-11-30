

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;


public class FrostBeam extends Spell
{
    Mage magi;
    public FrostBeam(Mage magi)
    {
        this.magi = magi;
        x = magi.dx - 100;
        y = magi.dy - 20;
        w = 10;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillOval((int)x, (int)y, 100, 100);
    }
}
