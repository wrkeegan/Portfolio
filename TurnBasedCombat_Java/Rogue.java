
package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;


public class Rogue extends Player
{
    RoguePanel rp;
    ArrayList<ArrayList<Human>> waves;
    Window win;
    boolean splash;
    boolean bad;
    Rogue sneak;
    public Rogue(ArrayList<Human> toons, RoguePanel rp, ArrayList<ArrayList<Human>> waves, int size, Window win)
    {
        this.toons = toons;
        this.rp = rp;
        this.waves = waves;
        this.win = win;
        sneak = this;
        limitx = 70;
        limity = 70;
        assualt.addActionListener(new attackAction());
        spell.addActionListener(new SpellMenu());
        skip.addActionListener(new skipAction());
        ability1 = new JButton("Fail Strike");
        ability2 = new JButton("Splash Attack");
        ability3 = new JButton("So Bad");
        spellback = new JButton("Back");
        ability1.addActionListener(new spell1());
        ability2.addActionListener(new spell2());
        ability3.addActionListener(new spell3());
        spellback.addActionListener(new spellback());
        name = "Rogue";
        tmp = 300;
        mpmax = 300;
        hp = 650;
        hpmax = 650;
        attack  = 1;
        magic = 10;
        wisdom = 10;
        speed = 10;
        maxspeed = 10;
        if(size == 0)
       {
           y = 300;
           dy = 300;
           hpy = 570;
       }
       if(size == 1)
       {
           y = 400;
           dy = 400;
           hpy = 600;
       }
       if(size == 2)
       {
           y = 500;
           dy = 500;
           hpy = 630;
       }
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.fillOval((int)x, (int)y, 30, 30);
    }
    public void move()
    {

    }
    public void displayMenu()
    {
        win.addbutton(assualt, spell, skip);
    }
    public void castSpell1()
    {
        if(target != null && target.hp <= 0)
            target=null;
                speed = 0;
         if(cast1 == CAST1_APPROACHING)
         {
            if(target != null)
            {
                if(distanceTo((target)) >= 20)
                    moveTo(target, 50);
                else
                    cast1 = CAST1_CASTING;
            }
         }
         if(cast1 == CAST1_CASTING)
         {
            target.hp = target.hp - 2;
            bp.lol = true;
            target.barlength = (target.hp / target.hpmax) * target.maxbarlength;
            if(target.hp <= 0)
            {
                bp.target = null;
                removeTarget(target, toons, waves);
            }
            cast1 = CAST1_RETURNING;
         }
         if(cast1 == CAST1_RETURNING)
            {
              if(distanceTo(dx,dy)>=50)
              {
                moveTo(dx, dy, 50);
              }
              else
              {
                  x=dx;
                  y=dy;
                  cast1 = CAST1_WAITING;
                  bp.lol = false;
                  done = true;  //find next player
              }
         }
    }
    public void castSpell2()
    {
       if(spells.isEmpty() == false && target != null && splash == true)
       {
          target.maxspeed = target.maxspeed - 1;
          splash = false;
          done = true;
       }
    }
    public void castSpell3()
    {
      if(spells.isEmpty() == false && target != null && bad == true)
       {
          bad = false;
          done = true;
       }
    }
    public class attackAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            target = bp.target;
            if(target != null)
            {
                phase = PHASE_APPROACHING;
                damage = true;
                win.removeButton(assualt, spell, skip);
            }
        }
    }
    public class SpellMenu implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.removeButton(assualt, spell, skip);
            win.spellMenu(ability1, ability2, ability3, spellback);
        }
    }
    public class spell1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            target = bp.target;
            if(tmp < 1)
                oom = true;
            else
                oom = false;
            if(target != null && oom == false)
            {
                oom = false;
                cast1 = CAST1_APPROACHING;
                tmp = tmp - 1;
                manalength = (tmp / mpmax) * maxmanabar;
                win.removeSpells(ability1, ability2, ability3, spellback);
            }
        }
    }
    public class spell2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            target = bp.target;
            if(tmp < 1)
                oom = true;
            else
                oom = false;
            if(target != null && oom == false)
            {
                oom = false;
                spells.add(new SplashAttack(sneak));
                spell1 = true;
                splash = true;
                tmp = tmp - 1;
                manalength = (tmp / mpmax) * maxmanabar;
                win.removeSpells(ability1, ability2, ability3, spellback);
            }
        }
    }
    public class spell3 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            target = bp.target;
            if(tmp < 1)
                oom = true;
            else
                oom = false;
            if(target != null && oom == false)
            {
                oom = false;
                spells.add(new SoBad(sneak));
                spell1 = true;
                bad = true;
                tmp = tmp - 1;
                manalength = (tmp / mpmax) * maxmanabar;
                win.removeSpells(ability1, ability2, ability3, spellback);
            }
        }
    }
     public class spellback implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.removeSpells(ability1, ability2, ability3, spellback);
            win.addbutton(assualt, spell, skip);
        }
    }
    public class skipAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            win.removeButton(assualt, spell, skip);
            done = true;
        }
    }
}
