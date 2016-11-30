

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


public class TutorialPanel extends JPanel
{
    JButton back;
    JButton ap;
    Window win;
    Font f;
    public TutorialPanel(Window win)
    {
        setPreferredSize(new Dimension(1280, 1024));
        setOpaque(true);
        setBackground(Color.darkGray);
        back = new JButton("Back");
        ap = new JButton("Ability List");
        f = new Font("Courier", Font.BOLD, 18);
        Insets insets = getInsets();
        back.setPreferredSize(new Dimension(300, 50));
        Dimension size = back.getPreferredSize();
        setLayout(null);
        back.setBounds(470 + insets.left, 411 + insets.top,size.width, size.height);
        ap.setBounds(470 + insets.left, 462 + insets.top,size.width, size.height);
        this.win = win;
        back.addActionListener(new back());
        ap.addActionListener(new ap());
        add(back);
        add(ap);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.BLACK);
        setFont(f);
        g.drawString("The object of the game is to defeat all of the enemies pitted against you,", 400, 370);
        g.drawString("there are no save or break points Good Luck.", 400, 400);
    }
    public class back implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.backToMain();
        }
    }
    public class ap implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.toAP();
        }
    }
}
