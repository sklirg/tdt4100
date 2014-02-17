package objectstructures;
import java.util.ArrayList;
/**
 * Created by sklirg on 2/14/14.
 */
public class CardHand {
    ArrayList<Card> cards = new ArrayList<Card>();

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

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card play(int n) {
        Card r = this.cards.get(n);
        this.cards.remove(n);
        return r;
    }
}
