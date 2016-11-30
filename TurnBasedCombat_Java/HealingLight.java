

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class HealingLight extends Spell
{
    Priest preach;
    int w;
    int h;
    Timer timer;
    public HealingLight(Priest preach)
    {
        this.preach = preach;
        x = preach.bp.target.x;
        y = preach.bp.target.y;
        timer = new Timer(1000, new timerAction());
        timer.start();
        w = 75;
        h = 75;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillOval((int)x-10, (int)y-20, w, h);
    }
    public class timerAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
          w = 40;
          h = 40;
          timer.stop();
          preach.spell1 = false;
          preach.spells.remove(0);
        }
    }
}
