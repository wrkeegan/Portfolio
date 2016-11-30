

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;


public class Priest extends Player
{
    PriestPanel pp;
    ArrayList<ArrayList<Human>> waves;
    Window win;
    Priest preach;
    boolean healinglight;
    boolean blessingofthekings;
    boolean healingrays;
    public Priest(ArrayList<Human> toons, PriestPanel pp, ArrayList<ArrayList<Human>> waves, int size, Window win)
    {
        this.toons = toons;
        this.pp = pp;
        this.waves = waves;
        this.win = win;
        limitx = 10;
        limity = 10;
        assualt.addActionListener(new attackAction());
        spell.addActionListener(new SpellMenu());
        skip.addActionListener(new skipAction());
        ability1 = new JButton("Healing Light");
        ability2 = new JButton("Blessing of the Light");
        ability3 = new JButton("Healing Rays");
        spellback = new JButton("Back");
        ability1.addActionListener(new spell1());
        ability2.addActionListener(new spell2());
        ability3.addActionListener(new spell3());
        spellback.addActionListener(new spellback());
        preach = this;
        name = "Priest";
        tmp = 1500;
        mpmax = 1500;
        hp = 400;
        hpmax = 400;
        attack  = 1;
        magic = 40;
        wisdom = 100;
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
       g.setColor(Color.WHITE);
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
       if(spells.isEmpty() == false && target != null && healinglight == true)
       {
          target.hp = target.hp + 150;
          if(target.hp > target.hpmax)
             target.hp = target.hpmax;
          target.barlength = (target.hp / target.hpmax) * target.maxbarlength;
          healinglight = false;
          done = true;
        }
    }
    public void castSpell2()
    {
        if(spells.isEmpty() == false && target != null && blessingofthekings == true)
       {
          target.attack = target.attack + 5;
          target.magic = target.magic + 5;
          if(target.maxspeed < 9)
            target.maxspeed = target.maxspeed + 1;
          target.wisdom = target.wisdom + 5;
          blessingofthekings = false;
          done = true;
        }
    }
    public void castSpell3()
    {
       if(spells.isEmpty() == false && target != null && healingrays == true)
       {
           for(int i = 0; i < toons.size(); i++)
           {
               toons.get(i).hp = toons.get(i).hp + 300;
                if(toons.get(i).hp > toons.get(i).hpmax)
                  toons.get(i).hp = toons.get(i).hpmax;
               toons.get(i).barlength = (toons.get(i).hp / toons.get(i).hpmax) * toons.get(i).maxbarlength;
           }
          healingrays = false;
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
            spells.add(new HealingLight(preach));
            spell1 = true;
            healinglight = true;
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
            spells.add(new BlessingoftheKings(preach));
            spell1 = true;
            blessingofthekings = true;
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
            spells.add(new HealingRays(preach));
            spell1 = true;
            healingrays = true;
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
