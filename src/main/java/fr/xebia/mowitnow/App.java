package fr.xebia.mowitnow;

import java.io.File;
import java.io.FileNotFoundException;

import fr.xebia.mowitnow.exception.FileContentException;

/**
 * Main class of mowitnow.
 * 
 * @author Charles Dufour
 *
 */
public class App {
    public static void main(String[] args) {
        Lawn lawn = null;

        // You can either pass a file as an argument or directly pass the file as the standard input stream.
        if (args.length > 0) {
            try {
                lawn = LawnCreator.createLawn(new File(args[0]));
            } catch (FileContentException e) {
                e.printStackTrace();
                System.err.println(e.getContentIssue());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                lawn = LawnCreator.createLawn(System.in);
            } catch (FileContentException e) {
                e.printStackTrace();
                System.err.println(e.getContentIssue());
            }
        }

        /**
         * If an error occurs, do nothing.
         */
        if (lawn != null) {
            lawn.mow();
            System.out.println(lawn);
        }
    }
}
