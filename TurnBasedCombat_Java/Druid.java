
package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;


public class Druid extends Player
{
    DruidPanel dp;
    ArrayList<ArrayList<Human>> waves;
    Window win;
    Druid drood;
    boolean revitalize;
    boolean insectswarm;
    boolean wrath;
    public Druid(ArrayList<Human> toons, DruidPanel dp, ArrayList<ArrayList<Human>> waves, int size, Window win)
    {
        this.toons = toons;
        this.dp = dp;
        this.waves = waves;
        this.win = win;
        drood = this;
        limitx = 30;
        limity = 30;
        assualt.addActionListener(new attackAction());
        spell.addActionListener(new SpellMenu());
        skip.addActionListener(new skipAction());
        ability1 = new JButton("Revitalize");
        ability2 = new JButton("Insect Swarm");
        ability3 = new JButton("Wrath of Nature");
        spellback = new JButton("Back");
        ability1.addActionListener(new spell1());
        ability2.addActionListener(new spell2());
        ability3.addActionListener(new spell3());
        spellback.addActionListener(new spellback());
        name = "Druid";
        tmp = 1000;
        mpmax = 1000;
        hp = 500;
        hpmax = 500;
        attack  = 10;
        magic = 50;
        wisdom = 75;
        speed = 3;
        maxspeed = 3;
       if(size==0)
       {
           y = 300;
           dy = 300;
           hpy = 570;
       }
       if(size==1)
       {
           y = 400;
           dy = 400;
           hpy = 600;
       }
       if(size==2)
       {
           y = 500;
           dy = 500;
           hpy = 630;
       }
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.ORANGE);
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
       if(spells.isEmpty() == false && target != null && revitalize == true)
       {
            target.hp = target.hp + 150;
            if(target.hp > target.hpmax)
                target.hp = target.hpmax;
            target.barlength = (target.hp / target.hpmax) * target.maxbarlength;
            revitalize = false;
            done = true;
        }
     }
    public void castSpell2()
    {
       if(spells.isEmpty() == false && target != null && insectswarm == true)
       {
         if(spells.get(0).distanceTo(target) >= 10)
            spells.get(0).moveTo(target, 10);
          else
          {
             target.hp = target.hp - 200;
             target.barlength = (target.hp / target.hpmax) * target.maxbarlength;
             target.attack = target.attack - 5;
             if(target.hp <= 0)
             {
              bp.target = null;
              removeTarget(target, toons, waves);
             }
            insectswarm = false;
            spell1 = false;
            spells.remove(0);
            done = true;
          }
        }
    }
    public void castSpell3()
    {
       if(spells.isEmpty() == false && target != null && wrath == true)
       {
            for(int i = 0; i < toons.size(); i++)
            {
                toons.get(i).hp = toons.get(i).hp + 500;
                if(toons.get(i).hp > toons.get(i).hpmax)
                    toons.get(i).hp = toons.get(i).hpmax;
                toons.get(i).barlength = (toons.get(i).hp / toons.get(i).hpmax) * toons.get(i).maxbarlength;
            }
            for(int i = 0; i < waves.get(0).size(); i++)
            {
                waves.get(0).get(i).hp = waves.get(0).get(i).hp - 100;
                waves.get(0).get(i).barlength = (waves.get(0).get(i).hp / waves.get(0).get(i).hpmax) * waves.get(0).get(i).maxbarlength;
                if(waves.get(0).get(i).hp <= 0)
                {
                    bp.target = null;
                    removeTarget(waves.get(0).get(i), toons, waves);
                }
            }
            wrath = false;
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
            if(tmp < 10)
                oom = true;
            else
                oom = false;
            if(target != null && oom == false)
            {
                oom = false;
                spells.add(new Revitalize(drood));
                spell1 = true;
                revitalize = true;
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
            if(tmp < 15)
                oom = true;
            else
                oom = false;
            if(target != null && oom == false)
            {
                oom = false;
                spells.add(new InsectSwarm(drood));
                spell1 = true;
                insectswarm = true;
                tmp = tmp - 15;
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
            if(tmp < 30)
                oom = true;
            else
                oom = false;
            if(target != null && oom == false)
            {
                oom = false;
                spells.add(new WrathofNature(drood));
                spell1 = true;
                wrath = true;
                tmp = tmp - 30;
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