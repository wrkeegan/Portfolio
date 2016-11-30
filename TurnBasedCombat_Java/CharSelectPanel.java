

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class CharSelectPanel extends JPanel
{
    JButton priest;
    JButton rogue;
    JButton warrior;
    JButton druid;
    JButton mage;
    JButton ranger;
    JButton back;
    Window win;
    Font f;
    public CharSelectPanel(Window win)
    {
        setPreferredSize(new Dimension(1280, 1024));
        setOpaque(true);
        setLayout(new GridLayout(3,3,200,200));
        setBackground(Color.darkGray);
        this.win = win;
        priest = new JButton("Preist");
        rogue = new JButton("Rogue");
        warrior = new JButton("Warrior");
        druid = new JButton("Druid");
        mage = new JButton("Mage");
        ranger = new JButton("Ranger");
        back = new JButton("Back");
        priest.addActionListener(new priest());
        rogue.addActionListener(new rogue());
        warrior.addActionListener(new warrior());
        druid.addActionListener(new druid());
        mage.addActionListener(new mage());
        ranger.addActionListener(new ranger());
        back.addActionListener(new back());
        f = new Font("Courier", Font.BOLD, 80);
        setLayout(null);
        Insets insets = getInsets();
        priest.setPreferredSize(new Dimension(300, 50));
        rogue.setPreferredSize(new Dimension(300, 50));
        warrior.setPreferredSize(new Dimension(300, 50));
        druid.setPreferredSize(new Dimension(300, 50));
        mage.setPreferredSize(new Dimension(300, 50));
        ranger.setPreferredSize(new Dimension(300,50));
        back.setPreferredSize(new Dimension(300,50));
        Dimension size = priest.getPreferredSize();
        Dimension size2 = rogue.getPreferredSize();
        Dimension size3 = warrior.getPreferredSize();
        Dimension size4 = druid.getPreferredSize();
        Dimension size5 = mage.getPreferredSize();
        Dimension size6 = ranger.getPreferredSize();
        Dimension size7 = back.getPreferredSize();
        priest.setBounds(100 + insets.left, 200 + insets.top,size.width, size.height);
        rogue.setBounds(450 + insets.left, 200 + insets.top,size2.width, size2.height);
        warrior.setBounds(800 + insets.left, 200 + insets.top,size3.width, size3.height);
        druid.setBounds(100 + insets.left, 550 + insets.top,size4.width, size4.height);
        mage.setBounds(450 + insets.left, 550 + insets.top,size5.width, size5.height);
        ranger.setBounds(800 + insets.left, 550 + insets.top,size6.width, size6.height);
        back.setBounds(450 + insets.left, 900 + insets.top,size7.width, size7.height);
        add(priest);
        add(rogue);
        add(warrior);
        add(druid);
        add(mage);
        add(ranger);
        add(back);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillOval(235, 150, 30, 30);
        g.setColor(Color.YELLOW);
        g.fillOval(580, 150, 30, 30);
        g.setColor(Color.BLACK);
        g.fillOval(925, 150, 30, 30);
        g.setColor(Color.ORANGE);
        g.fillOval(235, 500, 30, 30);
        g.setColor(Color.BLUE);
        g.fillOval(580, 500, 30, 30);
        g.setColor(Color.GREEN);
        g.fillOval(925, 500, 30, 30);
        g.setColor(Color.RED);
        g.setFont(f);
        g.drawString("CHOOSE YOUR PARTY", 100, 800);
    }
    public class priest implements ActionListener
    {     public void actionPerformed(ActionEvent e)
        {
            win.priestpanel();
        }
    }
    public class rogue implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           win.roguepanel();
        }
    }
    public class warrior implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           win.warriorpanel();
        }
    }
    public class druid implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.druidpanel();
        }
    }
    public class mage implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.magepanel();
        }
    }
    public class ranger implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.rangerpanel();
        }
    }
    public class back implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.backtoMain2();
        }
    }
}
