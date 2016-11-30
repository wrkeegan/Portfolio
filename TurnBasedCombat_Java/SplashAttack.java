

package finalfantasyfinalproject;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class SplashAttack extends Spell
{
    Timer timer;
    Rogue sneak;
    public SplashAttack(Rogue sneak)
    {
       this.sneak = sneak;
       timer = new Timer(1000, new TimerAction());
       timer.start();
    }
    public void draw(Graphics g) 
    {
        g.drawString("NOTHING HAPPENS!!!!!!!",500,500);
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
