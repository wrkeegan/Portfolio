

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;


public class IntroPanel extends JPanel
{
    Font f;
    public IntroPanel()
    {
        setPreferredSize(new Dimension(1280, 1024));
        setOpaque(true);
        setBackground(Color.BLACK);
        f = new Font("Courier", Font.BOLD, 18);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
    try
    {
        Image img = Toolkit.getDefaultToolkit().getImage("E:\\intents.jpg");
        g.drawImage(img, 570, 200, this);
    }
    catch(Exception ex)
    {
       System.out.println("File not Found");
    }  
        g.setColor(Color.YELLOW);
        setFont(f);
        g.drawString("Intents Productions Presents:", 510, 180);
    }
}
