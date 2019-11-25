package demo;

import cardsAndPlayers.Player;
import cardsAndPlayers.War;

public class WarGame {
    //private static int a=7;
    public static void main(String[] args) {
        Player one = new Player("Ivan","23456789TJQKA4JTQ23576A8K9");
        Player two = new Player("Petko","23456789TJQKA23456789TAJQK");
        War war = new War(one,two);
        war.play();
        war.findTheWinner();
        //int a=11;
       // System.out.println(demo.WarGame.a+a);
    }
}
