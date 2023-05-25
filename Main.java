package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boardGame Board;
        Board = new boardGame();
        System.out.println("Welcome to XO game.");
        player p1, p2;
        p1 = new player();
        p2 = new player();
        System.out.println("Enter the first player's name: ");
        String name = in.next();
        p1.setName(name);
        p1.setSymbol("x");
        System.out.println("Enter the second player's name: ");
        name = in.next();
        p2.setName(name);
        p2.setSymbol("o");
        int a = 0, move;
        while (Board.gameOver() == false && Board.checkWinner() == false){
            switch(a){
                case(0):
                    System.out.println(p1.getName() + "'s Turn");
                    Board.printBoard();
                    System.out.println("Enter your Move: ");
                    move = in.nextInt();
                    p1.setMove(move);
                    move = Board.checkMove(move);
                    Board.setMove(move, p1.getSymbol());
                    a = 1;
                    break;
                case(1):
                    System.out.println(p2.getName() + "'s Turn");
                    Board.printBoard();
                    System.out.println("Enter your Move: ");
                    move = in.nextInt();
                    p2.setMove(move);
                    move = Board.checkMove(move);
                    Board.setMove(move, p2.getSymbol());
                    a = 0;
                    break;
            }
        }
        Board.printBoard();
        System.out.println("The Game Finished.");
        //Print the result
        if (Board.checkWinner() == true && a == 1){
            System.out.println(p1.getName() + " win the Game.");
        }
        else if(Board.checkWinner() == true && a == 0){
            System.out.println(p2.getName() + " win the Game.");
        }
        else{
            System.out.println("Draw, no player win");
        }
    }
}
