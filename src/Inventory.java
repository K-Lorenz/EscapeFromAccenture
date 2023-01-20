import java.util.ArrayList;

public class Inventory {
    private  ArrayList<Item> items;
    private ArrayList<Weapon> weapons;

    public void useItem(Item item){
        items.remove(item);
    }
    public void addItem(Item item){
        items.add(item);
    }
    public void addWeapon(Weapon weapon){
        weapons.add(weapon);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
}
