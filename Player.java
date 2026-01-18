import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class for handling Player turns, hands, and interactions.
 */
public class Player {
    private List<Card> hand;
    private String name;

    /**
     * Initializes a Player object when called.
     * 
     * @param playerNum the Player's number in play order
     */
    public Player(int playerNum) {
        this.hand = new ArrayList<>();
        this.name = "Player " + playerNum;
    }

    /**
     * Adds a card to the player's hand from the game board's draw pile. Used for normal game situations.
     * 
     * @param drawPile the List to retrieve the card from
     * @return the card that was drawn
     */
    public Card drawCard(List<Card> drawPile) {
        Card drawnCard = drawPile.remove(0);
        this.hand.add(drawnCard);
        return drawnCard;
    }

    /**
     * Adds a card to the player's hand by specification. Used for initialization, favors (unimplemented), and cat card combos (unimplemented).
     * 
     * @param card the card to add to the hand
     */
    public void drawCard(Card card) {
        this.hand.add(card);
    }

    /**
     * Handles the normal turn of a player: Play cards, then draw.
     * 
     * @param game the current game state
     */
    public void takeTurn(Game game) {
        Scanner in = new Scanner(System.in);
        //Pre-turn info
        System.out.println(this.toString());
        System.out.println("You must take " + game.getNumTurns() + " turn(s)");
        //Decision making
        String response;
        do {
            System.out.print("Would you like to play cards? (y/n) ");
            response = in.nextLine();
            if (response.equals("y")) {
                System.out.print("Which card would you like to play (index) " + this.hand.toString() + ": ");
                Card cardChoice = this.hand.remove(in.nextInt());
                cardChoice.playCard();
                //Catch extra \n
                in.nextLine();
            } else {
                System.out.println("Drawing card and ending turn...");
                Card drawnCard = this.drawCard(game.getDrawPile());
                System.out.println("You drew " + drawnCard.toString());
                //Ends turn. Only advances to next player if current player does not have more turns
                if (game.getNumTurns() == 1) {
                    game.setCurrPlayer(game.getCurrPlayer() + 1);
                } else {
                    game.setNumTurns(game.getNumTurns() - 1);
                }
            }
        } while (response.equals("y"));
        
    }

    /**
     * Represents the object as a String.
     * 
     * @return the string representation of the Player
     */
    public String toString() {
        return this.name + ", Hand: " + this.hand.toString();
    }
}