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

    public int move(char player) {
        for (int i = 0; i < boardLength(); i++) {
            if (isPlayable(i) && isWinningMove(player, i)) return i;
        }

        for (int i = 0; i < boardLength(); i++) {
            if (isPlayable(i)) return i;
        }
        return -1;
    }

    private boolean isWinningMove(char player, int i) {
        Game game = play(i, player);
        if (game.winner() == player)
            return true;
        return false;
    }

    private boolean isPlayable(int i) {
        return getCell(i) == '-';
    }

    private int boardLength() {
        return board.length();
    }

    public Game play(int i, char player) {
        return new Game(this.board, i, player);
    }

    public char winner() {
        for (int i = 0; i < boardSize(); i++) {
            int rowstart = i * boardSize();
            if (isWinningRow(rowstart)) return getCell(rowstart);
        }
        return '-';
    }

    private int boardSize() {
        return (int) Math.sqrt(boardLength());
    }

    private boolean isWinningRow(int rowstart) {
        if (isPlayable(rowstart)) return false;

        for (int i = 0; i < boardSize(); i++) {
            if(getCell(rowstart) != getCell(rowstart + i)) return false;
        }
        return true;
    }

    private char getCell(int index) {
        return board.charAt(index);
    }
}
