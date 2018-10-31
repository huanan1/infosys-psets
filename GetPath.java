import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;


/* Instructions
 *  Robot starts at (0,0), attempts to move to (r,c)
 *  Can only move right/down
 *  Some spots are blocked (indicated by a 1 on the grid)
 * */

class Point {
    int x;
    int y;

    Point (int x, int y) {
        this.x=x;
        this.y=y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
public class GetPath {

    public static boolean getPath(int r, int c, ArrayList<Point> path, final int[][] grid) {
        //immediate false cases: outside grid and destination is on a blocked spot
        if(r<0 || r>grid.length || c<0 || c>grid[0].length ||grid[r][c] ==1) return false;

        path.add(new Point(r,c));
        //establish base case
        if (r==0 && c==0){
            Collections.reverse(path);
            return true;
        }
        //recursively try to move up, when it fails, try to move left
        //if either gives a true then a path can be found, else it cannot
        return getPath(r-1,c,path,grid) || getPath(r,c-1,path,grid);
    }

    public static void main(String[] args) {
        final int[][] grid0 = {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}
        };


        ArrayList<Point> path = new ArrayList<>();

        boolean success = GetPath.getPath(3, 2, path, grid0);

        System.out.println(success);
        if (success)
            System.out.println(path);
        path.clear();


        final int[][] grid = {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 1},
                {0, 1, 0, 0}
        };

        success = GetPath.getPath(3, 2, path, grid);

        System.out.println(success);
        if (success)
            System.out.println(path);
        path.clear();
    }
}