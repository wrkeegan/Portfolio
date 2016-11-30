

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;


public class InsectSwarm extends Spell
{
    Druid drood;
    int count;
    public InsectSwarm(Druid drood)
    {
        this.drood = drood;
        x = drood.dx;
        y = drood.dy;
    }
    public void draw(Graphics g)
    {
      g.setColor(Color.GREEN);
      g.fillOval((int)x, (int)y, 10, 10);
    }
}
