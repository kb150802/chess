package org.example.movments;

import org.example.model.Piece;

public interface MovementStrategy {
    boolean isValidMove(int[] start,int[] end, Piece[][] board);
}
