/**
 * 
 */
package fr.xebia.mowitnow;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Charles Dufour
 *
 */
public class PositionTest {

    /**
     * Test method for {@link fr.xebia.mowitnow.Position#add(fr.xebia.mowitnow.Position)}.
     */
    @Test
    public void testAdd() {
        Position p1 = new Position();
        Position p2 = new Position(1, 2);

        p2.add(null);
        assertEquals(1, p2.getX());
        assertEquals(2, p2.getY());

        p1.add(p2);
        assertEquals(1, p1.getX());
        assertEquals(2, p1.getY());

        p1.add(p1);
        assertEquals(2, p1.getX());
        assertEquals(4, p1.getY());
    }

}
