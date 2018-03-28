package controller;

import model.Card;

import java.util.ArrayList;

public class UsedPile {

    private ArrayList<Card> used;

    public UsedPile() {
        this.used = new ArrayList<>();
    }

    /**
     * Adds a card to the player's used pile.
     *
     * @param used
     *          the card to add to the used pile
     */
    public void add(Card used) {
        this.used.add(used);
    }

    /**
     * Gets the sum value of the cards in the player's used pile.
     *
     * @return the sum of the player's used pile
     */
    public int value() {
        int value = 0;
        for (Card c : this.used) {
            value += c.value();
        }
        return value;
    }

    public void clear() {
        this.used.clear();
    }

    /**
     * Prints the used pile of the current player.
     */
    public void print() {
        for (Card c : this.used) {
            System.out.println(c);
        }
    }


}
