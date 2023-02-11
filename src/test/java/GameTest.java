import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void testWhenFirstPlayerWin() throws NotRegisteredException {
        Game game = new  Game();

        Player player1 = new Player(1, "Mike", 120);
        Player player2 = new Player(2, "Joe", 110);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Mike", "Joe");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayerWin() {
        Game game = new Game();

        Player player1 = new Player(1, "Mike", 110);
        Player player2 = new Player(2, "Joe", 120);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Mike", "Joe");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDraw() {
        Game game = new  Game();

        Player player1 = new Player(1, "Mike", 100);
        Player player2 = new Player(2, "Joe", 100);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Mike", "Joe");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerNorRegistered() {
        Game game = new Game();

        Player player1 = new Player(1, "Mike", 110);
        Player player2 = new Player(2, "Joe", 120);


        game.register(player2);

        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Mike", "Joe");
        });
    }

    @Test
    public void whenSecondPlayerNorRegistered() {
        Game game = new Game();

        Player player1 = new Player(1, "Mike", 110);
        Player player2 = new Player(2, "Joe", 120);

        game.register(player1);

        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Mike", "Joe");
        });
    }

    @Test
    public void testBothPlayersNoRegistered() {
        Game game = new Game();

        Player player1 = new Player(1, "Mike", 110);
        Player player2 = new Player(2, "Joe", 120);

        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Mike", "Joe");
        });
    }
}

