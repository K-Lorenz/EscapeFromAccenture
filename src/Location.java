import java.util.ArrayList;
public class Location {
    private String name;
    private int enemyLvl;
    private Enemy boss;
    private String room;
    private int floor;
    private int bossFloor;
    private boolean isFinished;
    private boolean isRest;
    private ArrayList<Enemy> enemies;


    public Location(String name, Enemy boss, String room, int floor, int bossFloor,boolean isFinished, boolean isRest, ArrayList<Enemy> enemies){
        this.name = name;
        this.boss = boss;
        this.room = room;
        this.floor = floor;
        this.bossFloor = bossFloor;
        this.isFinished = isFinished;
        this.isRest = isRest;
        this.enemies = enemies;
    }

    public String getName(){
        return name;
    }

    public int getEnemyLvl() {
        return enemyLvl;
    }

    public Enemy getBoss() {
        return boss;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getBossFloor() {
        return bossFloor;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public boolean isRest() {
        return isRest;
    }
    
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    

    

    


}
