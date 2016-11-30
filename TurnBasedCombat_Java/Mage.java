

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;


public class Mage extends Player
{
    MagePanel mp;
    Mage magi;
    ArrayList<ArrayList<Human>> waves;
    Window win;
    boolean slow;
    boolean fireball;
    boolean frost;
    public Mage(ArrayList<Human> toons, MagePanel mp, ArrayList<ArrayList<Human>> waves, int size, Window win)
    {
        this.toons = toons;
        this.mp = mp;
        this.waves = waves;
        this.win = win;
        magi = this;
        limitx = 10;
        limity = 10;
        assualt.addActionListener(new attackAction());
        spell.addActionListener(new SpellMenu());
        skip.addActionListener(new skipAction());
        ability1 = new JButton("Fireball");
        ability2 = new JButton("Slow");
        ability3 = new JButton("Frozen Death");
        spellback = new JButton("Back");
        ability1.addActionListener(new spell1());
        ability2.addActionListener(new spell2());
        ability3.addActionListener(new spell3());
        spellback.addActionListener(new spellback());
        name = "Mage";
        tmp = 1500;
        mpmax = 1500;
        hp = 400;
        hpmax = 400;
        attack  = 5;
        magic = 80;
        wisdom = 20;
        speed = 2;
        maxspeed = 2;
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
        g.setColor(Color.BLUE);   
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
       if(spells.isEmpty() == false && target != null && fireball == true)
       {
         if(spells.get(0).distanceTo(target) >= 50)
            spells.get(0).moveTo(target, 10);
          else
          {             
            target.hp = target.hp - 300;
            target.barlength = (target.hp / target.hpmax) * target.maxbarlength;
          if(target.hp <= 0)
          {
            bp.target = null;
            removeTarget(target, toons, waves);
          }
            spell1 = false;
            fireball = false;
            spells.remove(0);
            done = true;
          }
       }
    }
    public void castSpell2()
    {
       if(spells.isEmpty() == false && target != null && slow == true)
       {
            target.speed = 0;
            slow = false;
            done = true;
       }
    }
    public void castSpell3()
    {
       if(spells.isEmpty() == false && target != null && frost == true)
       {
         if(spells.get(0).distanceTo(target) >= 50)
            spells.get(0).moveTo(target, 10);
          else
          {
            for(int i = 0; i < waves.get(0).size(); i++)
            {
                waves.get(0).get(i).hp = waves.get(0).get(i).hp - 500;
                waves.get(0).get(i).barlength = (waves.get(0).get(i).hp / waves.get(0).get(i).hpmax) * waves.get(0).get(i).maxbarlength;
                  if(waves.get(0).get(i).hp <= 0)
                      removeTarget(waves.get(0).get(i), toons, waves);
            }
            spell1 = false;
            frost = false;
            spells.remove(0);
            done = true;
          }
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
            if(tmp < 10)
                oom = true;
            else
                oom = false;
            if(target != null && oom == false)
            {
                oom = false;
                spells.add(new FireBall(magi, waves));
                spell1 = true;
                fireball = true;
                tmp = tmp - 10;
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
            if(tmp < 5)
                oom = true;
            else
                oom = false;
            if(target != null && oom == false)
            {
                oom = false;
                spells.add(new Slow(magi));
                spell1 = true;
                slow = true;
                tmp = tmp - 5;
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
            if(tmp < 20)
                oom = true;
            else
                oom = false;
            if(target != null && oom == false)
            {
                oom = false;
                spells.add(new FrostBeam(magi));
                spell1 = true;
                frost = true;
                tmp = tmp - 20;
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