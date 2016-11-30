

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class ReinforceBlade extends Spell
{
    Warrior dread;
    Timer timer;
    public ReinforceBlade(Warrior dread)
    {
        this.dread = dread;
        x = dread.x;
        y = dread.y;
        timer = new Timer(1000, new timerAction());
        timer.start();
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.fillRect((int)x-15, (int)y, 7, 30);
        g.fillRect((int)x-22, (int)y+20, 20, 5);
    }
    public class timerAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
          timer.stop();
          dread.spell1 = false;
          dread.spells.remove(0);
        }
    }
}
