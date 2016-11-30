

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class Revitalize extends Spell
{
    Druid drood;
    int w;
    int h;
    Timer timer;
    public Revitalize(Druid drood)
    {
        this.drood = drood;
        x = drood.bp.target.x;
        y = drood.bp.target.y;
        timer = new Timer(1000, new timerAction());
        timer.start();
        w = 75;
        h = 75;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fillOval((int)x-10, (int)y-20, w, h);
    }
    public class timerAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
          w = 40;
          h = 40;
          timer.stop();
          drood.spell1 = false;
          drood.spells.remove(0);
        }
    }
}
