/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yourmazewithpath2;

import java.util.*;
import java.awt.Point;
import java.util.LinkedList;

public class YourMazeWithPath2
{       
    private InputGraphicMaze2 maze;
    private int R, C; 
    private boolean [][]V;
    public YourMazeWithPath2() 
    {       
       // an R rows x C columns maze
       maze = new InputGraphicMaze2();
       R=maze.Rows(); C=maze.Cols();
       // initialize the Array
       V=new boolean [R][C];
       
       
       // Path holds the cells of the path
       LinkedList<Point> Path = new LinkedList<Point>();
       // Create the path
       CreatePath(maze, 1, 1, R, C, Path);
       // show the path in the maze
       maze.showPath(Path);
    }

    // Creates the path through maze, starting at cell (srow, scol)
    // and ending at cell (erow and ecol),  in L
    //While the path returns true values it will continue through the DFS
    public boolean CreatePath(InputGraphicMaze2 maze,      
      int srow, int scol, int erow, int ecol, LinkedList<Point> L)
    {
        //add point to linked list
        L.push(new Point(srow, scol));
        //Set visited slot to true
        V[srow-1][scol-1] = true;
      //if starting location is current location then true
        if(srow == erow && scol == ecol)
            return true;
        // check up 
         if(srow > 1 && !V[srow-2][scol-1] && maze.can_go(srow, scol, 'U') &&
                CreatePath(maze, srow-1, scol, erow, ecol, L))
            return true;
         //check down
         if(srow < R && !V[srow][scol-1] && maze.can_go(srow, scol, 'D') &&
                CreatePath(maze, srow+1, scol, erow, ecol, L))
            return true;
         //check right
        if(scol < C && !V[srow-1][scol] && maze.can_go(srow, scol, 'R') &&
                CreatePath(maze, srow, scol+1, erow, ecol, L))
            return true;
       //check left
        if(scol > 1 && !V[srow-1][scol-2] && maze.can_go(srow, scol, 'L') &&
                CreatePath(maze, srow, scol-1, erow, ecol, L))
            return true;
       //return false if conditions are not met and you cannot move
        else 
        {L.pop();
        return false;}
    }

    public static void main(String[] args)
    {new YourMazeWithPath2();}
}