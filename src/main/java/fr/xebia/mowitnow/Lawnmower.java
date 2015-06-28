/**
 * 
 */
package fr.xebia.mowitnow;

/**
 * @author Charles Dufour
 * 
 *         Defines a lawnmover : <br />
 *         - Its direction <br />
 *         - Its position <br />
 *         - The list of commands it has to run
 *
 */
public class Lawnmower {

    private Direction direction;
    private String commands;
    private Position position;

    /**
     * 
     * @param position
     *            Cannot be null
     * @param direction
     *            Cannot be null
     * @param commands
     */
    public Lawnmower(Position position, Direction direction, String commands) throws IllegalArgumentException {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }

        if (direction == null) {
            throw new IllegalArgumentException("Direction cannot be null");
        }

        this.position = position;
        this.direction = direction;
        this.commands = commands == null ? "" : commands;
    }

    /**
     * 
     * @param position
     *            Cannot be null
     * @param direction
     *            Cannot be null
     * @param commands
     */
    public Lawnmower(Position position, String direction, String commands) {
        this(position, Direction.getDirection(direction), commands);
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * @return the commands
     */
    public String getCommands() {
        return this.commands;
    }

    /**
     * @return the x
     */
    public int getX() {
        return this.position.getX();
    }

    /**
     * @return the y
     */
    public int getY() {
        return this.position.getY();
    }

    /**
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @param position
     *            the position to set
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Turns the lawnmower to the left.
     */
    public void turnLeft() {
        this.direction = this.direction.getLeft();
    }

    /**
     * Turns the lawnmower to the right.
     */
    public void turnRight() {
        this.direction = this.direction.getRight();
    }

    /**
     * Returns the direction as a relative position from the lawnmower.
     * 
     * @return
     */
    private Position getDirectionAsPostion() {
        switch (this.direction) {
        case N:
            return new Position(0, 1);
        case E:
            return new Position(1, 0);
        case S:
            return new Position(0, -1);
        case W:
            return new Position(-1, 0);
        default:
            return null;
        }
    }

    /**
     * Returns the "virtual" next position (after a move) based on the direction, without changing the current position.
     * No position validation is performed.
     * 
     * @return
     */
    public Position getNextPosition() {
        return getDirectionAsPostion().add(this.position);
    }

    /**
     * Move the lawnmower to the next position. <br />
     * Does not perform any position validation, this responsibility belongs to the lawn.
     * 
     */
    public void move() {
        this.position.add(getDirectionAsPostion());
    }

    @Override
    public String toString() {
        return this.getX() + " " + this.getY() + " " + this.getDirection();
    }
}
