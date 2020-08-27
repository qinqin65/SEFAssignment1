package Game;

public abstract class Role {
    protected char currentDirection;
    protected Position currentPosition;
    protected Map map;

    public void setDirection(char d) {
        currentDirection = d;
    }

    public char getDirection() {
        return currentDirection;
    }

    public void setPosition(Position c) {
        currentPosition = c;
    }

    public Position getPosition() {
        return currentPosition;
    }

    public abstract Position move();
}
