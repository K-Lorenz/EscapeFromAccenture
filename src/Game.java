import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Game {
    public Game(){
        weapons = genWeapons();
        items = genItems();
        enemies =  genEnemies();
        locations = genLocations();
        players = genPlayers();
    }
    ArrayList<Weapon> weapons;
    ArrayList<Player> players;
    ArrayList<Location> locations;
    ArrayList<Item> items;
    ArrayList<Enemy> enemies;
    Scanner s = new Scanner(System.in);
    ArrayList <Item> loot = new ArrayList<>();
    public Weapon getWeaponWithName(String name){
        for(Weapon w: weapons){
            if(w.name().equals(name)){
                return w;
            }
        }
        return null;
    }
    public Location getLocationWithName(String name){
        for(Location l: locations){
            if(l.getName().equals(name)){
                return l;
            }
        }
        return null;
    }
    public Item getItemWithName(String name){
        for(Item w: items){
            if(w.getName().equals(name)){
                return w;
            }
        }
        return null;
    }
    public Enemy getEnemyWithName(String name){
        for(Enemy w: enemies){
            if(w.getName().equals(name)){
                return w;
            }
        }
        return null;
    }
    public void waitTime(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public Player startGame(ArrayList<Player> players){
        Player activePlayer = null;
        System.out.println("Guten Tag! EscapeFromAccenture ist ein Adventure Terminal Spiel.");
        waitTime(100);
        System.out.println("Dieses Spiel ist ein rundenbasiertes Kampfspiel. Zuerst greift der Spieler an, dann der Gegner." +
                " Das Ziel des Spiels ist es alle konkurriende Firmen insolvent gehen zu lassen");
        waitTime(100);
        System.out.println("Als Erstes musst du einen von drei Charakteren auswählen!(1, 2, 3)");
        waitTime(100);
        for(Player player: players) {
            if (players.indexOf(player) == players.size() - 1) {
                System.out.print(players.indexOf(player) + 1 + " - " + player.getName() + " - Klasse: " + player.getType());
            } else {
                System.out.print(players.indexOf(player) + 1 + " - " + player.getName() + " - Klasse: " + player.getType() +"; ");
            }
        }
        String input = s.nextLine();
        do{
            switch (input) {
                case "1" -> activePlayer = players.get(0);
                case "2" -> activePlayer = players.get(1);
                case "3" -> activePlayer = players.get(2);
                default -> {
                    System.out.println("Ungültige Eingabe Probiere es nochmal!");
                    input = s.nextLine();
                }
            }
        }while (input !="1" && input != "2" && input != "3");
        waitTime(100);
        System.out.println("Spieler " + activePlayer.getName() + " ");
    return  activePlayer;
    }
    public void setLocation(ArrayList<Location> locations, Player player){
        Location location = null;
        System.out.println("1 - GMPK | 2 - HEY! | 3 - WC | 4 - Delight.");
        String go = s.next();
        do {
            switch (go) {
                case "1" -> player.setLocation(getLocationWithName("GMPK Office"));
                case "2" -> player.setLocation(getLocationWithName("HEY! Office"));
                case "3" -> player.setLocation(getLocationWithName("WC Office"));
                case "4" -> player.setLocation(getLocationWithName("Delight. Office"));
                default -> {
                    System.out.println("1 - GMPK | 2 - HEY! | 3 - WC | 4 - Delight.");
                    go = s.next();
                }
            }
        } while (go !="1" && go != "2" && go != "3"&& go != "4");
    }
    public void playGame(Player player) {
        player.setLocation(getLocationWithName("Campus Kornberg"));
        System.out.println("Du spawnst in deiner Firma im Campus Kornberg...");
        waitTime(100);
        System.out.println("Du wurdest von deinem CEO beauftragt die gegnerischen Firmen in die Insolvenz zu treiben. Zu welcher gegnerischen Firma möchtest du gehen?");
        setLocation(locations, player);
        dungeon(player.getLocation(), player);
    }
    public void dungeon(Location location, Player player){
        System.out.println("Du gehst nach "+location.getName()+"...");
        waitTime(200);
        System.out.println("Du bist im "+location.getName()+" angekommen!");
        waitTime(100);
        System.out.println("Du betrittst das Gebäude und wirst von einem Feind angegriffen!");
        fight(player, getEnemyWithName("Empfang"));

    }
    public void fight(Player player, Enemy enemy){
        System.out.println("Der Kampf geht los!");
        while(player.getHitPoints()> 0 && enemy.getHitPoints() >0) {
            System.out.println("Willst du normal angreifen, einen schweren Angriff starten oder ein Item benutzen? (1 / 2 / 3)");
            String input = s.nextLine();
            do {
                switch (input) {
                    case "1" -> player.attack(enemy, false);
                    case "2" -> player.attack(enemy, true);
                    case "3" -> {
                        displayPlayerInventory(player);
                        System.out.println("Welches deiner Items möchtest du benutzen?");
                        String result = s.nextLine();
                        boolean eingabe = true;
                        while (eingabe) {
                            try {
                                int resultInt = Integer.parseInt(result);
                                if (resultInt >= 0 && resultInt <= player.getInventory().getItems().toArray().length) {
                                    player.consume(player.getInventory().getItems().get(resultInt));
                                    eingabe = false;
                                }
                            } catch (Exception e) {
                                System.out.println("Ungültige eingabe!");
                                result = s.nextLine();
                            }
                        }
                    }
                    default -> {
                        System.out.println("Ungültige Eingabe! Probiere es Nochmal!");
                        input = s.nextLine();
                    }
                }
            } while (!Objects.equals(input, "1") && !Objects.equals(input, "2") && !Objects.equals(input, "3"));
            enemy.attack(player);
        }

        System.out.println("Herzlichen Glühstrumpf! Du hast den Kampf gewonnen!");
        if(Math.random() < 0.1){
            System.out.println("Du hast einen Drop erhalten");
            double rndm = Math.random();
            if(rndm < 0.3){
                player.getInventory().addItem(getItemWithName("Fritz Limo Rot"));
            } else if(rndm < 0.6){
                player.getInventory().addItem(getItemWithName("Fritz Limo Orange"));
            } else{
                player.getInventory().addItem(getItemWithName("Fritz Limo Gelb"));
            }
        }else{
            System.out.println("Leider kein Drop erhalten :/");
        }
        waitTime(100);
    }
    public void insertDash(){
        System.out.println("-----------------------------------------------------------------------------------------");
    }
    public void displayPlayerStats(Player player){
        insertDash();
        System.out.println("Player Info: ");
        System.out.println("Stamina: " + player.getStamina() + "/" + player.getMaxStamina());
        System.out.println("Leben: " + player.getHitPoints() + "/" + player.getMaxHitPoints());
        System.out.println("Level: " + player.getLevel());
        System.out.println("XP: " + player.getXp() + "/4");
        System.out.println("Ort: " + player.getLocation());
        System.out.println("Equipped Weapon: " + player.getWeapon());
    }
    public void displayPlayerInventory(Player player){
        insertDash();
        System.out.println("Inventar: ");
        System.out.println("Items: ");
        for(Item item: player.getInventory().getItems()){
            System.out.println(item.getName());
        }
        System.out.println("Weapons: ");
        for(Weapon weapon: player.getInventory().getWeapons()){
            System.out.println(weapon.name());
        }

    }
    public ArrayList<Location> genLocations(){
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Campus Kornberg", null, 0, 0, true, true, null));
        locations.add(new Location("GMPK Office",getEnemyWithName("Till Bhomas") , 0, 3, false, false,enemies));
        locations.add(new Location("HEY! Office",getEnemyWithName("Sivio di Hermine") , 0, 3, false, false,enemies));
        locations.add(new Location("WC Office",getEnemyWithName("Rim Tyan") , 0, 4, false, false,enemies));
        locations.add(new Location("Delight. Office",getEnemyWithName("Runit Penjen") , 0, 5, false, false,enemies));
        return locations;
    }
    public ArrayList<Enemy> genEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy("Empfang", 15, 1, getWeaponWithName("Gegnerwaffe"), loot));
        enemies.add(new Enemy("Assistent", 15, 1,getWeaponWithName("Gegnerwaffe"), loot));
        enemies.add(new Enemy("Tech-Support", 15,1, getWeaponWithName("Gegnerwaffe"), loot));
        enemies.add(new Enemy("HR", 15,1,getWeaponWithName("Gegnerwaffe"), loot));
        enemies.add(new Enemy("Till Bhomas", 18, 10, getWeaponWithName("Kaffeetasse"), loot));
        enemies.add(new Enemy("Sivio di Hermine", 18, 10,getWeaponWithName("Kugelschreiber"), loot));
        enemies.add(new Enemy("Rim Tyan", 20, 10,getWeaponWithName("Taschenrechner"), loot));
        enemies.add(new Enemy("Runnit Penyen", 22,10,getWeaponWithName("Tacker"),loot));
        return enemies;
    }
    public ArrayList<Player> genPlayers(){
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player ("Tabse Sonnenbein", "Tank", 20, 0,10));
        players.add(new Player("Julia Süß", "Fighter", 18, 0, 15));
        players.add(new Player("Ramona Reichelung", "Assasin", 15, 0, 20));
        return players;
    }
    public ArrayList<Weapon> genWeapons(){
        ArrayList<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon("Eatery-Tablett", 1, 1, 4));
        weapons.add(new Weapon("Kensington-Lock", 5, 1,4));
        weapons.add(new Weapon("Firmenhandy", 3,1,4));
        weapons.add(new Weapon("Gegnerwaffe", 2, 0,1));
        weapons.add(new Weapon("Kugelschreiber", 5, 6,6));
        weapons.add(new Weapon("Taschenrechner", 5,9, 8));
        weapons.add(new Weapon("Kaffeetasse", 5, 4, 6));
        weapons.add(new Weapon("Tacker", 5, 12, 10));
        return weapons;
    }

    public ArrayList<Item> genItems(){
        ArrayList<Item> loot = new ArrayList<>();
        loot.add(new Item("Fritz Limo Rot"));
        loot.add(new Item("Fritz Limo Orange"));
        loot.add(new Item("Fritz Limo Gelb"));
        return loot;
    }
    public void givePlayerWeapons(Player player){
        switch(player.getName()){
            case("Tabse Sonnenbein"): player.setWeapon(getWeaponWithName("Eatery-Tablett"));
            case("Julia Süß"): player.setWeapon(getWeaponWithName("Firmenhandy"));
            case("Ramona Reichelung"): player.setWeapon(getWeaponWithName("Kensington-Lock"));
        }
    }
    public void giveXp(Player player, Enemy enemy){
        switch(enemy.getName()){
            case("Empfang"): player.setXp(player.getXp()+1);
            case("Assistent"): player.setXp(player.getXp()+1);
            case("Tech-Support"): player.setXp(player.getXp()+1);
            case("HR"): player.setXp(player.getXp()+1);
            case("Till Bhomas"): player.setXp(player.getXp()+1);
            case("Sivio di Hermine"): player.setXp(player.getXp()+10);
            case("Rim Tyan"): player.setXp(player.getXp()+10);
            case("Runnit Penjen"): player.setXp(player.getXp()+10);
        }
    }
}

