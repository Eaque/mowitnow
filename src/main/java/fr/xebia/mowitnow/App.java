package fr.xebia.mowitnow;

/**
 * @author Charles Dufour
 * 
 *         Main class of mowitnow.
 *
 */
public class App {
    public static void main(String[] args) {
        Lawn lawn = null;

        if (args.length > 0) {
            lawn = LawnCreator.createLawn(args[0]);
        } else {
            lawn = LawnCreator.createLawn(System.in);
        }

        if (lawn != null) {
            lawn.mow();
            System.out.println(lawn);
        }
    }
}
