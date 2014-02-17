package objectstructures;
import java.util.ArrayList;
/**
 * Created by sklirg on 2/14/14.
 */
public class CardDeck {
    ArrayList<Card> cards = new ArrayList<Card>();

    public CardDeck(int n) {
        char[] s = {'S','H','D','C'};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                Card c = new Card((s[i]), (j+1));
                cards.add(c);
            }
        }
    }

    public int getCardCount() {
        return cards.size();
    }

    public Card getCard(int n) {
        try {
            return cards.get(n);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("This card does not exist");
        }
    }

    public void deal(CardHand hand, int n) {
        Card cardToRemove = null;
        int cardCount = cards.size();


        while (n>0) {
            try {
                cardToRemove = cards.get(cardCount);
            }
            catch (Exception e) {
                // no card
            }
            if (cardToRemove != null) {
                hand.addCard(cardToRemove);
                cards.remove(cardToRemove);
                n--;
            }
            cardCount--;
        }

    }

    public void shufflePerfectly() {
         /*
          * Split into 2
          * Shuffle perfectly
          * Top card on top, bot card on bot
          */

        ArrayList<Card> topDeck = new ArrayList<Card>(), botDeck = new ArrayList<Card>();
        for (int i = cards.size(); i > 0; i--) {
            Card shuffleCard = null;
            try {
                shuffleCard = cards.get(i);
            }
            catch (Exception e) {
                // If card does not exist
            }
            if (shuffleCard != null) {
                if (i > cards.size() / 2) {
                    topDeck.add(shuffleCard);
                }
                else {
                    botDeck.add(shuffleCard);
                }
            }
        }
        int len;
        boolean equalStacks = false;
        Card extraCard = null;
        char extraCardStack;

        if (topDeck.size() == botDeck.size()) {
            equalStacks = true;
            len = topDeck.size();
        }
        else {
            if (topDeck.size()>botDeck.size()) {
                len = botDeck.size();
                extraCard = topDeck.get(topDeck.size()-1);
                extraCardStack = 't';
            }
            else {
                len = topDeck.size();
                extraCard = botDeck.get(botDeck.size()-1);
                extraCardStack = 'b';
            }
        }

        Card[] shuffledDeck = new Card[cards.size()];

        for (int i = len-1; i > 1; i-=2) {
            // Shuffle the cards
            shuffledDeck[i] = topDeck.get(i);
            shuffledDeck[i-1] = botDeck.get(i);
        }

        if (!equalStacks) {
            // Add the extra card
            shuffledDeck[shuffledDeck.length-1] = extraCard;
        }

        ArrayList<Card> newDeck = new ArrayList<Card>();

        for (int i = shuffledDeck.length; i > 0; i--) {
            newDeck.add(shuffledDeck[i]);
        }
        cards = newDeck;
    }
}
