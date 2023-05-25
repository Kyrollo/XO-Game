package main;

public class player {
    private String name, symbol;
    private int move;

    public void setName(String name) {
        this.name = name;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }

    public String getSymbol() {
        return symbol;
    }
    
}
