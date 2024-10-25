package org.example.movments;

import org.example.model.Piece;

public class PawnMovementStrategy implements MovementStrategy{
    boolean isFirstMove;
    public PawnMovementStrategy(){
        isFirstMove = true;
    }
    @Override
    public boolean isValidMove(int[] start, int[] end, Piece[][] board) {
        int startX=start[0],startY = start[1];
        int endX=end[0],endY=end[1];
        Piece piece = board[startX][startY];
        int xDirection = piece.getPieceName().charAt(0)=='W'?-1:1;
        if(startY==endY) {
            if(endX == startX + xDirection && board[endX][endY] == null){
                isFirstMove = false;
                return true;
            }
            else if(isFirstMove && endX == startX + 2* xDirection && board[startX + xDirection][startY] == null && board[endX][endY] == null){
                isFirstMove = false;
                return true;
            }
        }else if(Math.abs(startX-endX) == 1 && endX == startX + xDirection && board[endX][endY]!=null){
            isFirstMove = false;
            return true;
        }
        return false;
    }
}
