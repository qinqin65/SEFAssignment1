package Game;

public class Monster extends Role {
    private Map map;
    private Player[] players;

    public Monster(Map map, Player[] players, int x, int y) {
        this.map = map;
        this.players = players;
        this.currentPosition = new Position(x, y);
    }

    private boolean inBetween(int val, int a, int b) {
        if (val >= a && val <= b) {
            return true;
        } else {
            return false;
        }
    }

    public char getBestDirection(Position from, Position to) {
        if (from.y == to.y)
        {
            if (from.x < to.x)
                return 'R';
            else if (from.x > to.x)
                return 'L';
        }
        else if (from.x == to.x)
        {
            if (from.y < to.y)
                return 'D';
            else if (from.y > to.y)
                return 'U';
        }

        int row = to.y;
        int col = to.x;

        if (inBetween(to.y %5, 1,2))
            row = to.y/5*5;
        else if (inBetween(to.y %5, 3,4))
            row = to.y/5*5 + 5;
        if (inBetween(to.x %5, 1,2))
            col = to.x/5*5;
        else if (inBetween(to.x %5, 3,4))
            col = to.x/5*5 + 5;


        if (from.y % 5 == 0)
            if (from.x < col)
                return 'R';
            else if (from.x > col)
                return 'L';
        if (from.x %5 == 0)
            if (from.y < row)
                return 'D';
            else if (from.y > row)
                return 'U';
        return ' ';
    }

    @Override
    public Position move() {
        Player player = players[0];
        currentDirection = this.getBestDirection(currentPosition, player.getPosition());
        currentPosition = map.getCell(getPosition(), getDirection());
        return currentPosition;
    }
}
