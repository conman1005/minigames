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
    public String type;
    public double maxHP;
    public String move1;
    public String move1Type;
    public int move1DMG;
    public String move2;
    public String move2Type;
    public int move2DMG;

    public pkmn(String p, String tp, double hp, String m1, String m1T, int m1d, String m2, String m2T, int m2d) {
        pkmn = p;
        type = tp;
        maxHP = hp;
        move1 = m1;
        move1Type = m1T;
        move1DMG = m1d;
        move2 = m2;
        move2Type = m2T;
        move2DMG = m2d;
    }

    public pkmn() {

    }
}
