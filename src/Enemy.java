import java.util.ArrayList;

public class Enemy {
    private String name;
    private int hitPoints;
    private Weapon weapon;
    private int droppedXp;
    private ArrayList<Item> loot;

    public Enemy(String name, int hitPoints, Weapon weapon, int droppedXp, ArrayList<Item> loot){
        this.name = name;
        this.hitPoints = hitPoints;
        this.droppedXp = droppedXp;
        this.weapon = weapon;
        this.loot= loot;
    }

    public String name(){
        return name;
    }

    public int hitPoints(){
        return hitPoints;
    }

    public Weapon weapon(){
        return weapon;
    }

    public int droppedXp(){
        return droppedXp;
    }

    public ArrayList<Item>loot(){
        return loot;
    }
}
