package main;

import java.util.Scanner;
import java.util.Vector;  

public class boardGame {
    Scanner in = new Scanner(System.in);
    private String board[][] = { {"1", "2", "3"},{"4", "5", "6"},{"7", "8", "9"} };
    //the steps moved
    Vector<Integer> stepsMoved = new Vector<>(9);
    //check the move is right
    public int checkMove(int move){
        if(move < 1 || move > 9){
            System.out.println("ERROR. Please enter an valid number");
            System.out.println("Enter the number: ");
            move = in.nextByte();
            return checkMove(move);
        }
        for (int i = 0; i < stepsMoved.size(); i++) {
            if (stepsMoved.contains(move)){
                System.out.println("ERROR. Please enter an valid move");
                System.out.println("The move is alredy played");
                System.out.println("Enter the number: ");
                move = in.nextByte();
                return checkMove(move);
            }
        }
        return move;
    }
    //set the move
    public void setMove(int location, String symbol){
        stepsMoved.add(location);
        String move = String.valueOf(location);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(move.equals(board[i][j])){
                    board[i][j] = symbol;
                }
            }
        }
    }
    //print the board
    public void printBoard(){
        for (int i = 0; i < 3; i++) {
            System.out.print("| " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + " |");
            System.out.println("");
        }
    }
    //Check if there is a winner
    public boolean checkWinner(){
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
            case 0:
                line = board[0][0] + board[0][1] + board[0][2];
                break;
            case 1:
                line = board[1][0] + board[1][1] + board[1][2];
                break;
            case 2:
                line = board[2][0] + board[2][1] + board[2][2];
                break;
            case 3:
                line = board[0][0] + board[1][0] + board[2][0];
                break;
            case 4:
                line = board[0][1] + board[1][1] + board[2][1];
                break;
            case 5:
                line = board[0][2] + board[1][2] + board[2][2];
                break;
            case 6:
                line = board[0][0] + board[1][1] + board[2][2];
                break;
            case 7:
                line = board[0][2] + board[1][1] + board[2][0];
                break;
            }
            //For X winner
            if (line.equals("xxx")) {
                return true;
            }
            // For O winner
            else if (line.equals("ooo")) {
                return true;
            }
        }
        return false;
    }
    //check if there other move
    public boolean gameOver(){
        return stepsMoved.size() == 9;
    }
}
