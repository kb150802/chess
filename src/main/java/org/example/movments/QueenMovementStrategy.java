package org.example.movments;

import org.example.model.Piece;

public class QueenMovementStrategy implements MovementStrategy{
    private final MovementStrategy bishopMovementStrategy = new BishopMovementStrategy();
    private final MovementStrategy rookMovementStrategy = new RookMovementStrategy();
    @Override
    public boolean isValidMove(int[] start, int[] end, Piece[][] board) {
        return bishopMovementStrategy.isValidMove(start,end,board) || rookMovementStrategy.isValidMove(start,end,board);
    }
}
