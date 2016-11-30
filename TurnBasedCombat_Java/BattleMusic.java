

package finalfantasyfinalproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import javax.swing.Timer;
//import javazoom.jl.player.Player;

public class BattleMusic
{
    Timer timer;
    public BattleMusic()
    {
        timer = new Timer(5000, new TimerAction());
        PlayMusic();
        timer.start();
    }
    public void PlayMusic()
    {
       try
       {
         FileInputStream f = new FileInputStream("F:\\Final Fantasy VII - Disc 1 - 10 - Fighting.mp3");
       //  Player player = new Player(f);
       //  player.play();
       }
       catch(Exception ex)
       {
            System.out.println("File not found");
       }
     }
    public class TimerAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            PlayMusic();
        }
    }
}
