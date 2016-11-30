

package finalfantasyfinalproject;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Window extends JFrame
{
    Container pane;
    Timer intro;
    IntroPanel ip;
    MainMenuPanel mmp;
    CharSelectPanel csp;
    TutorialPanel tp;
    PriestPanel pp;
    WarriorPanel wp;
    RoguePanel rp;
    DruidPanel dp;
    MagePanel mp;
    AbilityPanel ap;
    RangerPanel rp2;
    BattlePanel bp;
    Wolf wolf;
    Wolf wolf2;
    Wolf wolf3;
    Squareman squareman;
    File filename;
    Orc orc;
    Orc orc2;
    Orc orc3;
    Orc orc4;
    Orc orc5;
    FinalBoss finalboss;
    ArrayList<Human> toons;
    ArrayList<ArrayList<Human>> waves;
    public Window()
    {
       setSize(new Dimension(1280, 1024));
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setTitle("Final Fantasy- Gauntlet");
       toons = new ArrayList<Human>();
       waves = new ArrayList<ArrayList<Human>>();
       waves.add(new ArrayList<Human>());
       waves.add(new ArrayList<Human>());
       waves.add(new ArrayList<Human>());
       waves.add(new ArrayList<Human>());
       waves.add(new ArrayList<Human>());
       waves.add(new ArrayList<Human>());
       waves.add(new ArrayList<Human>());
       waves.add(new ArrayList<Human>());
       waves.add(new ArrayList<Human>());
       waves.add(new ArrayList<Human>());
       wolf = new Wolf(toons, waves.get(0).size());
       waves.get(0).add(wolf);
       orc = new Orc(toons, waves.get(1).size());
       waves.get(1).add(orc);
       wolf2 = new Wolf(toons, waves.get(2).size());
       waves.get(2).add(wolf2);
       orc2 = new Orc(toons, waves.get(2).size());
       waves.get(2).add(orc2);   
       wolf3 = new Wolf(toons, waves.get(2).size());
       waves.get(2).add(wolf3);
       orc3 = new Orc(toons, waves.get(3).size());
       waves.get(3).add(orc3);
       orc4 = new Orc(toons, waves.get(3).size());
       waves.get(3).add(orc4);
       orc5 = new Orc(toons, waves.get(3).size());
       waves.get(3).add(orc5);
       squareman = new Squareman(toons);
       waves.get(4).add(squareman);
       finalboss = new FinalBoss(toons);
       waves.get(5).add(finalboss);
       pane = getContentPane();
       intro = new Timer(4000, new IntroAction());
       tp = new TutorialPanel(this);
       ip = new IntroPanel();
       mmp = new MainMenuPanel(this);
       csp = new CharSelectPanel(this);
       pp = new PriestPanel(this, toons, waves);
       wp = new WarriorPanel(this, toons, waves);
       rp = new RoguePanel(this, toons, waves);
       dp = new DruidPanel(this, toons, waves);
       mp = new MagePanel(this, toons, waves);
       rp2 = new RangerPanel(this, toons, waves);
       ap = new AbilityPanel(this);
       getContentPane().add(ip);
       intro.start();
       setVisible(true);
    }
    public class IntroAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            getContentPane().remove(ip);
            getContentPane().add(mmp);
            intro.stop();
            pack();
        }
    }
    public void addCharSelect()
    {
        remove(mmp);
        add(csp);
        pack();
        repaint();
    }
    public void addTutorialPanel()
    {
        remove(mmp);
        add(tp);
        pack();
        repaint();
    }
    public void backToMain()
    {
        remove(tp);
        add(mmp);
        pack();
        repaint();
    }
    public void backtoMain2()
    {
        remove(csp);
        add(mmp);
        pack();
        repaint();
    }
    public void priestpanel()
    {
        remove(csp);
        add(pp);
        pack();
        repaint();
    }
    public void warriorpanel()
    {
        remove(csp);
        add(wp);
        pack();
        repaint();
    }
    public void roguepanel()
    {
        remove(csp);
        add(rp);
        pack();
        repaint();
    }
    public void druidpanel()
    {
        remove(csp);
        add(dp);
        pack();
        repaint();
    }
    public void magepanel()
    {
        remove(csp);
        add(mp);
        pack();
        repaint();
    }
    public void rangerpanel()
    {
        remove(csp);
        add(rp2);
        pack();
        repaint();
    }
    public void DruidtoChar()
    {
      if(toons.size() < 3)
      {
        remove(dp);
        add(csp);
        pack();
        repaint();
      }
      else
      {
         remove(dp);
         initBattlePanel();
      }
    }
    public void toAP()
    {
        remove(tp);
        add(ap);
        pack();
        repaint();
    }
    public void MagetoChar()
    {
      if(toons.size() < 3)
      {
        remove(mp);
        add(csp);
        pack();
        repaint();
      }
      else
      {
        remove(mp);
        initBattlePanel();
      }
    }
    public void PriesttoChar()
    {
      if(toons.size() < 3)
      {
        remove(pp);
        add(csp);
        pack();
        repaint();
      }
      else
      {
          remove(pp);
          initBattlePanel();
      }
    }
    public void RangertoChar()
    {
      if(toons.size() < 3)
      {
        remove(rp2);
        add(csp);
        pack();
        repaint();
      }
      else
      {
        remove(rp2);
        initBattlePanel();
      }
    }
    public void RoguetoChar()
    {
      if(toons.size() < 3)
      {
        remove(rp);
        add(csp);
        pack();
        repaint();
      }
      else
      {
        remove(rp);
        initBattlePanel();
      }
    }
    public void WarriortoChar()
    {
     if(toons.size() < 3)
     {
        remove(wp);
        add(csp);
        pack();
        repaint();
     }
     else
     {
        remove(wp);
        initBattlePanel();
     }
    }
    public void initBattlePanel()
    {
        bp = new BattlePanel(toons, waves);
        for(int i = 0; i < toons.size(); i++)
             toons.get(i).bp = bp;
        for(int i = 0; i < toons.size(); i++)
             toons.get(i).toons = toons;
        add(bp);
        pack();
        repaint();
        bp.next = bp.findTurn(toons, waves.get(0));
        bp.next.takeTurn();
    }
    public void AddPlayer(Player p)
    {
        toons.add(p);
    }
    public void addbutton(JButton assualt, JButton spell, JButton skip)
    {
        Insets insets = getInsets();
        Dimension size = assualt.getPreferredSize();
        assualt.setBounds(750 + insets.left, 550 + insets.top,size.width, size.height);
        spell.setBounds(750 + insets.left, 580 + insets.top,size.width, size.height);
        skip.setBounds(750 + insets.left, 610 + insets.top,size.width, size.height);
        bp.add(assualt);
        bp.add(spell);
        bp.add(skip);
        pack();
        repaint();
    }
    public void removeButton(JButton assualt, JButton spell, JButton skip)
    {
        bp.remove(assualt);
        bp.remove(spell);
        bp.remove(skip);
        pack();
        repaint();
    }
    public void spellMenu(JButton ability1, JButton ability2, JButton ability3, JButton spellback)
    {
        Insets insets = getInsets();
        Dimension size = ability1.getPreferredSize();
        ability1.setBounds(750 + insets.left, 550 + insets.top,size.width, size.height);
        ability2.setBounds(750 + insets.left, 580 + insets.top,size.width, size.height);
        ability3.setBounds(750 + insets.left, 610 + insets.top,size.width, size.height);
        spellback.setBounds(750 + insets.left, 640 + insets.top,size.width, size.height);
        bp.add(ability1);
        bp.add(ability2);
        if(waves.size() <= 5)
            bp.add(ability3);
        bp.add(spellback);
        pack();
        repaint();
    }
    public void removeSpells(JButton ability1, JButton ability2, JButton ability3, JButton spellback)
    {
        bp.remove(ability1);
        bp.remove(ability2);
        bp.remove(ability3);
        bp.remove(spellback);
        pack();
        repaint();
    }
    public void backtotp()
    {
        remove(ap);
        add(tp);
        pack();
        repaint();
    }
}