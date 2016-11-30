
package finalfantasyfinalproject;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JButton;


public abstract class Player extends Human
{

    JButton assualt;
    JButton spell;
    JButton skip;
    JButton ability1;
    JButton ability2;
    JButton ability3;
    JButton spellback;
    public Player()
    {
        h =30;
        w = 30;
        x = 950;
        dx = 950;
        assualt = new JButton("Attack");
        spell = new JButton("Spells");
        skip = new JButton("Skip");
    }
    public abstract void draw(Graphics g);
    public void move(ArrayList<Human> baddies)
    {
        
    }
    public abstract void displayMenu();
    public void takeTurn()
    {
        displayMenu();
    }
    public void removeTarget(Human target, ArrayList<Human> toons, ArrayList<ArrayList<Human>> waves)
    {
        waves.get(0).remove(target);
            if(waves.get(0).isEmpty() == true)
              waves.remove(0);
            if(waves.isEmpty() == true)
                System.out.println("You Win");
    }
}
