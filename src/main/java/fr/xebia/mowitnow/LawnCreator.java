/**
 * 
 */
package fr.xebia.mowitnow;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author Charles Dufour
 * 
 *         Class allowing to create a lawn from a stream, a file or a string. The input stream must follow the
 *         specification. <br />
 *         This class is the entry point.
 *
 */
public final class LawnCreator {

    /**
     * Creates a lawn from a stream containg the configuration.
     * 
     * @param is
     * @return The created lawn, null if a problem occurs.
     */
    public static Lawn createLawn(InputStream is) {
        if (is == null) {
            return null;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        try {
            String[] dimensions = br.readLine().split(" ");
            Lawn lawn = new Lawn(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));

            String position;
            String[] positions;
            String commands;

            while ((position = br.readLine()) != null) {
                positions = position.split(" ");
                commands = br.readLine();
                lawn.addLawnmower(Integer.parseInt(positions[0]), Integer.parseInt(positions[1]), positions[2],
                        commands);
            }
            return lawn;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates a lawn from a string representing the configuration. See
     * {@link fr.xebia.mowitnow.LawnCreator#createLawn(java.io.InputStream)}
     * 
     * @param configuration
     * @return
     */
    public static Lawn createLawn(String configuration) {
        return createLawn(new ByteArrayInputStream(configuration.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * Creates a lawn from a file containg the configuration. See
     * {@link fr.xebia.mowitnow.LawnCreator#createLawn(java.io.InputStream)}
     * 
     * @param file
     * @return
     */
    public static Lawn createLawn(File file) {
        try {
            return createLawn(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
