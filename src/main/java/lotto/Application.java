package lotto;

import lotto.domain.Game;
import lotto.utils.OutputView;

public class Application {
    public static void main(String[] args) {
        try{
            Game game = new Game();
            game.startGame();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

}
