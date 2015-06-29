/**
 * 
 */
package fr.xebia.mowitnow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Charles Dufour
 *
 */
public class LawnTest {

    private Lawn lawn;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        lawn = new Lawn(10, 10);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        lawn = null;
    }

    /**
     * Test method for {@link fr.xebia.mowitnow.Lawn#Lawn(int, int)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testLawn1() {
        new Lawn(-1, 2);
    }

    /**
     * Test method for {@link fr.xebia.mowitnow.Lawn#Lawn(int, int)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testLawn2() {
        new Lawn(2, 0);
    }

    /**
     * Test method for {@link fr.xebia.mowitnow.Lawn#addLawnmower(int, int, java.lang.String, java.lang.String)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddLawnmower1() {
        lawn.addLawnmower(-1, 2, "E", "");
    }

    /**
     * Test method for {@link fr.xebia.mowitnow.Lawn#addLawnmower(int, int, java.lang.String, java.lang.String)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddLawnmower2() {
        lawn.addLawnmower(2, 11, "E", "");
    }

    /**
     * Test method for {@link fr.xebia.mowitnow.Lawn#addLawnmower(int, int, java.lang.String, java.lang.String)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddLawnmower3() {
        lawn.addLawnmower(2, 2, "E", "");
        lawn.addLawnmower(2, 2, "N", "");
    }

    /**
     * Test method for {@link fr.xebia.mowitnow.Lawn#addLawnmower(int, int, java.lang.String, java.lang.String)}.
     */
    @Test
    public void testAddLawnmower4() {
        assertEquals(0, lawn.getLawnmowers().size());

        lawn.addLawnmower(1, 1, "N", "AAAAA");
        assertEquals(1, lawn.getLawnmowers().size());
        assertEquals(Direction.N, lawn.getLawnmowers().get(0).getDirection());
        assertEquals("AAAAA", lawn.getLawnmowers().get(0).getCommands());
    }

    /**
     * Basic test 1
     * 
     * Test method for {@link fr.xebia.mowitnow.Lawn#mow()}.
     */
    @Test
    public void testRun1() {
        lawn.addLawnmower(1, 1, "N", "AAAAAGGG");
        lawn.mow();
        assertThat(lawn.toString(), CoreMatchers.startsWith("1 6 E"));
    }

    /**
     * Basic test 2
     * 
     * Test method for {@link fr.xebia.mowitnow.Lawn#mow()}.
     */
    @Test
    public void testRun2() {
        lawn.addLawnmower(9, 10, "N", "AAADA");
        lawn.addLawnmower(5, 5, "W", "AZERTYA");
        lawn.mow();
        assertThat(lawn.toString(), CoreMatchers.startsWith("10 10 E\n3 5"));
    }

    /**
     * Complex test 1 (out of bounds / collision with another lawnmower)
     * 
     * Test method for {@link fr.xebia.mowitnow.Lawn#mow()}.
     */
    @Test
    public void testRun3() {
        lawn.addLawnmower(1, 1, "N", "ADAAAAAAGA");
        lawn.addLawnmower(2, 2, "N", "A");
        lawn.addLawnmower(10, 10, "S", "AAAAAAAAAAAAAAAAAAAAAA");
        lawn.addLawnmower(5, 5, "W", "");
        lawn.mow();
        assertThat(lawn.toString(), CoreMatchers.startsWith("1 3 N\n2 3 N\n10 0 S\n5 5 W"));
    }

    /**
     * Complex test 2 (out of bounds / collision with another lawnmower)
     * 
     * Test method for {@link fr.xebia.mowitnow.Lawn#mow()}.
     */
    @Test
    public void testRun4() {
        lawn.addLawnmower(4, 4, "N", "AAAAAAAAAAAAAAAAAAAAAA");
        lawn.addLawnmower(5, 5, "E", "AAAAAAAAAAAAAAAAAAAAAA");
        lawn.addLawnmower(8, 8, "S", "AAAAAAAAAAAAAAAAAAAAAA");
        lawn.addLawnmower(7, 1, "W", "AAAAAAAAAAAAAAAAAAAAAA");
        lawn.addLawnmower(0, 1, "W", "AAADDAAGA");
        lawn.mow();
        assertThat(lawn.toString(), CoreMatchers.startsWith("4 10 N\n10 5 E\n8 0 S\n1 1 W\n0 2 N"));
    }
}
