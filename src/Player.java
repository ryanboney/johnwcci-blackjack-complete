import java.util.ArrayList;

/**
 * This class will contain a player
 * blackjack player, either the user or the dealer.
 */
public class Player {
    private String name;
    private ArrayList<Card> cards;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Refreshs the players hand
     */
    public void NewHand() {
        cards = new ArrayList<>();
    }

    /**
     * Adds a card to players hand
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * See if the player is a dealer
     * 
     * @return true if dealer
     */
    public boolean isDealer() {
        return name.equalsIgnoreCase("dealer");
    }

    /**
     * Checks to see if a player has busted
     * over 21 in value
     * 
     * @return ture if over 21
     */
    public boolean isBust() {
        return getValue() > 21;
    }

    /**
     * Checks to see if player has blackjack
     * 
     * @return true if number of cards = 2 and the value is 21
     */
    public boolean isBlackjack() {
        return getValue() == 21 && cards.size() == 2;
    }

    /**
     * Gets the value of the cards
     * 
     * @return the value of the cards in hand
     */
    public int getValue() {
        int value = 0;
        boolean hasAce = false;
        for (Card card : cards) {
            if (!hasAce && card.getValue() == 1) {
                hasAce = true;
            }
            value += card.getValue();
        }
        if (hasAce && value < 12) {
            value += 10;
        }

        return value;
    }

    /**
     * gets the display value of the cards
     * 
     * @return gets the string value of the hand
     */
    public String getCardValue() {
        String returnValue = "";
        if (isDealer()) {
            returnValue = String.format("Dealers Hand is currently worth %d points", getDealerValue());
        } else {
            returnValue = String.format("Your Hand is currently worth %d points", getValue());
        }
        return returnValue;
    }

    private int getDealerValue() {
        int value = cards.get(0).getValue();

        if (value == 1) {
            value = 11;
        }

        return value;
    }

}
