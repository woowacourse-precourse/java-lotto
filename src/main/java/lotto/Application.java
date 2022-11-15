package lotto;

import static lotto.utils.view.OutputView.showErrorMessage;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.start();
        } catch (IllegalArgumentException e) {
            showErrorMessage(e);
        }
    }
}
