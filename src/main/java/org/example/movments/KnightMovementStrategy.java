package org.example.movments;

import org.example.model.Piece;

public class KnightMovementStrategy implements MovementStrategy{
    @Override
    public boolean isValidMove(int[] start, int[] end, Piece[][] board) {
        int startX = start[0], startY = start[1];
        int endX = end[0], endY = end[1];
        int absX = Math.abs(startX-endX);
        int absY = Math.abs(startY-endY);
        return (absX==1 && absY==2) || (absX==2 && absY == 1);
    }
}
