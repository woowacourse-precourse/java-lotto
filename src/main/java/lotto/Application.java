package lotto;

import handler.InputHandler;
import handler.OutputHandler;
import handler.console.ConsoleInput;
import handler.console.ConsoleOutput;
import lotto.domain.LottoMachine;
import lotto.domain.MissionRandom;
import lotto.domain.RandomUniqueNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void main(String[] args) {
        InputHandler inputHandler = new ConsoleInput();
        InputView inputView = new InputView(inputHandler);

        OutputHandler outputHandler = new ConsoleOutput();
        OutputView outputView = new OutputView(outputHandler);
        RandomUniqueNumbers randomUniqueNumbers = new MissionRandom();

        try {
            LottoMachine lottoMachine = new LottoMachine(inputView, outputView, randomUniqueNumbers);
            lottoMachine.run();
        } catch (IllegalArgumentException e) {
            outputHandler.println(ERROR_PREFIX + e.getMessage());
        }
        // TODO: 프로그램 구현
    }
}
