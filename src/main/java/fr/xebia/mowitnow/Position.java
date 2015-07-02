/**
 * 
 */
package fr.xebia.mowitnow;

/**
 * Defines a position on the lawn.
 * 
 * @author Charles Dufour
 */
public final class Position {

    private int x;
    private int y;

    /**
     * @param x
     * @param y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x
     *            the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y
     *            the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Adds a position to the current one. Also returns this new position.
     * 
     * @param p
     *            The position to add
     * @return The new position.
     */
    public Position add(Position p) {
        if (p != null) {
            this.x += p.getX();
            this.y += p.getY();
        }
        return this;
    }
}
