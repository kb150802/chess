package org.example.movments;

import org.example.model.Piece;

public class KingMovementStrategy implements MovementStrategy{
    @Override
    public boolean isValidMove(int[] start, int[] end, Piece[][] board) {
        int startX = start[0], startY = start[1];
        int endX = end[0], endY = end[1];
        return Math.abs(startX - endX) <= 1 && Math.abs(startY - endY) <= 1;
    }
}
