package reyalp;

import drac.Card;

import java.util.ArrayList;

/**
 * Class representing a Player of Love Letter.
 */
public class Player {

    /**
     * The name of the player.
     */
    private String name;
    /**
     * List of cards the player possesses.
     */
    private ArrayList<Card> hand;
    /**
     * List of cards the player has used.
     */
    private ArrayList<Card> usedPile;
    /**
     * True if the player is protected by a handmaiden, false if not.
     */
    private boolean isProtected;
    /**
     * The number of blocks the player has won.
     */
    private int blockCount;

    /**
     * Public constructor for Player object.
     *
     * @param name
     *          the player name
     */
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.usedPile = new ArrayList<>();
        this.isProtected = false;
        this.blockCount = 0;
    }

    /**
     * Adds one block to the players block count.
     */
    public void addBlock() {
        this.blockCount++;
    }

    /**
     * Peeks the card held by the player.
     *
     * @param idx
     *          the index of the Card to peek
     *
     * @return the card held by the player
     */
    public Card peekCard(int idx) {
        return hand.get(idx);
    }

    /**
     * Adds a card to the player's hand.
     * @param card
     *          the card to add
     */
    public void takeCard(Card card) {
        this.hand.add(card);
    }

    /**
     * Removes the card at the given index from the hand.
     *
     * @param idx
     *          the index of the card
     *
     * @return the card at the given index
     */
    public Card putDownCard(int idx) { return hand.remove(idx); }

    /**
     * Removes a card object from the player's hand and adds it to their
     * used pile.
     */
    public void loseCard() {
        this.usedPile.add(this.hand.remove(0));
    }

    /**
     * Prints the cards making up the current player's hand.
     */
    public void printHand() {
        for (Card c : this.hand) {
            System.out.println(c);
        }
    }

    /**
     * Adds a card to the player's used pile.
     *
     * @param used
     *          the card to add to the used pile
     */
    public void addToUsed(Card used) {
        this.usedPile.add(used);
    }

    /**
     * Gets the sum value of the cards in the player's used pile.
     *
     * @return the sum of the player's used pile
     */
    public int getUsedValue() {
        int value = 0;
        for (Card c : usedPile) {
            value += c.value();
        }
        return value;
    }

    /**
     * Prints the used pile of the current player.
     */
    public void printUsed() {
        for (Card c : this.usedPile) {
            System.out.println(c);
        }
    }

    /**
     * Checks to see if a player still has cards remaining.
     *
     * @return true, if the player has at least one card, false if not
     */
    public boolean hasCards() {
        return !hand.isEmpty();
    }

    /**
     * Switches the player's current level of protection.
     */
    public void switchProtection() {
        this.isProtected = !this.isProtected;
    }

    /**
     * Resets the player's hand, used pile, and protection level to their initial values.
     */
    public void reset() {
        hand.clear();
        usedPile.clear();
        isProtected = false;
    }

    /**
     * Finds the position of a royal card in the hand.
     *
     * @return the position of a royal card, -1 if no royal card is in hand
     */
    public int royaltyPos() {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).value() == 5 || hand.get(i).value() == 6) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks to see if the user is protected by a handmaiden.
     *
     * @return true, if the player is protected, false if not
     */
    public boolean isProtected() {
        return this.isProtected;
    }

    /**
     * Getter for the user's block count.
     *
     * @return player's block count
     */
    public int getBlockCount() {
        return this.blockCount;
    }

    /**
     * Getter for the user's name.
     *
     * @return player's name
     */
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.blockCount + ")";
    }
}
