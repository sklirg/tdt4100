package eksamensoving.e2013k;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class DiceTest {
    private Dice dice;

    @Before
    public void setUp() throws Exception {
        this.dice = new Dice(6);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetHighestValueOf() {
        dice.roll("1e");
        assertEquals(3, dice.getHighestValueOf(2, 0));
        assertEquals(1, dice.getHighestValueOf(2, 3));
        assertEquals(0, dice.getHighestValueOf(4, 0));
    }

    @Test
    public void testGetStraightSum(){
        dice.roll("1f");
        assertEquals(6, dice.getStraightSum(1,3));
        assertEquals(0, dice.getStraightSum(1,5));
    }

    @Test
    public void testRoll() {
        int[] dicevals = new int[]{1,2,3,4,5,6};
        try {
            dice.roll(dicevals);
        } catch (Exception e) {
            // should not throw exception?
        }
        assertTrue(dicevals == dice.dicelist);

        try {
            dice.roll(new int[]{1,2,3});
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
}
