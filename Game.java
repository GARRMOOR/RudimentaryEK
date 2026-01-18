import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Represents the game state and contains the runner code for the program.
 */
public class Game {
    private List<Card> drawPile;
    private Stack<Card> discardPile;
    private List<Player> players;
    private int currPlayer;
    private int numTurns;

    /**
     * Initializes the game when called.
     * 
     * @param playerCount the number of players that will be playing
     */
    public Game(int playerCount) {
        //Initialize Draw Pile
        this.drawPile = new ArrayList<>();
        addCards(this.drawPile, CardType.ATTACK, 4);
        addCards(this.drawPile, CardType.BEARD_CAT, 4);
        addCards(this.drawPile, CardType.CATERMELON, 4);
        addCards(this.drawPile, CardType.HAIRY_POTATO_CAT, 4);
        addCards(this.drawPile, CardType.RAINBOW_RALPHING_CAT, 4);
        addCards(this.drawPile, CardType.TACOCAT, 4);
        addCards(this.drawPile, CardType.FAVOR, 4);
        addCards(this.drawPile, CardType.NOPE, 5);
        addCards(this.drawPile, CardType.SEE_THE_FUTURE, 5);
        addCards(this.drawPile, CardType.SHUFFLE, 4);
        addCards(this.drawPile, CardType.SKIP, 4);
        Collections.shuffle(this.drawPile);

        //Initialize players and deal hands
        this.players = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            this.players.add(new Player(i));
            this.players.get(i).drawCard(new Card(CardType.DEFUSE));
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < playerCount; j++) {
                this.players.get(j).drawCard(this.drawPile);
            }
        }

        //Add remaining defuses and Exploding Kittens to the draw pile
        addCards(this.drawPile, CardType.DEFUSE, Math.min(6 - playerCount, 2));
        addCards(this.drawPile, CardType.EXPLODING_KITTEN, playerCount - 1);
        Collections.shuffle(this.drawPile);

        //Initialize Discard Pile
        this.discardPile = new Stack<>();
        //Inititialize player variables
        this.currPlayer = 0;
        this.numTurns = 1;
    }

    /**
     * Helper function to add cards to the draw pile.
     * 
     * @param deck the deck to add cards to
     * @param type the type of cards to add
     * @param count the number of those cards to add
     */
    private static void addCards(List<Card> deck, CardType type, int count) {
        for (int i = 0; i < count; i++) {
            deck.add(new Card(type));
        }
    }

    public Stack<Card> getDiscardPile() {
        return this.discardPile;
    }

    public List<Card> getDrawPile() {
        return this.drawPile;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public int getCurrPlayer() {
        return this.currPlayer;
    }

    public void setCurrPlayer(int player) {
        this.currPlayer = player;
    }

    public int getNumTurns() {
        return this.numTurns;
    }

    public void setNumTurns(int turns) {
        this.numTurns = turns;
    }
    public static void main (String[] args) {
        final int NUM_PLAYERS = 2;
        //Initialize Game
        Game game = new Game(NUM_PLAYERS);
        //Run Game
        while (game.getPlayers().size() > 1) {
            //Loop players
            if (game.getCurrPlayer() > game.getPlayers().size() - 1) {
                game.setCurrPlayer(0);
            }
            //If draw pile is empty, flip the discard
            if (game.drawPile.isEmpty()) {
                for (Card card : game.getDiscardPile()) {
                    game.getDrawPile().add(card);
                }
                game.getDiscardPile().clear();
            }
            //Take turns
            game.getPlayers().get(game.getCurrPlayer()).takeTurn(game);
        }
    }
}