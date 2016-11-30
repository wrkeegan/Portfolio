

package finalfantasyfinalproject;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;


public abstract class Human
{
    int h;
    int w;
    double x;
    boolean oom;
    double y;
    double tmp;
    boolean moveback;
    boolean powerstrike;
    double mpmax;
    int hph = 20;
    int hpx;
    int hpy;
    ArrayList<Spell> spells = new ArrayList<Spell>();
    boolean spell1;
    boolean damage;
    double barlength = 200;
    double maxbarlength = 200;
    double mbw = 5;
    double manalength = 200;
    double maxmanabar = 200;
    double speedlength = 0;
    double hpmax;
    double limitx;
    double limity;
    double leftright = 0;
    double updown = 0;
    String name;
    Human target;
    double hp;
    double attack;
    double magic;
    double speed;
    double maxspeed;
    boolean done;
    double wisdom;
    boolean go;
    Random r = new Random();
    ArrayList<Human> toons;
    BattlePanel bp;
    double dx;
    double dy;
        int cast1;
    final int CAST1_WAITING=0;
    final int CAST1_APPROACHING=1;
    final int CAST1_CASTING=2;
    final int CAST1_RETURNING=3;
        int phase;
    final int PHASE_WAITING=0;
    final int PHASE_APPROACHING=1;
    final int PHASE_ATTACKING=2;
    final int PHASE_RETURNING=3;
    public abstract void draw(Graphics g);
    public abstract void move();
    public double angleTo(Human o)
    {
        return Math.atan2(o.y-y,o.x-x);
    }
    public double distanceTo(Human o)
    {
        return Math.sqrt((o.x-x)*(o.x-x)+(o.y-y)*(o.y-y));
    }
    public double distanceTo(double x, double y)
    {
        return Math.sqrt((x-this.x)*(x-this.x)+(y-this.y)*(y-this.y));
    }
    public void moveTo(double x, double y, double speed)
    {
        double angle = Math.atan2(y-this.y, x-this.x);
        move(angle, speed);
    }
    public void moveTo(Human o, double speed)
    {
        moveTo(o.x, o.y, speed);
    }
    public void move(double angle, double speed)
    {
        this.x += speed * Math.cos(angle);
        this.y += speed * Math.sin(angle);
    }
    public boolean ContainsPoint(double x, double y)
    {
        if(distanceTo(x, y) < 20)
            return true;
        else
            return false;
    }
    public Human findTarget(ArrayList<Human> toons)
     {
        Random r = new Random();
        Human target=null;
        while(target==null)
        {
            int find = r.nextInt(3);
            if(toons.get(find).hp > 0)
                target = toons.get(find);

/*            if(find == 0 && toons.get(0).hp > 0)
                target = toons.get(0);
            if(find == 1 && toons.get(1).hp > 0)
                target = toons.get(1);
            if(find == 2 && toons.get(2).hp > 0)
                target = toons.get(2);*/
        }
        return target;
     }
    public void preformAttack(ArrayList<ArrayList<Human>> waves)
    {
    if(target != null && target.hp <= 0)
        target=null;
            speed = 0;
     if(phase == PHASE_APPROACHING)
     {
        if(target != null)
        {
            if(distanceTo((target)) >= 30)
                moveTo(target, 50);
            else
                phase = PHASE_ATTACKING;
        }
        else
            done=true;
     }
     if(phase == PHASE_ATTACKING)
     {
        target.hp = target.hp - attack;
        target.barlength = (target.hp / target.hpmax) * target.maxbarlength;
        if(target.hp <= 0)
        {
            removeTarget(target, toons, waves);
        }
        phase = PHASE_RETURNING;
     }
     if(phase == PHASE_RETURNING)
        {
          if(distanceTo(dx,dy)>=50)
          {
            moveTo(dx, dy, 50);
          }
          else
          {
              x=dx;
              y=dy;
              phase = PHASE_WAITING;
              done = true;  //find next player
          }
       }
    }
    public abstract void castSpell1();
    public abstract void castSpell2();
    public abstract void castSpell3();
    public abstract void takeTurn();
    public abstract void removeTarget(Human target, ArrayList<Human> toons, ArrayList<ArrayList<Human>> waves);
}
