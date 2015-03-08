package no.bouvet.tictactoe;

public class Game {
    public StringBuffer board;

    public Game(String s) {
        board = new StringBuffer(s);
    }

    public Game(StringBuffer s, int position, char player) {
        board = new StringBuffer();
        board.append(s);
        board.setCharAt(position, player);
    }

    public Game play(int i, char player) {
        return new Game(this.board, i, player);
    }

    public int move(char player) {
        for (int i = 0; i < boardLength(); i++) {
            if (isPlayable(i) && isWinningMove(i, player)) return i;
        }

        for (int i = 0; i < boardLength(); i++) {
            if (isPlayable(i)) return i;
        }

        return -1;
    }

    private boolean isWinningMove(int i, char player) {
        Game game = play(i, player);
        return game.winner() == player;
    }

    public char winner() {
        for (int i = 0; i < boardSize(); i++) {
            int rowStart = i * boardSize();
            if (isWinningRow(rowStart)) return getCell(rowStart);
        }
        return '-';
    }

    private boolean isWinningRow(int rowStart) {
        if (isPlayable(rowStart)) return false;

        for (int i = 0; i < boardSize(); i++) {
            if (!equal(rowStart, rowStart + i)) return false;
        }
        return true;
    }

    public int boardSize() {
        return (int) Math.sqrt(boardLength());
    }

    private int boardLength() {
        return board.length();
    }

    private boolean isPlayable(int i) {
        return getCell(i) == '-';
    }

    private boolean equal(int i, int j) {
        return getCell(i) == getCell(j);
    }

    private char getCell(int index) {
        return board.charAt(index);
    }

}
