import java.util.Collections;
import java.util.Scanner;

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
     * 
     * @param game the state of the game
     * @param in the Scanner object to get user input
     * @return an action code for the outcome of the card
     */
    public int playCard(Game game, Scanner in) {
        switch (this.type) {
            case ATTACK -> {
                //Next player, two turns
                game.setCurrPlayer(game.getCurrPlayer() + 1);
                game.setNumTurns(2);
                return 1;
            }
            case BEARD_CAT -> {
                int cardCount = 1;
                for (Card card : game.getPlayers().get(game.getCurrPlayer()).getHand()) {
                    if (card.getType() == CardType.BEARD_CAT) {
                        cardCount++;
                    }
                }
                boolean hasPair = cardCount >= 2;
                boolean hasTrip = cardCount >= 3;
                int choice;
                if (hasTrip) {
                    System.out.print("You have enough of this card to play two or three at once. How many would you like to play? (0 - cancel, 2 - random steal, 3 - name your card) ");
                    choice = in.nextInt(); 
                } else if (hasPair) {
                    System.out.print("You have enough of this card to play two at once. How many would you like to play? (0 - cancel, 2 - random steal) ");
                    choice = in.nextInt();
                } else {
                    System.out.println("You can't play this card right now!");
                    return 0;
                }
                switch (choice) {
                    case 0 -> {
                        return 2;
                    }
                    case 2 -> {
                        //steal card
                        return 2;
                    }
                    case 3 -> {
                        //name card
                        return 2;
                    }
                }
            }
            case CATERMELON -> {
                int cardCount = 1;
                for (Card card : game.getPlayers().get(game.getCurrPlayer()).getHand()) {
                    if (card.getType() == CardType.CATERMELON) {
                        cardCount++;
                    }
                }
                boolean hasPair = cardCount >= 2;
                boolean hasTrip = cardCount >= 3;
                int choice;
                if (hasTrip) {
                    System.out.print("You have enough of this card to play two or three at once. How many would you like to play? (0 - cancel, 2 - random steal, 3 - name your card) ");
                    choice = in.nextInt(); 
                } else if (hasPair) {
                    System.out.print("You have enough of this card to play two at once. How many would you like to play? (0 - cancel, 2 - random steal) ");
                    choice = in.nextInt();
                } else {
                    System.out.println("You can't play this card right now!");
                    return 0;
                }
                switch (choice) {
                    case 0 -> {
                        return 2;
                    }
                    case 2 -> {
                        //steal card
                        return 2;
                    }
                    case 3 -> {
                        //name card
                        return 2;
                    }
                }
            }
            case HAIRY_POTATO_CAT -> {
                int cardCount = 1;
                for (Card card : game.getPlayers().get(game.getCurrPlayer()).getHand()) {
                    if (card.getType() == CardType.HAIRY_POTATO_CAT) {
                        cardCount++;
                    }
                }
                boolean hasPair = cardCount >= 2;
                boolean hasTrip = cardCount >= 3;
                int choice;
                if (hasTrip) {
                    System.out.print("You have enough of this card to play two or three at once. How many would you like to play? (0 - cancel, 2 - random steal, 3 - name your card) ");
                    choice = in.nextInt(); 
                } else if (hasPair) {
                    System.out.print("You have enough of this card to play two at once. How many would you like to play? (0 - cancel, 2 - random steal) ");
                    choice = in.nextInt();
                } else {
                    System.out.println("You can't play this card right now!");
                    return 0;
                }
                switch (choice) {
                    case 0 -> {
                        return 2;
                    }
                    case 2 -> {
                        //steal card
                        return 2;
                    }
                    case 3 -> {
                        //name card
                        return 2;
                    }
                }
            }
            case RAINBOW_RALPHING_CAT -> {
                int cardCount = 1;
                for (Card card : game.getPlayers().get(game.getCurrPlayer()).getHand()) {
                    if (card.getType() == CardType.RAINBOW_RALPHING_CAT) {
                        cardCount++;
                    }
                }
                boolean hasPair = cardCount >= 2;
                boolean hasTrip = cardCount >= 3;
                int choice;
                if (hasTrip) {
                    System.out.print("You have enough of this card to play two or three at once. How many would you like to play? (0 - cancel, 2 - random steal, 3 - name your card) ");
                    choice = in.nextInt(); 
                } else if (hasPair) {
                    System.out.print("You have enough of this card to play two at once. How many would you like to play? (0 - cancel, 2 - random steal) ");
                    choice = in.nextInt();
                } else {
                    System.out.println("You can't play this card right now!");
                    return 0;
                }
                switch (choice) {
                    case 0 -> {
                        return 2;
                    }
                    case 2 -> {
                        //steal card
                        return 2;
                    }
                    case 3 -> {
                        //name card
                        return 2;
                    }
                }
            }
            case TACOCAT -> {
                int cardCount = 1;
                for (Card card : game.getPlayers().get(game.getCurrPlayer()).getHand()) {
                    if (card.getType() == CardType.TACOCAT) {
                        cardCount++;
                    }
                }
                boolean hasPair = cardCount >= 2;
                boolean hasTrip = cardCount >= 3;
                int choice;
                if (hasTrip) {
                    System.out.print("You have enough of this card to play two or three at once. How many would you like to play? (0 - cancel, 2 - random steal, 3 - name your card) ");
                    choice = in.nextInt(); 
                } else if (hasPair) {
                    System.out.print("You have enough of this card to play two at once. How many would you like to play? (0 - cancel, 2 - random steal) ");
                    choice = in.nextInt();
                } else {
                    System.out.println("You can't play this card right now!");
                    return 0;
                }
                switch (choice) {
                    case 0 -> {
                        return 2;
                    }
                    case 2 -> {
                        //steal card
                        return 2;
                    }
                    case 3 -> {
                        //name card
                        return 2;
                    }
                }
            }
            case DEFUSE -> {
                System.out.println("This card can't be played!");
                return 2;
            }
            case EXPLODING_KITTEN -> {
                System.out.println("This card can't be played!");
                return 2;
            }
            case FAVOR -> {
                //A player of your choice gives you a card of their choice
            }
            case NOPE -> {
                //Played in response to another card being played. Denies that card's effects from occurring
            }
            case SEE_THE_FUTURE -> {
                System.out.print("Displaying the next three cards: ");
                System.out.println(game.getDrawPile().get(0).toString() + ", " + game.getDrawPile().get(1).toString() + ", " + game.getDrawPile().get(2).toString());
                return 0;
            }
            case SHUFFLE -> {
                System.out.println("Shuffling...");
                Collections.shuffle(game.getDrawPile());
                System.out.println("Shuffle complete!");
                return 0;
            }
            case SKIP -> {
                System.out.println("Skipping turn.");
                game.setCurrPlayer(game.getCurrPlayer() + 1);
                return 1;
            }
        }
        return 0;
    }

    public CardType getType() {
        return this.type;
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