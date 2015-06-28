/**
 * 
 */
package fr.xebia.mowitnow;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.io.InputStream;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

/**
 * @author Charles
 *
 */
public class LawnCreatorTest {

    /**
     * Test method for {@link fr.xebia.mowitnow.LawnCreator#createLawn(java.io.InputStream)}.
     */
    @Test
    public void testCreateLawnConfigurationInputStream() {
        InputStream stream = null;
        assertNull(LawnCreator.createLawn(stream));
    }

    /**
     * Test method for {@link fr.xebia.mowitnow.LawnCreator#createLawn(java.lang.String)}.
     */
    @Test
    public void testCreateLawnConfigurationString() {
        Lawn lawn = LawnCreator.createLawn("5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA");
        lawn.mow();

        assertThat(lawn.toString(), CoreMatchers.startsWith("1 3 N\n5 1 E"));
    }

}
