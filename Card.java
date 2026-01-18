public class Card {
    private CardType type;

    /**
     * Initializes a Card object when called.
     * 
     * @param type what type of card is being initialized
     */
    public Card(CardType type) {
        this.type = type;
    }

    /**
     * Enacts the effect of the card when played.
     */
    public void playCard() {
        switch (this.type) {
            case ATTACK -> {
                //Next player takes two turns, end current turn
            }
            case BEARD_CAT -> {
                //Does nothing alone
            }
            case CATERMELON -> {
                //Does nothing alone
            }
            case HAIRY_POTATO_CAT -> {
                //Does nothing alone
            }
            case RAINBOW_RALPHING_CAT -> {
                //Does nothing alone
            }
            case TACOCAT -> {
                //Does nothing alone
            }
            case DEFUSE -> {
                //Can't be played. Responds to EK
            }
            case EXPLODING_KITTEN -> {
                //Can't be played. Deletes player unless they hold a defuse
            }
            case FAVOR -> {
                //A player of your choice gives you a card of their choice
            }
            case NOPE -> {
                //Played in response to another card being played. Denies that card's effects from occurring
            }
            case SEE_THE_FUTURE -> {
                //Shows the player the next 3 cards in the draw pile
            }
            case SHUFFLE -> {
                //Shuffles the draw pile
            }
            case SKIP -> {
                //Ends current turn
            }
        }

    }

    /**
     * Represents the object as a String.
     * 
     * @return the string representation of the Card
     */
    public String toString() {
        return "" + type;
    }
}