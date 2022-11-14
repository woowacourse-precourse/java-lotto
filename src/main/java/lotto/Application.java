package lotto;

import handler.InputHandler;
import handler.OutputHandler;
import handler.console.ConsoleInput;
import handler.console.ConsoleOutput;
import lotto.domain.LottoWinningSystem;
import lotto.domain.PickNumbers;
import lotto.domain.RandomPicker;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void main(String[] args) {
        final InputHandler inputHandler = new ConsoleInput();
        final InputView inputView = new InputView(inputHandler);

        final OutputHandler outputHandler = new ConsoleOutput();
        final OutputView outputView = new OutputView(outputHandler);
        final PickNumbers pickNumbers = new RandomPicker();

        try {
            final LottoWinningSystem lottoWinningSystem = new LottoWinningSystem(inputView, outputView, pickNumbers);
            lottoWinningSystem.run();
        } catch (IllegalArgumentException e) {
            outputHandler.println(ERROR_PREFIX + e.getMessage());
        }
    }
}
