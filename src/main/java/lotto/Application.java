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
        InputHandler inputHandler = new ConsoleInput();
        InputView inputView = new InputView(inputHandler);

        OutputHandler outputHandler = new ConsoleOutput();
        OutputView outputView = new OutputView(outputHandler);
        PickNumbers pickNumbers = new RandomPicker();

        try {
            LottoWinningSystem lottoWinningSystem = new LottoWinningSystem(inputView, outputView, pickNumbers);
            lottoWinningSystem.run();
        } catch (IllegalArgumentException e) {
            outputHandler.println(ERROR_PREFIX + e.getMessage());
        }
    }
}
