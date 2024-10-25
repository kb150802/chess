package org.example;

import org.example.model.Board;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        board.printBoard();
        while(true) {
            String temp = scanner.next();
            if(temp.equals("EXIT")) {
                break;
            }
            String end = scanner.next();
            int[][] move = parseMove(temp, end);
            if(board.makeMove(move[0], move[1])) {
                board.printBoard();
            }
        }
    }
    private static int[][] parseMove(String start, String end) {
        int[] startMove = {8 - Integer.parseInt(""+start.charAt(1)) , start.charAt(0)-'a'};
        int[] endMove = {8 - Integer.parseInt(""+end.charAt(1)) , end.charAt(0)-'a'};
        return new int[][]{startMove, endMove};

    }
}



//f7 e8
//exit