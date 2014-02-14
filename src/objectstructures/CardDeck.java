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
        while (n>0) {
            try {
                hand.addCard(cards.get(n));
                n--;
                cards.remove(n);
            }
            catch (Exception e) {

            }
        }
    }

    public void shufflePerfectly() {

    }

}
