

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class Slow extends Spell
{
    Mage magi;
    int w;
    int h;
    Timer timer;
    public Slow(Mage magi)
    {
        this.magi = magi;
        x = magi.bp.target.x;
        y = magi.bp.target.y;
        timer = new Timer(1000, new timerAction());
        timer.start();
        w = 75;
        h = 75;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillOval((int)x-10, (int)y-20, w, h);
        g.setColor(Color.RED);
        g.drawLine((int)x, (int)y-10, (int)x+55, (int)y+45);
        g.drawLine((int)x+53, (int)y-10, (int)x, (int)y+43);
        g.drawLine((int)x-10, (int)y+17, (int)x+65, (int)y+17);
    }
    public class timerAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
          timer.stop();
          magi.spell1 = false;
          magi.spells.remove(0);
        }
    }
}
