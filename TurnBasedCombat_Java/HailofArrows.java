

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;

public class HailofArrows extends Spell
{
    Ranger arc;
    public HailofArrows(Ranger arc)
    {
        this.arc = arc;
        x = arc.dx;
        y = arc.dy;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawLine((int)x, (int)y, (int)x+15, (int)y);
        g.drawLine((int)x, (int)y, (int)x+7, (int)y+7);
        g.drawLine((int)x, (int)y, (int)x+7, (int)y-7);
    }
}
