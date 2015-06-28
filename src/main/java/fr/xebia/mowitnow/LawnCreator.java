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

import fr.xebia.mowitnow.exception.FileContentException;

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
     * Creates a lawn from a stream containing the configuration.
     * 
     * @param is
     * @return The created lawn, null if a problem occurs.
     */
    public static Lawn createLawn(InputStream is) throws FileContentException {
        if (is == null) {
            return null;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        try {
            String dimension = br.readLine();
            if (dimension == null) {
                throw new FileContentException("Stream is empty !");
            }
            String[] dimensions = dimension.split(" ");
            if (dimensions.length != 2) {
                throw new FileContentException("Wrong lawn dimensions (must be two integers)");
            }

            Lawn lawn;
            try {
                lawn = new Lawn(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));
            } catch (NumberFormatException e) {
                throw new FileContentException("Wrong lawn dimensions (must be two integers)");
            }

            String position;
            String[] positions;
            String commands;
            while ((position = br.readLine()) != null) {
                positions = position.split(" ");
                commands = br.readLine();
                try {
                    lawn.addLawnmower(Integer.parseInt(positions[0]), Integer.parseInt(positions[1]), positions[2],
                            commands);
                } catch (NumberFormatException e) {
                    throw new FileContentException("Wrong lawnmower position (must be two integers)");
                }
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
     * {@link fr.xebia.mowitnow.LawnCreator#createLawn(java.io.InputStream)} <br />
     * The string must be encoded in 'utf-8'
     * 
     * @param configuration
     * @return
     */
    public static Lawn createLawn(String configuration) throws FileContentException {
        return createLawn(new ByteArrayInputStream(configuration.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * Creates a lawn from a file containing the configuration. See
     * {@link fr.xebia.mowitnow.LawnCreator#createLawn(java.io.InputStream)}
     * 
     * @param file
     * @return
     * @throws FileNotFoundException
     *             If the file does not exist
     */
    public static Lawn createLawn(File file) throws FileNotFoundException, FileContentException {
        return createLawn(new FileInputStream(file));
    }
}
