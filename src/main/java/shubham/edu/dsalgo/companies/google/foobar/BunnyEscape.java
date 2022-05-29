package shubham.edu.dsalgo.companies.google.foobar;

import java.util.HashMap;

public class BunnyEscape {
    static int MAX_VALUE;
    static int interpolate(int x, int y, int gridSize) {
        return x * gridSize + y;
    }
    public static int solution(int[][] map){
        if(map.length == 1){
            return map[0].length;
        }

        if (map[0].length == 1){
            return map.length;
        }

        MAX_VALUE = map.length * map[0].length + 1;
        return move(false,1, map, 0, 0, map.length, map[0].length);
    }

    public static int moveWithMap(boolean removedWall, int movesSoFar, int[][] maze, int x, int y, int mazeLength, HashMap<String, Integer> hm){
        if(mazeLength - 1 ==  x && mazeLength - 1 == y){
            return movesSoFar;
        } else {
            if(removedWall){
                if(x + 1 < mazeLength && y + 1 < mazeLength){
                    return Math.min(
                            maze[x + 1][y] == 1 ? MAX_VALUE : moveWithMap(removedWall, movesSoFar + 1, maze, x + 1, y, mazeLength, hm),
                            maze[x][y + 1] == 1 ? MAX_VALUE : moveWithMap(removedWall, movesSoFar + 1, maze, x, y + 1,mazeLength, hm)
                    );
                } else if(y + 1 == mazeLength && x + 1 < mazeLength){
                    return maze[x + 1][y] == 1 ? MAX_VALUE : moveWithMap(removedWall, movesSoFar + 1, maze, x + 1, y, mazeLength,hm);
                } else if(x + 1 == mazeLength && y + 1 < mazeLength){
                    return maze[x][y + 1] == 1 ? MAX_VALUE : moveWithMap(removedWall, movesSoFar + 1, maze, x, y + 1,mazeLength, hm);
                } else {
                    System.out.println("Some thing not right");
                    System.out.println(x);
                    System.out.println(y);
                    return movesSoFar;
                }
            } else {
                if(x + 1 < mazeLength && y + 1 < mazeLength) {

                    return Math.min(moveWithMap(maze[x + 1][y] == 1, movesSoFar + 1, maze, x + 1, y,mazeLength, hm),
                            moveWithMap(maze[x][y + 1] == 1, movesSoFar + 1, maze, x, y + 1,mazeLength, hm)
                    );
                } else if(x + 1 == mazeLength && y + 1 < mazeLength){
                    return moveWithMap(maze[x][y + 1] == 1, movesSoFar + 1, maze, x, y + 1,mazeLength, hm);
                } else if(y + 1 == mazeLength && x + 1 < mazeLength){
                    return moveWithMap(maze[x + 1][y] == 1, movesSoFar + 1, maze, x + 1, y,mazeLength, hm);
                } else {
                    System.out.println("Some thing not right");
                    System.out.println(x);
                    System.out.println(y);
                    return movesSoFar;
                }
            }
        }
    }

    public static int move(boolean removedWall, int movesSoFar, int[][] maze, int x, int y, int rowL, int colL){
//        System.out.println("Rec call s "+ (++recCall));
//        System.out.println("Visiting { x : " + x + ", y : "+ y +"}  Moves = "+movesSoFar);
        if(rowL - 1 ==  x && colL - 1 == y){
            return movesSoFar;
        } else {
            if(removedWall){
                if(x + 1 < rowL && y + 1 < colL){
                    return Math.min(
                            maze[x + 1][y] == 1 ? MAX_VALUE : move(removedWall, movesSoFar + 1, maze, x + 1, y, rowL, colL),
                            maze[x][y + 1] == 1 ? MAX_VALUE : move(removedWall, movesSoFar + 1, maze, x, y + 1,  rowL, colL)
                    );
                } else if(y + 1 == colL && x + 1 < rowL){
                    return maze[x + 1][y] == 1 ? MAX_VALUE : move(removedWall, movesSoFar + 1, maze, x + 1, y,  rowL, colL);
                } else if(x + 1 == rowL && y + 1 < colL){
                    return maze[x][y + 1] == 1 ? MAX_VALUE : move(removedWall, movesSoFar + 1, maze, x, y + 1,  rowL, colL);
                } else {
                    System.out.println("Some thing not right");
                    System.out.println(x);
                    System.out.println(y);
                    return movesSoFar;
                }
            } else {
                if(x + 1 < rowL && y + 1 < colL){
                    return Math.min(move(maze[x + 1][y] == 1, movesSoFar + 1, maze, x + 1, y,  rowL, colL),
                                    move(maze[x][y + 1] == 1, movesSoFar + 1, maze, x, y + 1,  rowL, colL)
                    );
                } else if(x + 1 == rowL && y + 1 < colL){
                    return move(maze[x][y + 1] == 1, movesSoFar + 1, maze, x, y + 1,  rowL, colL);
                } else if(y + 1 == rowL && x + 1 < colL){
                    return move(maze[x + 1][y] == 1, movesSoFar + 1, maze, x + 1, y,  rowL, colL);
                } else {
                    System.out.println("Some thing not right");
                    System.out.println(x);
                    System.out.println(y);
                    return movesSoFar;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                new int[]{0,1,0,0},
                new int[]{0,0,1,0},
                new int[]{1,0,1,0},
                new int[]{1,1,0,0},
        };
//
        int[][]  grid2 = {
                new int[]{0, 1, 1, 0},
                new int[]{0, 0, 0, 1},
                new int[]{1, 1, 0, 0},
                new int[]{1, 1, 1, 0}};

//
        int[][] grid3 = {{0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}};
        int[][] grid4 = {{0, 0, 0,}, {1, 0, 1}, {1, 1, 0}};
        int[][] grid5 = {{0, 0}, {1, 0}};
        int[][] grid6 = {{0}, {1}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}};
        int[][] grid7 = {{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}};


//        System.out.println(solution(grid1));
        System.out.println("\n");
//        System.out.println(solution(grid2));
        System.out.println("\n");
//        System.out.println(solution(grid3));
        System.out.println("\n");
//        System.out.println(solution(grid4));
        System.out.println("\n");
//        System.out.println(solution(grid5));
        System.out.println("\n");
        System.out.println(solution(grid6));
        System.out.println(solution(grid7));





    }
}
