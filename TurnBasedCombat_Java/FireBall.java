

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class FireBall extends Spell
{
    Mage magi;
    ArrayList<ArrayList<Human>> waves;
    public FireBall(Mage magi, ArrayList<ArrayList<Human>> waves)
    {
        this.magi = magi;
        x = magi.dx - 100;
        y = magi.dy - 20;
    }
    public void draw(Graphics g)
    {
      g.setColor(new Color(255,69,0));
      g.fillOval((int)x, (int)y, 70, 70);
      g.fillOval((int)x+20, (int)y+30, 150, 20);
    }
}
