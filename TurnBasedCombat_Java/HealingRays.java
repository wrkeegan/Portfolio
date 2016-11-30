

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class HealingRays extends Spell
{
    Priest preach;
    Timer timer;
    public HealingRays(Priest preach)
    {
        this.preach = preach;
        x = preach.dx;
        y = preach.dy;
        timer = new Timer(1000, new timerAction());
        timer.start();
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.drawRect((int)x, 0, 10, 1268);
        g.drawRect((int)x-10, 0, 10, 1268);
        g.drawRect((int)x+10, 0, 10, 1268);
        g.drawRect((int)x+20, 0, 10, 1268);
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
