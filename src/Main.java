import java.util.ArrayList;

public class Main {
    Weapon tablet = new Weapon("Eatery-Tablett", 1, 1);
    Weapon kensington = new Weapon("Kensington-Lock", 5, 1);
    Weapon handy = new Weapon("Firmenhandy", 3,1);
    Weapon pen = new Weapon("Kugelschreiber", 6, 6);
    Weapon calc = new Weapon("Taschenrechner", 7,9);
    Weapon mug = new Weapon("Kaffeetasse", 6, 4);
    Weapon tack = new Weapon("Tacker", 9, 12);t
    Weapon enemy = new Weapon("Gegnerwaffe", 2, 0);
    Weapon boss = new Weapon("Bosswaffe", 5, 0);

    Player tabse = new Player ("Tabse Sonnenbein", "Tank", 20, 0,10,tablet);
    Player julia = new Player("Julia Süß", "Fighter", 18, 0, 15, handy);
    Player ramona = new Player("Ramona Reichelung", "Assasin", 15, 0, 20,kensington);

    Item red = new Item("Fritz Limo Rot");
    Item orange = new Item("Fritz Limo Orange");
    Item yellow = new Item("Fritz Limo Gelb");

    Enemy empfang = new Enemy("Empfangsdame", 15, enemy, 1, );
}