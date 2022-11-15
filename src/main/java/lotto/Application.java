package lotto;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.Jackpot();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
