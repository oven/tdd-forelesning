package no.bouvet.tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void testDefaultMove() {
        Game game = new Game("XOXOX-OXO");
        assertEquals(5, game.move('X'));

        game = new Game("XOXOXOOX-");
        assertEquals(8, game.move('O'));

        game = new Game("---------");
        assertEquals(0, game.move('X'));

        game = new Game("XXXXXXXXX");
        assertEquals(-1, game.move('X'));
    }

    @Test
    public void testFindWinningMove() {
        Game game = new Game("XO-XX-OOX");
        assertEquals(5, game.move('X'));
    }

    @Test
    public void testFindWinningMoveInLargerGame() {
        Game game = new Game("XO--XXX-OOXX----");
        assertEquals(7, game.move('X'));
    }

    @Test
    public void testWinConditions() {
        Game game = new Game("---XXX---");
        assertEquals('X', game.winner());
    }
}