package objectstructures;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import junit.framework.Assert;
import junit.framework.TestCase;
import no.hal.jex.runtime.JExercise;
import objectstructures.Card;
import objectstructures.CardDeck;
import objectstructures.CardHand;

@JExercise(description = "Tests objectstructures.CardDeck")
@SuppressWarnings("all")
public class CardDeckTest extends TestCase {
  private CardDeck deck;
  
  private CardDeck _init_deck() {
    CardDeck _cardDeck = new CardDeck(2);
    return _cardDeck;
  }
  
  @Override
  protected void setUp() {
    deck = _init_deck();
    
  }
  
  private void testCards(final CardDeck it, final Collection<String> toStrings) {
    int _size = toStrings.size();
    int _cardCount = it.getCardCount();
    Assert.assertEquals(_size, _cardCount);
    int i = 0;
    for (final String toString : toStrings) {
      {
        final Card card = it.getCard(i);
        char _suit = card.getSuit();
        String _valueOf = String.valueOf(_suit);
        int _face = card.getFace();
        String _plus = (_valueOf + Integer.valueOf(_face));
        Assert.assertEquals(toString, _plus);
        int _plus_1 = (i + 1);
        i = _plus_1;
      }
    }
  }
  
  @JExercise(tests = "CardDeck(int)", description = "Tests \n\t\tinitialization\n")
  public void testConstructor() {
    _test__constructor_transitions0_effect_state(deck);
    
  }
  
  @JExercise(tests = "CardDeck(int);void shufflePerfectly()", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>shufflePerfectly</li>\n\t\t</ul>\n")
  public void testShufflePerfectly() {
    _transition_exprAction__shufflePerfectly_transitions0_actions0(deck);
    _test__shufflePerfectly_transitions0_effect_state(deck);
    
  }
  
  @JExercise(tests = "CardDeck(int);void deal(objectstructures.CardHand,int)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>deal(hand, 3)</li>\n\t\t</ul>\n")
  public void testDeal() {
    CardHand hand = _init__deal_hand();
    _transition_exprAction__deal_transitions0_actions0(deck, hand);
    _test__deal_transitions0_effect_state(deck, hand);
    
  }
  
  private void _test__constructor_transitions0_effect_state(final CardDeck it) {
    _test__constructor_transitions0_effect_state_objectTests0_test(deck);
    
  }
  
  private void _test__constructor_transitions0_effect_state_objectTests0_test(final CardDeck it) {
    try {
      
      this.testCards(this.deck, Collections.<String>unmodifiableList(Lists.<String>newArrayList("S1", "S2", "H1", "H2", "D1", "D2", "C1", "C2")));
      } catch (junit.framework.AssertionFailedError error) {
      fail("testCards(deck, #[\"S1\", \"S2\", \"H1\", \"H2\", \"D1\", \"D2\", \"C1\", \"C2\"]) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__shufflePerfectly_transitions0_actions0(final CardDeck it) {
    try {
      
      it.shufflePerfectly();
      } catch (junit.framework.AssertionFailedError error) {
      fail("shufflePerfectly failed: " + error.getMessage());
    }
    
  }
  
  private void _test__shufflePerfectly_transitions0_effect_state(final CardDeck it) {
    _test__shufflePerfectly_transitions0_effect_state_objectTests0_test(deck);
    
  }
  
  private void _test__shufflePerfectly_transitions0_effect_state_objectTests0_test(final CardDeck it) {
    try {
      
      this.testCards(this.deck, Collections.<String>unmodifiableList(Lists.<String>newArrayList("S1", "D1", "S2", "D2", "H1", "C1", "H2", "C2")));
      } catch (junit.framework.AssertionFailedError error) {
      fail("testCards(deck, #[\"S1\", \"D1\", \"S2\", \"D2\", \"H1\", \"C1\", \"H2\", \"C2\"]) failed after shufflePerfectly: " + error.getMessage());
    }
    
  }
  
  private CardHand _init__deal_hand() {
    return new CardHand();
    
  }
  
  private void _transition_exprAction__deal_transitions0_actions0(final CardDeck it, final CardHand hand) {
    try {
      
      it.deal(hand, 3);
      } catch (junit.framework.AssertionFailedError error) {
      fail("deal(hand, 3) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__deal_transitions0_effect_state(final CardDeck it, final CardHand hand) {
    _test__deal_transitions0_effect_state_objectTests0_test(deck, hand);
    
  }
  
  private void _test__deal_transitions0_effect_state_objectTests0_test(final CardDeck it, final CardHand hand) {
    try {
      
      this.testCards(this.deck, Collections.<String>unmodifiableList(Lists.<String>newArrayList("S1", "S2", "H1", "H2", "D1")));
      } catch (junit.framework.AssertionFailedError error) {
      fail("testCards(deck, #[\"S1\", \"S2\", \"H1\", \"H2\", \"D1\"]) failed after deal(hand, 3): " + error.getMessage());
    }
    
  }
}