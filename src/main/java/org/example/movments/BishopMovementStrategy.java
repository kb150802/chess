package org.example.movments;

import org.example.model.Piece;

public class BishopMovementStrategy implements MovementStrategy{
    @Override
    public boolean isValidMove(int[] start, int[] end, Piece[][] board) {
        int startX = start[0],startY = start[1];
        int endX = end[0], endY = end[1];
        if(!((startX-startY)==(endX-endY)) && !((startX+startY)==(endX+endY))) {
            return false;
        }
        int xMove = Integer.compare(endX,startX);
        int yMove = Integer.compare(endY,startY);
        int currentX = startX + xMove,currentY = startY + yMove;
        while(currentX!=endX || currentY!=endY){
            if(board[currentX][currentY]!=null){
                return false;
            }
            currentX = currentX + xMove;
            currentY = currentY + yMove;
        }
        return true;
    }
}
