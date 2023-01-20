public class Player {
    private final String name;
    private int hitPoints;
    private final String type;
    private int level;
    private int strength;
    private int stamina;
    private Weapon weapon;
    private Inventory inventory;
    private Location location;

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getStrength() {
        return strength;
    }

    public int getStamina() {
        return stamina;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Location getLocation() {
        return location;
    }

    public Player(String name, String type, int hitPoints, int strength, int stamina, Weapon weapon) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.stamina = stamina;
        this.weapon = weapon;
        this.type = type;
    }
    public void move(Location location){
        setLocation(location);
    }
    public void attack(Enemy enemy, boolean isHeavy){
        if(isHeavy){

        }else{

        }
    }
    public void consume(Item item){
        switch(item.getName()){
            case "":
        }
    }
    public void rest(){
        if(location. == ""){

        }
    }
}
