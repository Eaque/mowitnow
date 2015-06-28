/**
 * 
 */
package fr.xebia.mowitnow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * @author Charles Dufour
 *
 */
public class DirectionTest {

    /**
     * Test method for {@link fr.xebia.mowitnow.Direction#getDirection(java.lang.String)}.
     */
    @Test
    public void testGetDirection() {
        assertNull(Direction.getDirection(null));
        assertNull(Direction.getDirection(""));
        assertNull(Direction.getDirection("Z"));
        assertEquals(Direction.N, Direction.getDirection("N"));
        assertEquals(Direction.E, Direction.getDirection("E"));
        assertEquals(Direction.S, Direction.getDirection("S"));
        assertEquals(Direction.W, Direction.getDirection("W"));
    }

    /**
     * Test method for {@link fr.xebia.mowitnow.Direction#getLeft()}.
     */
    @Test
    public void testLeft() {
        assertEquals(Direction.N, Direction.E.getLeft());
        assertEquals(Direction.W, Direction.E.getLeft().getLeft());
        assertEquals(Direction.S, Direction.E.getLeft().getLeft().getLeft());
        assertEquals(Direction.E, Direction.E.getLeft().getLeft().getLeft().getLeft());
    }

    /**
     * Test method for {@link fr.xebia.mowitnow.Direction#getRight()}.
     */
    @Test
    public void testRight() {
        assertEquals(Direction.N, Direction.W.getRight());
        assertEquals(Direction.E, Direction.W.getRight().getRight());
        assertEquals(Direction.S, Direction.W.getRight().getRight().getRight());
        assertEquals(Direction.W, Direction.W.getRight().getRight().getRight().getRight());
    }

}
