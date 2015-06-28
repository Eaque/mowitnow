/**
 * 
 */
package fr.xebia.mowitnow;

/**
 * @author Charles Dufour
 * 
 *         Defines a direction and some methods used to go from a direction to another.
 *
 */
public enum Direction {
    N, E, S, W;

    /**
     * Gets a direction from a String. The String must be one character matching a cardinal direction: "N", "E", "W" or
     * "S".
     * 
     * @param dir
     *            String representing the cardinal direction.
     * @return The corresponding direction enum, null otherwise.
     */
    public static Direction getDirection(String dir) {
        if (dir == null) {
            return null;
        }

        switch (dir) {
        case "N":
            return N;
        case "E":
            return E;
        case "S":
            return S;
        case "W":
            return W;
        default:
            return null;
        }
    }

    /**
     * Gets the cardinal direction after a left rotation of 90° from the current direction.
     * 
     * @return
     */
    public Direction getLeft() {
        switch (this) {
        case N:
            return Direction.W;
        case E:
            return Direction.N;
        case S:
            return Direction.E;
        case W:
            return Direction.S;
        default:
            return null;
        }
    }

    /**
     * Gets the cardinal direction after a left rotation of 90° from the current direction.
     * 
     * @return
     */
    public Direction getRight() {
        switch (this) {
        case N:
            return Direction.E;
        case E:
            return Direction.S;
        case S:
            return Direction.W;
        case W:
            return Direction.N;
        default:
            return null;
        }
    }
}
