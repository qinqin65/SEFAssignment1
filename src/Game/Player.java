package Game;

public class Player extends Role {
    private boolean readyToStart;

    public Player(Map map, int x, int y) {
        this.currentPosition = new Position(x, y);
        this.map = map;
        this.readyToStart = true;
    }

    public boolean isReady() {
        return readyToStart;
    }

    @Override
    public Position move() {
        this.currentPosition = map.getCell(currentPosition, currentDirection);
        return this.currentPosition;
    }

    public void setReady(boolean val) {
        readyToStart = val;
    }
}
