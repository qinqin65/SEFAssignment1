package Game;

public class Map {
    private Position[][] cells = new Position[11][11];

    public Map() {
        for (int i=0; i<11; i++) {
            for (int j=0; j<11; j++) {
                this.cells[i][j] = new Position(i,j);
            }
        }
    }

    public Position getCell(int row, int col) throws Exception {
        if ((row %5 != 0 && col %5 != 0) ||
                row < 0 || row > 10 || col < 0 || col > 10)
            throw new Exception("Invalid Coordiantes row = " + row + " column " + col);
        return cells[row][col];
    }

    public Position getCell(Position cell, char direction) {
        if (direction == ' ') return cell;
        if (direction == 'U') {
            if (cell.x %5 == 0 && cell.y >0)
                return cells[cell.y-1][cell.x];
            return cell;
        }
        else if (direction == 'D') {
            if (cell.x %5 == 0 && cell.y <10)
                return cells[cell.y+1][cell.x];
            return cell;
        }
        else if (direction == 'L') {
            if (cell.y %5 == 0 && cell.x >0)
                return cells[cell.y][cell.x-1];
            return cell;
        }
        else if (direction == 'R') {
            if (cell.y %5 == 0 && cell.x <10)
                return cells[cell.y][cell.x+1];
            return cell;
        }
        return null;
    }

    public Position[][] getAllCells() {
        return cells;
    }
}
