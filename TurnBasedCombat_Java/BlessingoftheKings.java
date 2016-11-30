

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class BlessingoftheKings extends Spell
{
    Priest preach;
    Timer timer;
    public BlessingoftheKings(Priest preach)
    {
        this.preach = preach;
        x = preach.bp.target.x;
        y = preach.bp.target.y;
        timer = new Timer(1000, new timerAction());
        timer.start();
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.drawLine((int)x-10, (int)y, (int)x-10, (int)y-10);
        g.drawLine((int)x-10, (int)y, (int)x+10, (int)y);
        g.drawLine((int)x+10, (int)y, (int)x+10, (int)y-10);
        g.drawLine((int)x-10, (int)y-10, (int)x-8, (int)y-5);
        g.drawLine((int)x-8, (int)y-5, (int)x-6, (int)y-10);
        g.drawLine((int)x-6, (int)y-10, (int)x-4, (int)y-5);
        g.drawLine((int)x-4, (int)y-5, (int)x-2, (int)y-10);
        g.drawLine((int)x-2, (int)y-10, (int)x, (int)y-5);
        g.drawLine((int)x, (int)y-5, (int)x+2, (int)y-10);
        g.drawLine((int)x+2, (int)y-10, (int)x+4, (int)y-5);
        g.drawLine((int)x+4, (int)y-5, (int)x+6, (int)y-10);
        g.drawLine((int)x+6, (int)y-10, (int)x+8, (int)y-5);
        g.drawLine((int)x+8, (int)y-5, (int)x+10, (int)y-10);
    }
    public class timerAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
          timer.stop();
          preach.spell1 = false;
          preach.spells.remove(0);
        }
    }
}
