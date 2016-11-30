
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


public class MagePanel extends JPanel
{
    JButton addMage;
    JButton back;
    Window win;
    Mage magi;
    boolean pos1;
    boolean pos2;
    boolean pos3;
    Font f;
    ArrayList<Human> toons;
    ArrayList<ArrayList<Human>> waves;
    public MagePanel(Window win, ArrayList<Human> toons, ArrayList<ArrayList<Human>> waves)
    {
        setPreferredSize(new Dimension(1280, 1024));
        setOpaque(true);
        setBackground(Color.CYAN);
        this.toons = toons;
        this.win = win;
        this.waves = waves;
        f = new Font("Courier", Font.BOLD, 18);
        addMage = new JButton("Add a Mage to your Party");
        back = new JButton("Back to Character Select");
        Insets insets = getInsets();
        addMage.setPreferredSize(new Dimension(300, 50));
        back.setPreferredSize(new Dimension(300, 50));
        Dimension size = addMage.getPreferredSize();
        Dimension size2 = back.getPreferredSize();
        setLayout(null);
        addMage.setBounds(470 + insets.left, 450 + insets.top,size.width, size.height);
        back.setBounds(470 + insets.left, 501 + insets.top,size2.width, size2.height);
        addMage.addActionListener(new addMage());
        back.addActionListener(new back());
        add(addMage);
        add(back);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillOval(300, 250, 30, 30);
        g.setColor(new Color(255,69,0));
        g.fillOval(500, 230, 70, 70);
        g.fillOval(400, 260, 150, 20);
        g.setColor(Color.red);
        g.fillOval(700, 250, 40, 40);
        g.setColor(Color.BLUE);
        setFont(f);
        g.drawString("A  Mage uses the power of fire and ice to obliterate their opponents", 400, 370);
        g.drawString("Primary Role: Spell Damage", 400, 400);
    }
    public class addMage implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            doAddMage();
        }
    }
    public void doAddMage()
    {
         magi = new Mage(toons, this, waves, toons.size(), win);
         win.AddPlayer(magi);
         win.MagetoChar();
    }
    public class back implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.MagetoChar();
        }
    }
}
