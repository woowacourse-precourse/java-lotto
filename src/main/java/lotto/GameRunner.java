package lotto;

import lotto.controller.GameController;
import lotto.utils.game.GameStatus;
import lotto.view.IOViewResolver;
import lotto.view.InputView;
import lotto.view.OutputView;

public final class GameRunner {

    private GameRunner() {
    }

    public static void run(GameStatus gameStatus) {
        IOViewResolver ioViewResolver = createIOViewResolver();
        GameController controller = new GameController(ioViewResolver);

        while (gameStatus.playable()) {
            gameStatus = controller.process(gameStatus);
        }
    }

    private static IOViewResolver createIOViewResolver() {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();

        return new IOViewResolver(inputView, outputView);
    }
}
