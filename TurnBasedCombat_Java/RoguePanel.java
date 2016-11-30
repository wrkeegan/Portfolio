

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


public class RoguePanel extends JPanel
{
    JButton addRogue;
    JButton back;
    Window win;
    Rogue sneak;
    boolean pos1;
    boolean pos2;
    boolean pos3;
    Font f;
    ArrayList<Human> toons;
    ArrayList<ArrayList<Human>> waves;
    public RoguePanel(Window win, ArrayList<Human> toons, ArrayList<ArrayList<Human>> waves)
    {
        setPreferredSize(new Dimension(1280, 1024));
        setOpaque(true);
        setBackground(Color.BLACK);
        this.toons = toons;
        this.win = win;
        this.waves = waves;
        addRogue = new JButton("Add a Rogue to your Party");
        back = new JButton("Back to Character Select");
        f = new Font("Courier", Font.BOLD, 18);
        Insets insets = getInsets();
        addRogue.setPreferredSize(new Dimension(300, 50));
        back.setPreferredSize(new Dimension(300, 50));
        Dimension size = addRogue.getPreferredSize();
        Dimension size2 = back.getPreferredSize();
        setLayout(null);
        addRogue.setBounds(470 + insets.left, 450 + insets.top,size.width, size.height);
        back.setBounds(470 + insets.left, 501 + insets.top,size2.width, size2.height);
        addRogue.addActionListener(new addRogue());
        back.addActionListener(new back());
        add(addRogue);
        add(back);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.YELLOW);
        g.fillOval(700, 200, 30, 30);
        g.setColor(new Color(255, 215, 0));
        g.drawLine(700, 190, 660, 210);
        g.drawLine(705, 240, 660, 230);
        g.drawLine(687, 187, 697, 200);
        g.drawLine(697, 230, 690, 243);
        g.setColor(Color.red);
        g.fillOval(650, 200, 40, 40);
        g.drawString("-5", 660, 195);
        g.drawString("-5", 660, 180);
        g.setColor(Color.YELLOW);
        g.setFont(f);
        g.drawString("A Rogue is an incredibly cheap class and is only in this game because I wanted six classes", 400, 370);
        g.drawString("Primary Role: Fast Damage", 400, 400);
    }
    public class addRogue implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            doAddRogue();
        }
    }
    public void doAddRogue()
    {
        sneak = new Rogue(toons, this, waves, toons.size(), win);
        win.AddPlayer(sneak);
        win.RoguetoChar();
    }
    public class back implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.RoguetoChar();
        }
    }
}
