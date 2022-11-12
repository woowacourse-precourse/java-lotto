package lotto;

public class Application {
    public static void main(String[] args) {
        LottoGame game = LottoGame.init();
        game.start();
    }
}
