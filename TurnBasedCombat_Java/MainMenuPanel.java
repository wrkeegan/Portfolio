

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
import javax.swing.Timer;


public class MainMenuPanel extends JPanel
{
    JButton newGame;
    JButton tutorial;
    Window win;
    Timer timer;
    Font f;
    int y;
    int w;
    int h;
    public MainMenuPanel(Window win)
    {
        setPreferredSize(new Dimension(1280, 1024));
        setOpaque(true);
        setBackground(Color.darkGray);
        timer = new Timer(50, new timerAction());
        timer.start();
        f = new Font("Courier", Font.BOLD, 18);
        this.win = win;
        newGame = new JButton("New Game");
        tutorial = new JButton("Tutorial");
        newGame.addActionListener(new newGame());
        tutorial.addActionListener(new tutorial());
        y = 300;
        w = 5;
        h = 10;
        setLayout(null);
        Insets insets = getInsets();
        newGame.setPreferredSize(new Dimension(300, 50));
        tutorial.setPreferredSize(new Dimension(300, 50));
        Dimension size = newGame.getPreferredSize();
        Dimension size2 = tutorial.getPreferredSize();
        newGame.setBounds(470 + insets.left, 350 + insets.top,size.width, size.height);
        tutorial.setBounds(470 + insets.left, 401 + insets.top,size2.width, size2.height);
        add(newGame);
        add(tutorial);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillOval(470, 470, 30, 30);
        g.setColor(Color.BLACK);
        g.fillOval(600, 470, 30, 30);
        g.setColor(Color.YELLOW);
        g.fillOval(730, 470, 30, 30);
        g.setColor(Color.ORANGE);
        g.fillOval(470, 540, 30, 30);
        g.setColor(Color.BLUE);
        g.fillOval(600, 540, 30, 30);
        g.setColor(Color.GREEN);
        g.fillOval(730, 540, 30, 30);
        g.setColor(Color.red);
        if((y+12)%48+300 >= 347)
            g.fillOval(488, (y+12)%48+300, 15, 3);
        else
            g.fillOval(488, (y+12)%48+300, w, h);
        if((y+20)%48+300 >= 347)
            g.fillOval(508, (y+20)%48+300, 15, 3);
        else
            g.fillOval(508, (y+20)%48+300, w, h);
        if((y+5)%48+300 >= 347)
            g.fillOval(568, (y+5)%48+300, 15, 3);
        else
            g.fillOval(568, (y+5)%48+300, w, h);
        if((y+15)%48+300 >= 347)
            g.fillOval(608, (y+15)%48+300, 15, 3);
        else
            g.fillOval(608, (y+15)%48+300, w, h);
        if((y+7)%48+300 >= 347)
            g.fillOval(668, (y+7)%48+300, 15, 3);
        else
            g.fillOval(668, (y+7)%48+300, w, h);
        if((y+2)%48+300 >= 347)
            g.fillOval(728, (y+2)%48+300, 15, 3);
        else
            g.fillOval(728, (y+2)%48+300, w, h);
        y+=4;
        g.setFont(f);
        g.drawString("FINAL FANTASY GAUNTLET", 490, 300);
        g.setColor(Color.WHITE);
        g.drawString("Priest", 460, 520);
        g.setColor(Color.BLACK);
        g.drawString("Warrior", 590, 520);
        g.setColor(Color.YELLOW);
        g.drawString("Cheap Class", 700, 520);
        g.setColor(Color.ORANGE);
        g.drawString("Druid", 460, 590);
        g.setColor(Color.BLUE);
        g.drawString("Mage", 590, 590);
        g.setColor(Color.GREEN);
        g.drawString("Ranger", 720, 590);
    }
    public class newGame implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
           win.addCharSelect();
        }
    }
    public class tutorial implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
           win.addTutorialPanel();
        }        
    }
    public class timerAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            repaint();
        }
    }
}
