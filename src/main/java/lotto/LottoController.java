package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.InputValidator;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void run() {
        int money = money();
    }

    private int money() {
        inputView.printInputMoney();
        String input = Console.readLine();
        InputValidator.checkMoney(input);

        return Integer.parseInt(input);
    }
}
