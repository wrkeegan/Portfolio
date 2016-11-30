

package finalfantasyfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;


public class Warrior extends Player
{
    WarriorPanel wp;
    ArrayList<ArrayList<Human>> waves;
    Window win;
    Warrior dread;
    boolean reinforceblade;
    boolean shout;
    public Warrior(ArrayList<Human> toons, WarriorPanel wp, ArrayList<ArrayList<Human>> waves, int size, Window win)
    {
        this.toons = toons;
        this.wp = wp;
        this.waves = waves;
        this.win = win;
        limitx = 30;
        limity = 30;
        assualt.addActionListener(new attackAction());
        spell.addActionListener(new SpellMenu());
        skip.addActionListener(new skipAction());
        ability1 = new JButton("Poweful Strike");
        ability2 = new JButton("Reinforce Blade");
        ability3 = new JButton("Shout");
        spellback = new JButton("Back");
        ability1.addActionListener(new spell1());
        ability2.addActionListener(new spell2());
        ability3.addActionListener(new spell3());
        spellback.addActionListener(new spellback());
        dread = this;
        name = "Warrior";
        tmp = 300;
        mpmax = 300;
        hp = 1000;
        hpmax = 1000;
        attack  = 100;
        magic = 1;
        wisdom = 1;
        speed = 4;
        maxspeed = 4;
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
        g.setColor(Color.BLACK);      
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
            target.hp = target.hp - 200;
            powerstrike = true;
            target.barlength = (target.hp / target.hpmax) * target.maxbarlength;
            if(target.hp <= 0)
            {
                bp.target = null;
                removeTarget(target, toons, waves);
            }
            target.x = 0;
            cast1 = CAST1_RETURNING;
         }
         if(cast1 == CAST1_RETURNING)
            {
              if(distanceTo(dx,dy)>=50)
              {
                moveTo(dx, dy, 50);
              }
              if(target.distanceTo(target.dx, target.dy) >= 50 && target.hp > 0)
              {
                  target.moveTo(target.dx, target.dy, 10);
              }
              else
              {
                  x=dx;
                  y=dy;
                  target.x=target.dx;
                  target.y=target.dy;
                  cast1 = CAST1_WAITING;
                  done = true;
              }
             }
    }
    public void castSpell2()
    {
      if(spells.isEmpty() == false && target != null && reinforceblade == true)
       {
          attack = attack + 10;
          reinforceblade = false;
          done = true;
        }
    }
    public void castSpell3()
    {
       if(spells.isEmpty() == false && target != null && shout == true)
        {
          for(int i = 0; i < waves.get(0).size(); i++)
          {
              waves.get(0).get(i).hp = waves.get(0).get(i).hp - 500;
              waves.get(0).get(i).barlength = (waves.get(0).get(i).hp / waves.get(0).get(i).hpmax) * waves.get(0).get(i).maxbarlength;
              waves.get(0).get(i).attack = waves.get(0).get(i).attack - 10;
              waves.get(0).get(i).speed = 0;
              if(waves.get(0).get(i).hp <= 0)
                  removeTarget(waves.get(0).get(i), toons, waves);
          }
          shout = false;
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
                oom = false;
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
            if(tmp < 20)
                oom = true;
            else
                oom = false;
            if(target != null && oom == false)
            {
                oom = false;
                cast1 = CAST1_APPROACHING;
                tmp = tmp - 20;
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
            if(tmp < 10)
                oom = true;
            else
                oom = false;
            if(target != null && oom == false)
            {
                oom = false;
                spells.add(new ReinforceBlade(dread));
                spell1 = true;
                reinforceblade = true;
                tmp = tmp - 10;
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
                spells.add(new Shout(dread));
                spell1 = true;
                shout = true;
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