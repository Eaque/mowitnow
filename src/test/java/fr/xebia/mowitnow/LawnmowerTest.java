package fr.xebia.mowitnow;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Charles Dufour
 *
 */
public class LawnmowerTest {

    private Lawnmower lawnmower = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        lawnmower = new Lawnmower(new Position(1, 1), "N", "ADAGAGA");
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        lawnmower = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLawnmowerPositionDirectionString() {
        String test = null;
        new Lawnmower(new Position(), test, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLawnmowerPositionStringString() {
        new Lawnmower(null, Direction.E, null);
    }

    /**
     * Test method for {@link fr.xebia.mowitnow.Lawnmower#turnLeft()}.
     */
    @Test
    public void testTurnLeft() {
        lawnmower.turnLeft();
        assertEquals(Direction.W, lawnmower.getDirection());
        lawnmower.turnLeft();
        assertEquals(Direction.S, lawnmower.getDirection());
        lawnmower.turnLeft();
        assertEquals(Direction.E, lawnmower.getDirection());
        lawnmower.turnLeft();
        assertEquals(Direction.N, lawnmower.getDirection());
    }

    /**
     * Test method for {@link fr.xebia.mowitnow.Lawnmower#turnRight()}.
     */
    @Test
    public void testTurnRight() {
        lawnmower.turnRight();
        assertEquals(Direction.E, lawnmower.getDirection());
        lawnmower.turnRight();
        assertEquals(Direction.S, lawnmower.getDirection());
        lawnmower.turnRight();
        assertEquals(Direction.W, lawnmower.getDirection());
        lawnmower.turnRight();
        assertEquals(Direction.N, lawnmower.getDirection());
    }

    /**
     * Test method for {@link fr.xebia.mowitnow.Lawnmower#getNextPosition()}.
     */
    @Test
    public void testGetNextPosition() {
        assertEquals(1, lawnmower.getNextPosition().getX());
        assertEquals(2, lawnmower.getNextPosition().getY());

        lawnmower.turnRight();
        assertEquals(2, lawnmower.getNextPosition().getX());
        assertEquals(1, lawnmower.getNextPosition().getY());
    }

    /**
     * Test method for {@link fr.xebia.mowitnow.Lawnmower#move()}.
     */
    @Test
    public void testMove() {
        assertEquals(1, lawnmower.getX());
        assertEquals(1, lawnmower.getY());

        lawnmower.move();
        assertEquals(1, lawnmower.getX());
        assertEquals(2, lawnmower.getY());
    }

}
