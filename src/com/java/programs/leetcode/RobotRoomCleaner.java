package com.java.programs.leetcode;

class Direction {

    int row;
    int col;

    public Direction(int row, int col) {
        this.row = row;
        this.col = col;
    }

    void takeRight(){
        if(row == 0 && col == 1){
            this.row = 1;
            this.col = 0;
        } else if(row == 1 && col == 0){
            this.row = 0;
            this.col = -1;
        } else if(row == 0 && col == -1){
            this.row = -1;
            this.col = 0;
        } else if(row == -1 && col == 0){
            this.row = 0;
            this.col = 1;
        }
    }

}

public class RobotRoomCleaner {

    public int solution(String[] R) {
        // write your code in Java SE 8
        int count = 0;

        Character[][] room = convertInputTo2DArray(R);

        // starting point
        int i=0,j=0;
        // right direction
        Direction dir = new Direction(0,1);
        return moveRobot(room,i,j,dir);
    }

    private int moveRobot(Character[][] room, int i, int j, Direction dir) {

        int cleaned = cleanSpot(room,i,j);

        // exit condition : if a node is visited 4 times, then end it.
        if(Character.getNumericValue(room[i][j]) == 4){
            return cleaned;
        }

        int nextI = i+dir.row;
        int nextJ = j+dir.col;
        if(withinRoomBoundaries(room,nextI,nextJ) && room[nextI][nextJ] != 'X'){
            return cleaned + moveRobot(room,i+dir.row,j+dir.col,dir);
        } else {
            dir.takeRight();
            return cleaned + moveRobot(room,i,j,dir);
        }
    }

    private boolean withinRoomBoundaries(Character[][] room, int i, int j) {
        return (i >=0 && i<room.length &&
                j>=0 && j<room[0].length);
    }

    private int cleanSpot(Character[][] room, int i, int j) {
        if(room[i][j]=='.'){
            room[i][j] = '1';
            return 1;
        } else if(room[i][j]!='X'){
            int visited = Character.getNumericValue(room[i][j]);
            visited++;
            room[i][j] = Character.forDigit(visited, 10);
        }

        return 0;
    }

    private Character[][] convertInputTo2DArray(String[] R) {
        Character[][] twoDArray = new Character[R.length][R[0].length()];

        for (int i = 0; i < R.length; i++) {
            String row = R[i];
            for (int j = 0; j < row.length(); j++) {
                twoDArray[i][j] = row.charAt(j);
                System.out.print(twoDArray[i][j]+" ");
            }
            System.out.println();
        }
        return twoDArray;
    }

    public static void main(String[] args) {
        RobotRoomCleaner s = new RobotRoomCleaner();
        /*
            . . . X . .
            . . . . X X
            . . X . . .
         */
        String[] A = {"...X..", "....XX", "..X..."};
        System.out.println("Spot clean : "+s.solution(A));

        /*
            . . . X .
            . X . . X
            X . . . X
            . . X . .
         */
        String[] B = {"...X.", ".X..X", "X...X","..X.."};
        System.out.println("Spot clean : "+s.solution(B));


        /*
            . . . . X . .
            X . . . . . .
            . . . . . X .
            . . . . . . .
         */
        String[] C = {"....X..", "X......", ".....X.","......."};
        System.out.println("Spot clean : "+s.solution(C));
    }

}
