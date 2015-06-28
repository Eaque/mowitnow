/**
 * 
 */
package fr.xebia.mowitnow;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.io.InputStream;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import fr.xebia.mowitnow.exception.FileContentException;

/**
 * @author Charles Dufour
 *
 */
public class LawnCreatorTest {

    /**
     * Test method for {@link fr.xebia.mowitnow.LawnCreator#createLawn(java.io.InputStream)}.
     * 
     * @throws FileContentException
     */
    @Test
    public void testCreateLawnConfigurationInputStream() throws FileContentException {
        InputStream stream = null;
        assertNull(LawnCreator.createLawn(stream));
    }

    /**
     * Test method for {@link fr.xebia.mowitnow.LawnCreator#createLawn(java.lang.String)}.
     * 
     * @throws FileContentException
     */
    @Test
    public void testCreateLawnConfigurationString() throws FileContentException {
        Lawn lawn = LawnCreator.createLawn("5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA");
        lawn.mow();

        assertThat(lawn.toString(), CoreMatchers.startsWith("1 3 N\n5 1 E"));
    }

}
