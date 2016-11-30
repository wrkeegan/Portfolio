

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class SoBad extends Spell
{
    Rogue sneak;
    Timer timer;
    public SoBad(Rogue sneak)
    {
        this.sneak = sneak;
        timer = new Timer(2000, new TimerAction());
        timer.start();
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawString("You're seriously still using this fail class?", 500, 500);
    }
    public class TimerAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            timer.stop();
            sneak.spell1 = false;
            sneak.spells.remove(0);
        }
    }
}
