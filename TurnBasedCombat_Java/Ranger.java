

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;


public class Ranger extends Player
{
    RangerPanel rp2;
    ArrayList<ArrayList<Human>> waves;
    Window win;
    Ranger arc;
    boolean bowstrike;
    boolean spellshot;
    boolean hail;
    public Ranger(ArrayList<Human> toons, RangerPanel rp2, ArrayList<ArrayList<Human>> waves, int size, Window win)
    {
        this.toons = toons;
        this.rp2 = rp2;
        this.waves = waves;
        this.win = win;
        limitx = 50;
        limity = 50;
        assualt.addActionListener(new attackAction());
        spell.addActionListener(new SpellMenu());
        skip.addActionListener(new skipAction());
        ability1 = new JButton("Bow Strike");
        ability2 = new JButton("Spell Shot");
        ability3 = new JButton("Hail of Arrows");
        spellback = new JButton("Back");
        ability1.addActionListener(new spell1());
        ability2.addActionListener(new spell2());
        ability3.addActionListener(new spell3());
        spellback.addActionListener(new spellback());
        arc = this;
        name = "Ranger";
        tmp = 500;
        mpmax = 500;
        hp = 700;
        hpmax = 700;
        attack  = 70;
        magic = 30;
        wisdom = 10;
        speed = 5;
        maxspeed = 5;
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
        g.setColor(Color.GREEN);
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
        if(spells.isEmpty() == false && target != null && bowstrike == true)
          {
           if(spells.get(0).distanceTo(target) >= 50)
            spells.get(0).moveTo(target, 20);
           else
           {
            target.hp = target.hp - 250;
            target.barlength = (target.hp / target.hpmax) * target.maxbarlength;
           if(target.hp <= 0)
           {
            bp.target = null;
            removeTarget(target, toons, waves);
           }
            spell1 = false;
            spells.remove(0);
            bowstrike = false;
            done = true;
           }
         }
    }
    public void castSpell2()
    {
        if(spells.isEmpty() == false && target != null && spellshot == true)
          {
           if(spells.get(0).distanceTo(target) >= 50)
            spells.get(0).moveTo(target, 20);
           else
           {
            target.hp = target.hp - 100;
            target.hpmax = target.hpmax - 50;
            target.barlength = (target.hp / target.hpmax) * target.maxbarlength;
           if(target.hp <= 0)
           {
            bp.target = null;
            removeTarget(target, toons, waves);
           }
            spell1 = false;
            spells.remove(0);
            spellshot = false;
            done = true;
           }
         }
    }
    public void castSpell3()
    {
        if(spells.isEmpty() == false && target != null && hail == true)
        {
         for(int i = 0; i <= 10; i++)
           {
              if(spells.get(0).distanceTo(target) >= 50)
               spells.get(0).moveTo(target, 15);
              else
               spells.remove(0);
           }
         }
        if(spells.isEmpty() == true && hail == true)
        {
         target.hp = target.hp - 1000;
         target.barlength = (target.hp / target.hpmax) * target.maxbarlength;
         if(target.hp <= 0)
          {
            bp.target = null;
            removeTarget(target, toons, waves);
          }
            spell1 = false;
            hail = false;
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
            if(tmp < 5)
                oom = true;
            else
                oom = false;
            if(target != null && oom == false)
            {
                oom = false;
                spells.add(new BowStrike(arc, waves));
                spell1 = true;
                bowstrike = true;
                tmp = tmp - 5;
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
                spells.add(new SpellShot(arc, waves));
                spell1 = true;
                spellshot = true;
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
            if(tmp < 25)
                oom = true;
            else
                oom = false;
            if(target != null && oom == false)
            {
                oom = false;
                for(int i = 0; i <= 10; i++)
                    spells.add(new HailofArrows(arc));
                spell1 = true;
                hail = true;
                tmp = tmp - 25;
                manalength = (tmp / mpmax) * maxmanabar;
                win.removeSpells(ability1, ability2, ability3,spellback);
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
