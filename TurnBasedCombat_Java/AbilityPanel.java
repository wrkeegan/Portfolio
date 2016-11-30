

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class AbilityPanel extends JPanel
{
    Font f;
    JButton backtotp;
    Window win;
    public AbilityPanel(Window win)
    {
        setPreferredSize(new Dimension(1280, 1024));
        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);
        f = new Font("Courier", Font.BOLD, 18);
        this.win = win;
        backtotp = new JButton("Back");
        backtotp.addActionListener(new back());
        Insets insets = getInsets();
        backtotp.setPreferredSize(new Dimension(300, 50));
        Dimension size = backtotp.getPreferredSize();
        setLayout(null);
        backtotp.setBounds(470 + insets.left, 411 + insets.top,size.width, size.height);
        add(backtotp);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        Font temp = g.getFont();
        g.setColor(Color.BLACK);
        g.setFont(f);
        g.drawString("Druid Abilities", 0, 30);
        g.setFont(temp);
        g.drawString("Revitalize: Heals target for 150", 0, 48);
        g.drawString("Insect Swarm: The enemy is ssurronded by insects causing 200 damage and reducing the targets damage", 0, 66);
        g.drawString("Wrath of Nature: Druid's strongest ability, unlock to discover its secrets", 0, 84);
        g.setFont(f);
        g.drawString("Mage Abilities", 0, 102);
        g.setFont(temp);
        g.drawString("Fireball: Massive ball of fire that hits the enemy for 300 damage", 0, 120);
        g.drawString("Slow: Resets enemy turn bar", 0, 138);
        g.drawString("Frozen Death: Mage's strongest ability, unlock to discover its secrets",0, 156);
        g.setFont(f);
        g.drawString("Priest Abilities", 0, 174);
        g.setFont(temp);
        g.drawString("Healing Light: Heals target for 150", 0 , 192);
        g.drawString("Blessing of the Kings: Increases target's stats", 0, 210);
        g.drawString("Healing Rays: Preist's strongest ability, unlock to discover it's secrets", 0, 228);
        g.setFont(f);
        g.drawString("Ranger Abilities", 640, 30);
        g.setFont(temp);
        g.drawString("Bow Strike: Attack with a bow for 250", 640, 48);
        g.drawString("Spell Shot: Enechanted arrow that hits for 100, and inflicts a mortal wound", 640, 66);
        g.drawString("Hail of Arrows: Ranger's strongest ability, unlock to discover its secrets", 640, 84);
        g.setFont(f);
        g.drawString("Cheap Class's Abilities", 640, 102);
        g.setFont(temp);
        g.drawString("Fail Strike: Hits for 2 lawl", 640, 120);
        g.drawString("Splash Attack: lol magikarp lol", 640, 138);
        g.drawString("So Bad: If your still using a rogue at this point just quit", 640, 156);
        g.setFont(f);
        g.drawString("Warrior Abilities", 640, 174);
        g.setFont(temp);
        g.drawString("Powerful Strike: A power swing that knocks the enemy back inflicting 200 damage", 640, 192);
        g.drawString("Reinfocre Blade: Strengthens the warriors sword increasing attack", 640, 210);
        g.drawString("Shout: A warrior's strongest ability, unlock to discover its secrets", 640, 228);
    }
    public class back implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.backtotp();
        }
    }
}
