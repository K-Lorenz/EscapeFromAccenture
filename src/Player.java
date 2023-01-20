public class Player {
    private final String name;
    private int hitPoints;
    private final String type;
    private int level;
    private int stamina;
    private Weapon weapon;
    private Inventory inventory;
    private Location location;
    private int maxHitPoints;
    private int maxStamina;

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setLevel(int level) {
        this.level = level;
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
        this.stamina = stamina;
        this.weapon = weapon;
        this.type = type;
        switch (type) {
            case "Assassine" -> {
                maxHitPoints = 15;
                maxStamina = 20;
            }
            case "Fighter" -> {
                maxHitPoints = 18;
                maxStamina = 15;
            }
            case "Tank" -> {
                maxStamina = 10;
                maxHitPoints = 20;
            }
        }
    }
    public void move(Location location){
        setLocation(location);
    }
    public void attack(Enemy enemy, boolean isHeavy){
        if(isHeavy){
            if(stamina > weapon.heavyAttackStamina()){
                enemy.setHitPoints(enemy.getHitPoints() - weapon.damage() * 2);
                stamina -= weapon.heavyAttackStamina();
            }else {
                System.out.println("Kein HeavyAttack möglich! Es wird eine normale Attacke ausgeführt!");
                enemy.setHitPoints(enemy.getHitPoints() - weapon.damage());
            }

        }else{
            enemy.setHitPoints(enemy.getHitPoints() - weapon.damage());
        }
    }
    public void consume(Item item) {
        inventory.useItem(item);
        switch (item.getName()) {
            case "Fritz Limo Rot" -> {
                hitPoints += 4;
                if (hitPoints > maxHitPoints) {
                    hitPoints = maxHitPoints;
                }
            }
            case "Fritz Limo Gelb" -> {
                stamina += 10;
                if (stamina > maxStamina) {
                    stamina = maxStamina;
                }
            }
            case "Fritz Limo Orange" -> {
                stamina += 5;
                hitPoints += 2;
                if (stamina > maxStamina) {
                    stamina = maxStamina;
                }
                if (hitPoints > maxHitPoints) {
                    hitPoints = maxHitPoints;
                }
            }
        }
    }

    public void rest(){
        if(location.getName().equals("Campus Kornberg")){
            stamina = maxStamina;
            hitPoints = maxHitPoints;
        }
    }
}
