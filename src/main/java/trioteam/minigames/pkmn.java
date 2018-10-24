/*
 * Made By: Conner Cullity
 * Date: 
 * Description: 
 */
package trioteam.minigames;

/**
 *
 * @author Conner
 */
public class pkmn {

    public String pkmn;
    public int maxHP;
    public String move1;
    public int move1DMG;
    public String move2;
    public int move2DMG;

    public pkmn(String p, int hp, String m1, int m1d, String m2, int m2d) {
        pkmn = p;
        maxHP = hp;
        move1 = m1;
        move1DMG = m1d;
        move2 = m2;
        move2DMG = m2d;
    }

    public pkmn() {

    }
}
