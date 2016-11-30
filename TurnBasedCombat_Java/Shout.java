

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class Shout extends Spell
{
    Warrior dread;
    Timer timer;
    public Shout(Warrior dread)
    {
        this.dread = dread;
        x = dread.dx;
        y = dread.dy;
        timer = new Timer(1000, new TimerAction());
        timer.start();
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawLine((int)x, (int)y+15, (int)x-30,(int)y+30);
        g.drawLine((int)x, (int)y+15, (int)x-30,(int)y-20);
    }
    public class TimerAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            timer.stop();
            dread.spell1 = false;
            dread.spells.remove(0);
        }
    }
}
