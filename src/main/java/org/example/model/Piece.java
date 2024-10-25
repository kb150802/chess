package org.example.model;

import org.example.movments.MovementStrategy;

public class Piece {
    private String pieceName;
    private MovementStrategy movementStrategy;
    public Piece(String pieceName, MovementStrategy movementStrategy) {
        this.pieceName = pieceName;
        this.movementStrategy = movementStrategy;
    }
    public boolean isValidMove(int[] start,int[] end,Piece[][] board){
        return movementStrategy.isValidMove(start,end,board);
    }
    public String getPieceName() {
        return pieceName;
    }

}


