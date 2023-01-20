import java.lang.Math;
import java.util.ArrayList;

public class Enemy {
    private String name;
    private int hitPoints;
    private Weapon weapon;
    private int droppedXp;
    private ArrayList<Item> loot;

    public Enemy(String name, int hitPoints, int droppedXp, Weapon weapon, ArrayList<Item> loot){
        this.name = name;
        this.hitPoints = hitPoints;
        this.droppedXp = droppedXp;
        this.weapon = weapon;
        this.loot= loot;


    }

    public String getName(){
        return name;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public int getDroppedXp(){
        return droppedXp;
    }

    public ArrayList<Item>getLoot(){
        return loot;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setDroppedXp(int droppedXp) {
        this.droppedXp = droppedXp;
    }

    public void setLoot(ArrayList<Item> loot) {
        this.loot = loot;
    }

    public void attack(Player player){

        double prob;
        
        prob = Math.random();
        if(prob < 0.7){
            player.setHitPoints(player.getHitPoints()-(int)(weapon.damage()*1.5));
        }
        else{
            player.setHitPoints(player.getHitPoints()-weapon.damage());

        }
        
    }
}
