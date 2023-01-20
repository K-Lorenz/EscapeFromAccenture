
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Player player = new Player("Ramona Reichelung", "Assasin", 15, 0, 20);

        player.setWeapon(game.getWeaponWithName("Kensington-Lock"));
        Inventory inv = new Inventory();
        inv.addItem(game.getItemWithName("Fritz Limo Rot"));
        player.setInventory(inv);
        Enemy enemy = new Enemy("Tech-Support", 15,1, game.getWeaponWithName("Gegnerwaffe"), game.loot);
        //game.playGame(game.startGame(game.genPlayers()));
        game.fight(player, enemy);
    }

}