package objectstructures;

/**
 * Created by sklirg on 2/14/14.
 */
public class Card {
    private char suit;
    private int face;
    private char[] validSuits = {'S','H','D','C'};

    private boolean validateInput(char suit) {
        for (int i = 0; i < validSuits.length; i++) {
            if (suit == validSuits[i])
                return true;
        }
        return false;
    }

    private boolean validateInput(int face) {
        return (face >= 0 && face <= 12);
    }

    public Card(char suit, int face) {
        if (!(validateInput(suit)) || !(validateInput(face))) {
            throw new IllegalArgumentException("Invalid values for card.");
        }
        else {
            this.suit = suit;
            this.face = face;
        }
    }

    public char getSuit() {
        return suit;
    }

    public int getFace() {
        return face;
    }

    @Override
    public String toString() {
        return String.format("%s%s", suit, face);
    }
}
