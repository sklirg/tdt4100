package objectstructures;
import java.util.ArrayList;
/**
 * Created by sklirg on 2/14/14.
 */
public class CardHand {
    ArrayList<Card> cards = new ArrayList<Card>();

    public int getCardCount() {
        return 0;
    }

    public Card getCard(int n) {
        try {
            return cards.get(n);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("This card does not exist");
        }
    }

    public void addCard(Card card) {

    }

    public Card play(int n) {
        return cards.get(n);
    }
}
