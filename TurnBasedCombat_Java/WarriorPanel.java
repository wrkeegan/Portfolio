

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;


public class WarriorPanel extends JPanel
{
    JButton addWarrior;
    JButton back;
    Window win;
    Warrior dread;
    boolean pos1;
    boolean pos2;
    boolean pos3;
    Font f;
    ArrayList<Human> toons;
    ArrayList<ArrayList<Human>> waves;
    public WarriorPanel(Window win, ArrayList<Human> toons, ArrayList<ArrayList<Human>> waves)
    {
        setPreferredSize(new Dimension(1280, 1024));
        setOpaque(true);
        setBackground(new Color(178, 34, 34));
        this.toons = toons;
        this.win = win;
        this.waves = waves;
        addWarrior = new JButton("Add a Warrior to your Party");
        back = new JButton("Back to Character Select");
        f = new Font("Courier", Font.BOLD, 18);
        Insets insets = getInsets();
        addWarrior.setPreferredSize(new Dimension(300, 50));
        back.setPreferredSize(new Dimension(300, 50));
        Dimension size = addWarrior.getPreferredSize();
        Dimension size2 = back.getPreferredSize();
        setLayout(null);
        addWarrior.setBounds(470 + insets.left, 450 + insets.top,size.width, size.height);
        back.setBounds(470 + insets.left, 501 + insets.top,size2.width, size2.height);
        addWarrior.addActionListener(new addWarrior());
        back.addActionListener(new back());
        add(addWarrior);
        add(back);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(new Color(255, 215, 0));
        g.fillRect(145, 0, 50, 375);
        g.fillRect(20, 250, 295, 50);
        g.setColor(Color.BLACK);
        g.fillOval(150, 200, 30, 30);
        g.setColor(Color.red);
        g.fillOval(700, 200, 30, 30);
        g.setColor(Color.BLACK);
        setFont(f);
        g.drawString("The Warrior uses large weapons to smash peoples faces in", 400, 370);
        g.drawString("Primary Role: Heavy Damage", 400, 400);
        g.setColor(new Color(85,107,47));
        g.drawString("+3 atk", 145, 190);
    }
    public class addWarrior implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            doAddWarrior();
        }
    }
    public void doAddWarrior()
    {
        dread = new Warrior(toons, this, waves, toons.size(), win);
        win.AddPlayer(new Warrior(toons, this, waves, toons.size(), win));
        win.WarriortoChar();
    }
    public class back implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.WarriortoChar();
        }
    }
}
