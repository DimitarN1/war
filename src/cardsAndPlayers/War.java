package cardsAndPlayers;


public class War {
    private Player player1;
    private Player player2;

    public War(Player player1, Player player2) {
        if (player1!=null&&player2!=null) {
            this.player1 = player1;
            this.player2 = player2;
        }
    }
    public void play(){
        if (decksAreIncorrect(player1.getDeckAsString(),player2.getDeckAsString())){
            System.out.println("Someone's cheating!");
            return;
        }
        Card[] cardsAtSteak = new Card[52];
        int cardsAtSteakCounter=0;
        boolean warIsDeclared = false;
        int warCounter=0;
        for (int i = 0; i < 26; i++) {
            Card p1Card = player1.getCardAt(i);
            Card p2Card = player2.getCardAt(i);
            System.out.println(player1.getName() + " draws " + p1Card.getType());
            System.out.println(player2.getName() + " draws " + p2Card.getType());
            System.out.println();
            cardsAtSteak[cardsAtSteakCounter]=p1Card;
            cardsAtSteakCounter++;
            cardsAtSteak[cardsAtSteakCounter]=p2Card;
            cardsAtSteakCounter++;
            if (warIsDeclared&&warCounter<2){
                warCounter++;
                continue;
            }
            if (p1Card.compareWith(p2Card) == 1){
                player1.collectCards(cardsAtSteak,cardsAtSteakCounter);
                cardsAtSteak=new Card[52];
                cardsAtSteakCounter=0;
                warCounter=0;
                warIsDeclared=false;
                System.out.println(player1.getName() + " collects ");
                System.out.println();
            }
            if (p1Card.compareWith(p2Card) == -1){
                player2.collectCards(cardsAtSteak,cardsAtSteakCounter);
                cardsAtSteak=new Card[52];
                cardsAtSteakCounter=0;
                warCounter=0;
                warIsDeclared=false;
                System.out.println(player2.getName() + " collects ");
                System.out.println();
            }
            if (p1Card.compareWith(p2Card)==0){
                if (!warIsDeclared){
                    warIsDeclared=true;
                }
            }
        }
    }
    public void findTheWinner(){
        player1.printPlayerEndGameSats();
        player2.printPlayerEndGameSats();
        if (player1.getCollectedCardsCounter()>player2.getCollectedCardsCounter()){
            System.out.println(player1.getName()+" won the game!");
        }
        if (player1.getCollectedCardsCounter()<player2.getCollectedCardsCounter()){
            System.out.println(player2.getName()+" won the game!");
        }
        if (player1.getCollectedCardsCounter()==player2.getCollectedCardsCounter()){
            System.out.println("It's a draw!");
        }
    }
    private boolean decksAreIncorrect(String deck1 , String deck2){
        String fullDeck = deck1+deck2;
        for (int i = 0; i < Card.CARDS_SEQUENCE.length(); i++) {
            if (numberOfFinds(fullDeck,Card.CARDS_SEQUENCE.charAt(i))!=4){
                return true;
            }
        }
        return false;
    }
    private int numberOfFinds(String deck,char type){
        int counter=0;
        for (int i = 0; i < deck.length(); i++) {
            if (deck.charAt(i)==type){
                counter++;
            }
        }
        return counter;
    }
}
