

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


public class RangerPanel extends JPanel
{
    JButton addRanger;
    JButton back;
    Window win;
    Ranger arc;
    boolean pos1;
    boolean pos2;
    boolean pos3;
    Font f;
    ArrayList<Human> toons;
    ArrayList<ArrayList<Human>> waves;
    public RangerPanel(Window win, ArrayList<Human> toons, ArrayList<ArrayList<Human>> waves)
    {
        setPreferredSize(new Dimension(1280, 1024));
        setOpaque(true);
        setBackground(new Color(128,64,0));
        this.toons = toons;
        this.win = win;
        this.waves = waves;
        f = new Font("Courier", Font.BOLD, 18);
        addRanger = new JButton("Add a Ranger to your Party");
        back = new JButton("Back to Character Select");
        Insets insets = getInsets();
        addRanger.setPreferredSize(new Dimension(300, 50));
        back.setPreferredSize(new Dimension(300, 50));
        Dimension size = addRanger.getPreferredSize();
        Dimension size2 = back.getPreferredSize();
        setLayout(null);
        addRanger.setBounds(470 + insets.left, 450 + insets.top,size.width, size.height);
        back.setBounds(470 + insets.left, 501 + insets.top,size2.width, size2.height);
        addRanger.addActionListener(new addRanger());
        back.addActionListener(new back());
        add(addRanger);
        add(back);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.GREEN);
        g.fillOval(300, 300, 30, 30);
        g.setColor(Color.BLACK);
        g.drawLine(330, 290, 340, 275);
        g.drawLine(340, 275, 330, 280);
        g.drawLine(340, 275, 342, 287);
        g.setColor(Color.red);
        g.fillOval(400, 100, 30, 30);
        g.setColor(Color.GREEN);
        g.setFont(f);
        g.drawString("A Ranger uses a bow to attack his enemies from afar", 400, 370);
        g.drawString("Primary Role: Ranged Damage", 400, 400);
    }
    public class addRanger implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            doAddRanger();
        }
    }
    public void doAddRanger()
    {
        arc = new Ranger(toons, this, waves, toons.size(), win);
        win.AddPlayer(arc);
        win.RangertoChar();
    }
    public class back implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.RangertoChar();
        }
    }
}
