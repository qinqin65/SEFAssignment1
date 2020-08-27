import Game.*;

public class Utils {
    public static int abs(int x) {
        if (x >= 0) return x;
        else return -x;
    }

    public static int min(int x, int y, int z) {
        if ( x <= y && x <= z) return x;
        if ( y <= z && y <= x) return y;
        return z;
    }

    public static int distance(Position from, Position to) {
        int d = 0;
        // compute minimum horizontal distance:  
        if ( from.y == to.y) d += abs(to.x-from.x);
        else d += min(from.x+to.x, abs(from.x-5) + abs(to.x-5) , abs(from.x-10) + abs(to.x-10));

        // compute minimum vertical distance as follows:  
        if ( from.x == to.x) d += abs(to.y-from.y);
        else d += min(from.y+to.y, abs(from.y-5) + abs(to.y-5) , abs(from.y-10) + abs(to.y-10));
        return d;
    }
}
