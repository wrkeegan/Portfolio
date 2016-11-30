

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


public class DruidPanel extends JPanel
{
    JButton addDruid;
    JButton back;
    Window win;
    Druid drood;
    boolean pos1;
    boolean pos2;
    boolean pos3;
    Font f;
    ArrayList<Human> toons;
    ArrayList<ArrayList<Human>> waves;
    public DruidPanel(Window win, ArrayList<Human> toons, ArrayList<ArrayList<Human>> waves)
    {
        setPreferredSize(new Dimension(1280, 1024));
        setOpaque(true);
        setBackground(new Color(0,100,0));
        this.toons = toons;
        this.win = win;
        this.waves = waves;
        addDruid = new JButton("Add a Druid to your Party");
        back = new JButton("Back to Character Select");
        f = new Font("Courier", Font.BOLD, 18);
        Insets insets = getInsets();
        addDruid.setPreferredSize(new Dimension(300, 50));
        back.setPreferredSize(new Dimension(300, 50));
        Dimension size = addDruid.getPreferredSize();
        Dimension size2 = back.getPreferredSize();
        setLayout(null);
        addDruid.setBounds(470 + insets.left, 450 + insets.top,size.width, size.height);
        back.setBounds(470 + insets.left, 501 + insets.top,size2.width, size2.height);
        addDruid.addActionListener(new addDruid());
        back.addActionListener(new back());
        add(addDruid);
        add(back);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.ORANGE);
        g.fillOval(700, 290, 30, 30);
        g.setColor(Color.red);
        g.fillOval(750, 140, 30, 30);
        g.setColor(new Color(102, 205, 170));
        g.fillOval(770, 140, 5, 5);
        g.fillOval(750, 140, 5, 5);
        g.fillOval(760, 150, 5, 5);
        g.fillOval(750, 160, 5, 5);
        g.fillOval(760, 130, 5, 5);
        g.fillOval(770, 160, 5, 5);
        g.setColor(Color.red);
        g.drawString("-10", 755, 120);
        g.drawString("-10", 755, 110);
        setFont(f);
        g.setColor(Color.ORANGE);
        g.drawString("The Druid uses the forces of nature to heal their allies and damage their foes", 400, 370);
        g.drawString("Primary Role: Healer", 400, 400);
    }
    public class addDruid implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            doAddDruid();
        }
    }
        private void doAddDruid() 
        {         
            drood = new Druid(toons, this, waves, toons.size(), win);
            win.AddPlayer(drood);
            win.DruidtoChar();
        }
    public class back implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.DruidtoChar();
        }
    }
}

