

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class WrathofNature extends Spell
{
    Druid drood;
    Timer timer;
    public WrathofNature(Druid drood)
    {
        this.drood = drood;
        timer = new Timer(2000, new TimerAction());
        timer.start();
    }
    public void draw(Graphics g)
    {
       g.setColor(Color.RED);
       g.fillOval(550, 300, 40, 50);
       g.fillOval(650, 300, 40, 50);
       g.setColor(Color.BLACK);
       g.fillRect(580, 400, 100, 20);
    }
    public class TimerAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           timer.stop();
           drood.spell1  = false;
           drood.spells.remove(0);
        }
    }
}
