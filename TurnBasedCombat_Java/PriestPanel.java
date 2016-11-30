

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


public class PriestPanel extends JPanel
{
    JButton addPriest;
    JButton back;
    Window win;
    Priest preach;
    boolean pos1;
    boolean pos2;
    boolean pos3;
    ArrayList<Human> toons;
    ArrayList<ArrayList<Human>> waves;
    Font f;
    public PriestPanel(Window win, ArrayList<Human> toons, ArrayList<ArrayList<Human>> waves)
    {
        setPreferredSize(new Dimension(1280, 1024));
        setOpaque(true);
        setBackground(new Color(128,0,0));
        addPriest = new JButton("Add a Priest to your Party");
        back = new JButton("Back to Character Select");
        Insets insets = getInsets();
        f = new Font("Courier", Font.BOLD, 18);
        addPriest.setPreferredSize(new Dimension(300, 50));
        back.setPreferredSize(new Dimension(300, 50));
        Dimension size = addPriest.getPreferredSize();
        Dimension size2 = back.getPreferredSize();
        setLayout(null);
        addPriest.setBounds(470 + insets.left, 450 + insets.top,size.width, size.height);
        back.setBounds(470 + insets.left, 501 + insets.top,size2.width, size2.height);
        this.toons = toons;
        this.win = win;
        this.waves = waves;
        addPriest.addActionListener(new addPriest());
        back.addActionListener(new back());
        add(addPriest);
        add(back);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillOval(300, 50, 30, 30);
        g.drawLine(320, 60, 407, 107);
        g.fillOval(400, 100, 50, 50);
        g.setColor(Color.YELLOW);
        g.fillOval(410, 110, 30, 30);
        g.setColor(Color.GREEN);
        g.drawString("+50", 410, 90);
        g.setColor(Color.WHITE);
        g.setFont(f);
        g.drawString("A Priest calls upon the spirits to heal their allies", 400, 370);
        g.drawString("Primary Role: Healer", 400, 400);
    }
    public class addPriest implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            doAddPriest();
        }
    }
    public void doAddPriest()
    {
        preach = new Priest(toons, this, waves, toons.size(), win);
        win.AddPlayer(preach);
        win.PriesttoChar();
    }
    public class back implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.PriesttoChar();
        }
    }
}
