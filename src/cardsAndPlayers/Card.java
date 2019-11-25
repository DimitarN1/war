package cardsAndPlayers;

public class Card {
    private char type='E';
    final static String CARDS_SEQUENCE = "23456789TJQKA";
    Card(char type){
        if (CARDS_SEQUENCE.indexOf(type)!=-1){
            this.type=type;
        }
    }
    int compareWith(Card other){
        if (CARDS_SEQUENCE.indexOf(type)<CARDS_SEQUENCE.indexOf(other.type)){
            return -1;
        }
        if (CARDS_SEQUENCE.indexOf(type)>CARDS_SEQUENCE.indexOf(other.type)){
            return 1;
        }
        return 0;
    }
    char getType(){
        return type;
    }
}
