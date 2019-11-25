package cardsAndPlayers;

public class Player {
    private String name;
    private Card[] deck = new Card[26];
    private Card[] collectedCards = new Card[52];
    private int collectedCardsCounter =0;
    private String deckAsString;
    public Player(String name,String cards){
        if (!name.equals("")){
            this.name = name;
        }
        deckAsString=cards;
        if (cards.length()==26){
            for (int i = 0; i < 26; i++) {
                this.deck[i] = new Card(cards.charAt(i));
            }
        }
    }
    void collectCards(Card[] cardsToCollect, int numberOfCards){
        for (int i = 0; i < numberOfCards; i++) {
            collectedCards[collectedCardsCounter] = cardsToCollect[i];
            collectedCardsCounter++;
        }
    }
    void printPlayerEndGameSats(){
        System.out.println(name + " won " + collectedCardsCounter + " cards:");
        for (int i = 0; i < collectedCardsCounter; i++) {
            System.out.print(collectedCards[i].getType());
        }
        System.out.println();
    }
    Card getCardAt(int index){
        return deck[index];
    }
    String getDeckAsString() {
        return deckAsString;
    }

    String getName() {
        return name;
    }

    public int getCollectedCardsCounter() {
        return collectedCardsCounter;
    }
}
