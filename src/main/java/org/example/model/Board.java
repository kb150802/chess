package org.example.model;

//BR BN BB BQ BK BB BN BR
//BP BP BP BP BP BP BP BP
//-- -- -- -- -- -- -- --
//-- -- -- -- -- -- -- --
//-- -- -- -- -- -- -- --
//-- -- -- -- -- -- -- --
//WP WP WP WP WP WP WP WP
//WR WN WB WQ WK WB WN WR

import org.example.movments.*;

import java.util.Arrays;

public class Board {
    private Piece[][] board;
    char turn ;
    public Board() {
        turn = 'W';
        board = new Piece[8][8];
        board[0][0] = new Piece("BR", new RookMovementStrategy());
        board[0][1] = new Piece("BN", new KnightMovementStrategy());
        board[0][2] = new Piece("BB", new BishopMovementStrategy());
        board[0][3] = new Piece("BQ", new QueenMovementStrategy());
        board[0][4] = new Piece("BK", new KingMovementStrategy());
        board[0][5] = new Piece("BB", new BishopMovementStrategy());
        board[0][6] = new Piece("BN", new KnightMovementStrategy());
        board[0][7] = new Piece("BR", new RookMovementStrategy());
        for(int i = 0; i < 8; ++i) {
            board[1][i] = new Piece("BP", new PawnMovementStrategy());
        }

        board[7][0] = new Piece("WR", new RookMovementStrategy());
        board[7][1] = new Piece("WN", new KnightMovementStrategy());
        board[7][2] = new Piece("WB", new BishopMovementStrategy());
        board[7][3] = new Piece("WQ", new QueenMovementStrategy());
        board[7][4] = new Piece("WK", new KingMovementStrategy());
        board[7][5] = new Piece("WB", new BishopMovementStrategy());
        board[7][6] = new Piece("WN", new KnightMovementStrategy());
        board[7][7] = new Piece("WR", new RookMovementStrategy());
        for(int i = 0; i < 8; ++i) {
            board[6][i] = new Piece("WP", new PawnMovementStrategy());
        }

    }

    public boolean makeMove(int[] start,int[] end) {
        if(isWrongMove(start,end)) {
            invalidMove();
            return false ;
        }
        int startX = start[0], startY = start[1];
        int endX = end[0], endY = end[1];
        Piece currentPiece = board[startX][startY];
        if(currentPiece == null) {
            invalidMove();
            return false;
        }
        if(currentPiece.isValidMove(start,end,board)) {
            System.out.println("Valid Move from " + startX + " " + startY + " to " + endX + " " + endY);
            board[endX][endY] = currentPiece;
            board[startX][startY] = null;
            turn = (char) (turn^('W'^'B'));
            return true;
        }
        invalidMove();
        return false;
    }
    private void invalidMove(){
        System.out.println("Invalid Move");
    }
    private boolean isWrongMove(int[] start,int[] end) {
        int startX = start[0], startY = start[1];
        int endX = end[0], endY = end[1];
        if(Math.max(Arrays.stream(start).max().getAsInt(), Arrays.stream(end).max().getAsInt()) > 7 ){
            return true;
        }
        if(Math.min(Arrays.stream(start).min().getAsInt(), Arrays.stream(end).min().getAsInt()) < 0) {
            return true;
        }
        if(board[startX][startY]==null) {
            return true;
        }
        if(board[endX][endY]!=null && board[startX][startY].getPieceName().charAt(0) == board[endX][endY].getPieceName().charAt(0)){
            return true;
        }
        if(board[startX][startY].getPieceName().charAt(0)!=turn){
            return true;
        }

        return  false;
    }

    public void printBoard() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                Piece piece = board[i][j];
                if(piece == null){
                    System.out.print("__ ");
                }else{
                    System.out.print(piece.getPieceName()+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
