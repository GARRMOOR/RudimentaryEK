import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class for handling Player turns, hands, and interactions.
 */
public class Player {
    private final int playerNum;
    private final String name;
    private List<Card> hand;
    

    /**
     * Initializes a Player object when called.
     * 
     * @param playerNum the Player's number in play order
     */
    public Player(int playerNum) {
        this.hand = new ArrayList<>();
        this.playerNum = playerNum;
        this.name = "Player " + (playerNum + 1);
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
     * @param in the Scanner object used for user input
     */
    public void takeTurn(Game game, Scanner in) {
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
                int gameAction = cardChoice.playCard(game, in);
                if (gameAction == 1) {
                    response = "";
                } else if (gameAction == 2) {
                    this.drawCard(cardChoice);
                }
                //Catch extra \n
                in.nextLine();
            } else {
                System.out.println("Drawing card and ending turn...");
                Card drawnCard = this.drawCard(game.getDrawPile());
                System.out.println("You drew " + drawnCard.toString());

                //Exploding Kitten?
                boolean drewKitten = false;
                int index = -1;
                if (drawnCard.getType() == CardType.EXPLODING_KITTEN) {
                    drewKitten = true;
                    this.hand.remove(this.hand.size() - 1);
                    //Checks to see if Player has defuse
                    for (int i = 0; i < this.hand.size(); i++) {
                        if (this.hand.get(i).getType() == CardType.DEFUSE) {
                            index = i;
                        }
                    }
                    //If they do, use it. If they don't, eliminate the Player from the game
                    if (index >= 0) {
                        game.getDiscardPile().push(this.hand.get(index));
                        this.hand.remove(index);
                        System.out.println("You were saved by your defuse!");
                        System.out.print("Where would you like to insert the exploding kitten? (0 - " + (game.getDrawPile().size() - 1) + ") ");
                        game.getDrawPile().add(in.nextInt(), drawnCard);
                    } else {
                        System.out.println("You have no defuse and have lost the game!");
                        game.getDiscardPile().push(drawnCard);
                        game.getPlayers().remove(game.getCurrPlayer());
                    }
                }
                //Ends turn. Only advances to next player if current player does not have more turns
                if (drewKitten && index == -1) {
                    //Do nothing. Ends turn and next player is in currPlayer spot
                } else if (game.getNumTurns() == 1) {
                    game.setCurrPlayer(game.getCurrPlayer() + 1);
                } else {
                    game.setNumTurns(game.getNumTurns() - 1);
                }
            }
        } while (response.equals("y"));
        
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public String getName() {
        return this.name;
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