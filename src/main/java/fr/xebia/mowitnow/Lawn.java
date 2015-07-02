/**
 * 
 */
package fr.xebia.mowitnow;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a lawn : <br>
 * - Defines the size of the lawn and contains a list of lawnmowers. <br>
 * - Also handles the validation of the lawnmowers moves.
 * 
 * @author Charles Dufour
 *
 */
public final class Lawn {

    private int width;
    private int height;

    private List<Lawnmower> lawnmowers;

    /**
     * @param width
     *            Must be positive
     * @param height
     *            Must be positive
     */
    public Lawn(int width, int height) throws IllegalArgumentException {
        if (width <= 0) {
            throw new IllegalArgumentException("width must be positive");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("height must be positive");
        }

        this.width = width;
        this.height = height;

        this.lawnmowers = new ArrayList<Lawnmower>();
    }

    /**
     * Adds a lawnmower on the lawn. <br>
     * It must be added on an empty spot, and on the lawn (not out of bounds).
     * 
     * @param x
     *            x position
     * @param y
     *            y position
     * @param direction
     *            cardinal direction
     * @param commands
     */
    public void addLawnmower(int x, int y, String direction, String commands) throws IllegalArgumentException {
        if (x > width || x < 0) {
            throw new IllegalArgumentException("x is out of bounds. Max x is : " + this.width);
        }
        if (y > height || y < 0) {
            throw new IllegalArgumentException("y is out of bounds. Max y is : " + this.height);
        }

        for (Lawnmower lawnmower : lawnmowers) {
            if (lawnmower.getX() == x && lawnmower.getY() == y) {
                throw new IllegalArgumentException("There already is a lawnmower on this spot");
            }
        }

        this.lawnmowers.add(new Lawnmower(new Position(x, y), direction, commands));
    }

    /**
     * @return the lawnmowers
     */
    public List<Lawnmower> getLawnmowers() {
        return lawnmowers;
    }

    /**
     * Tests if the next position for a given lawnmower is valid on the current lawn. <br>
     * A position is considered valid if : <br>
     * - The position is on the lawn <br>
     * - The position is not taken by another lawnmower.
     * 
     * @param lawnmower
     * @return
     */
    private boolean isNextPositionValid(Lawnmower lawnmower) {
        Position position = lawnmower.getNextPosition();
        if (position.getX() > width || position.getX() < 0 || position.getY() > height || position.getY() < 0) {
            return false;
        }

        for (Lawnmower l : lawnmowers) {
            // Pointer comparison
            // If the current lawnmower is the one passed in parameters, checking position is useless.
            if (l == lawnmower) {
                continue;
            }

            if (l.getX() == position.getX() && l.getY() == position.getY()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Runs a command for the given lawnmower. <br>
     * The available commands are : <br>
     * - 'A' : Move (only if the move is valid, otherwise do nothing) <br>
     * - 'G' : Turn left <br>
     * - 'D' : Turn right <br>
     * If the given command doesn't exists, do nothing.
     * 
     * @param lawnmower
     * @param command
     */
    private void runCommand(Lawnmower lawnmower, char command) {
        switch (command) {
        case 'A':
            // Check if the next position is valid. If not, do nothing.
            if (isNextPositionValid(lawnmower)) {
                lawnmower.move();
            }
            break;
        case 'G':
            lawnmower.turnLeft();
            break;
        case 'D':
            lawnmower.turnRight();
        default:
            break;
        }
    }

    /**
     * Runs the commands recorded in the lawnmower (injected when the lawnmower was created).
     * 
     * @param lawnmower
     */
    private void runCommands(Lawnmower lawnmower) {
        String commands = lawnmower.getCommands();
        for (int i = 0; i < commands.length(); i++) {
            runCommand(lawnmower, commands.charAt(i));
        }
    }

    /**
     * Runs the recorded commands for all the lawnmovers sequentially.
     */
    public void mow() {
        for (Lawnmower lawnmower : lawnmowers) {
            runCommands(lawnmower);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lawnmower lawnmower : lawnmowers) {
            sb.append(lawnmower.toString() + '\n');
        }
        return sb.toString();
    }
}
