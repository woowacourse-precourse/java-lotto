package lotto;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        try {
            game.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
