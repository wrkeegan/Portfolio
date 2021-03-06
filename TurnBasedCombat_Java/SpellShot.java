

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class SpellShot extends Spell
{
    Ranger arc;
    ArrayList<ArrayList<Human>> waves;
    public SpellShot(Ranger arc, ArrayList<ArrayList<Human>> waves)
    {
        this.arc = arc;
        x = arc.dx - 20;
        y = arc.dy - 10;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.magenta);
        g.fillOval((int)x, (int)y-8, 50, 10);
        g.setColor(Color.BLACK);
        g.drawLine((int)x, (int)y, (int)x+15, (int)y);
        g.drawLine((int)x, (int)y, (int)x+7, (int)y+7);
        g.drawLine((int)x, (int)y, (int)x+7, (int)y-7);
    }
}
