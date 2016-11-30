

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;


public class BattlePanel extends JPanel
{
    Druid drood;
    Mage magi;
    Priest preach;
    Ranger arc;
    Rogue sneak;
    Warrior dread;
    Human next;
    Human target;
    Human target2;
    Timer moveTimer;
    boolean lol;
    FireBall fire;
    ArrayList<Human> toons;
    ArrayList<ArrayList<Human>> waves;
    Container pane;
    boolean isTarget;
    public BattlePanel(ArrayList<Human> toons, ArrayList<ArrayList<Human>> waves)
    {
       setPreferredSize(new Dimension(1280, 1024));
       setOpaque(true);
       setBackground(Color.LIGHT_GRAY);
       this.toons = toons;
       this.waves = waves;
       addMouseListener(new ClickAction());
       moveTimer = new Timer(10, new moveTimer());
       moveTimer.start();
       setLayout(null);       
    }
    public void paint(Graphics g)
    {
        super.paint(g);
      if(target != null)
      {
        if(target.hp <= 0)
            target = null;
      }
        if(target != null)
        {
            g.setColor(Color.BLACK);
            g.drawOval((int)target.x-5, (int)target.y-5, 5, 5);
        }
        for(int i = 0; i < toons.size(); i++)
        {
          if(toons.get(i).spell1 == true)
          {
              toons.get(i).spells.get(0).draw(g);
          }
        }
        if(lol == true)
            g.drawString("LOL", 500, 150);
        if(next.oom == true)
            g.drawString("You need more mana", 500, 100);
        for(int i = 0; i < toons.size(); i++)
        {
            if(toons.get(i).speedlength >= 100)
                g.setColor(Color.YELLOW);
            else
                g.setColor(new Color(128, 96, 0));
            if(toons.get(i).hp > 0)
            {
                g.fillRect(1125, (int)toons.get(i).hpy-10, (int)toons.get(i).speedlength, toons.get(i).hph/2);
                g.setColor(Color.BLUE);
                g.fillRect(905, (int)toons.get(i).hpy+7, (int)toons.get(i).manalength, (int)toons.get(i).mbw);
            }
        }
      for(int i = 0; i < toons.size(); i++)
           toons.get(i).draw(g);
      for(int i = 0; i < waves.get(0).size(); i++)
      {
         if(waves.get(0).get(i).hp > 0)
         {
            waves.get(0).get(i).draw(g);
            g.setColor(Color.BLACK);
            g.drawRect(waves.get(0).get(i).hpx-48, waves.get(0).get(i).hpy-16, (int)waves.get(0).get(i).maxbarlength+1, waves.get(0).get(i).hph+1);
           if(waves.get(0).get(i).hp < 50)
               g.setColor(Color.RED);
           else
                g.setColor(Color.GREEN);
            g.fillRect(waves.get(0).get(i).hpx-47, waves.get(0).get(i).hpy-15, (int)waves.get(0).get(i).barlength, waves.get(0).get(i).hph);
            g.setColor(Color.BLACK);
            g.drawString(waves.get(0).get(i).name+"'s Health is: "+waves.get(0).get(i).hp, waves.get(0).get(i).hpx-40, waves.get(0).get(i).hpy);
         }
       }
            g.setColor(Color.BLACK);
            if(target != null)
              g.drawString("Target: "+target.name, 100, 100);
            else
              g.drawString("Target:", 100, 100);
            for(int i = 0; i < toons.size(); i++)
            {
               g.setColor(Color.BLACK);
               if(toons.get(i).hp > 0)
                  g.drawRect(904, toons.get(i).hpy-16, (int)toons.get(i).maxbarlength+1, toons.get(i).hph+1);
               if(toons.get(i).hp < 50)
                  g.setColor(Color.RED);
               else
                  g.setColor(Color.GREEN);
               if(toons.get(i).hp > 0)
                  g.fillRect(905, toons.get(i).hpy-15, (int)toons.get(i).barlength, toons.get(i).hph);
            }
            g.setColor(Color.BLACK);
          if(toons.get(0).hp > 0)
            g.drawString(toons.get(0).name+"'s Health is: "+toons.get(0).hp, 910, 570);
          if(toons.get(1).hp > 0)
            g.drawString(toons.get(1).name+"'s Health is: "+toons.get(1).hp, 910, 600);
          if(toons.get(2).hp > 0)
            g.drawString(toons.get(2).name+"'s Health is: "+toons.get(2).hp, 910, 630);
            if(target == null)
                g.drawString("You must Select a Target", 500, 50);
            if(next.damage == true)
            {
              g.setColor(Color.RED);
              if(next.target != null)
               g.drawString("-"+next.attack, (int)next.target.x, (int)next.target.y-23);
            }
    }
    public class moveTimer implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
          if(next.hp > 0)
          {
            next.preformAttack(waves);
            next.castSpell1();
            next.castSpell2();
            next.castSpell3();
          }
            if(next.done == true || next.hp <= 0)
            {
                next.done = false;
                next.damage = false;
                next = findTurn(toons, waves.get(0));
                System.out.println(next.toString());
                if(next.hp > 0)
                    next.takeTurn();
            }
            repaint();
        }
    }
    public Human findTurn(ArrayList<Human> toons, ArrayList<Human> baddies)
    {
        for(int i = 0; i < 100; i++)
        {
          if(toons.get(0).hp > 0)
            toons.get(0).speed = toons.get(0).maxspeed + toons.get(0).speed;
          if(toons.get(1).hp > 0)
            toons.get(1).speed = toons.get(1).maxspeed + toons.get(1).speed;
          if(toons.get(2).hp > 0)
            toons.get(2).speed = toons.get(2).maxspeed + toons.get(2).speed;
          if(toons.get(0).hp > 0)
            toons.get(0).speedlength = toons.get(0).speed;
          if(toons.get(1).hp > 0)
            toons.get(1).speedlength = toons.get(1).speed;
          if(toons.get(2).hp > 0)
            toons.get(2).speedlength = toons.get(2).speed;
            for(int s = 0; s < baddies.size(); s++)
            {
                if(baddies.get(s).hp > 0)
                {
                    baddies.get(s).speed = baddies.get(s).maxspeed + baddies.get(s).speed;
                }
            }
            for(int s = 0; s < baddies.size(); s++)
                if(baddies.get(s).hp > 0 && baddies.get(s).speed>=100)
                {
                    return baddies.get(s);
                }
            for(int d = 0; d < toons.size(); d++)
                if(toons.get(d).hp > 0 && toons.get(d).speed>=100)
                {
                    return toons.get(d);
                }
        }
        return null;
    }
    private class ClickAction implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {

        }
        public void mousePressed(MouseEvent e)
        {
          for(int i = 0; i < waves.get(0).size(); i++)
            if(waves.get(0).get(i).ContainsPoint(e.getX(), e.getY()) == true)
            {
                target = waves.get(0).get(i);
                for(int s = 0; s < toons.size(); s++)
                    toons.get(s).target = target;
            }
          for(int i = 0; i < toons.size(); i++)
            if(toons.get(i).ContainsPoint(e.getX(), e.getY()) == true)
            {
                target = toons.get(i);
                for(int s = 0; s < toons.size(); s++)
                    toons.get(s).target = target;
            }
        }
        public void mouseReleased(MouseEvent e)
        {

        }
        public void mouseEntered(MouseEvent e)
        {

        }
        public void mouseExited(MouseEvent e)
        {

        }
    }
}
