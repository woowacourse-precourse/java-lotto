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
        try {
            int money = money();
            List<Lotto> lottos = buy(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private int money() {
        inputView.printInputMoney();
        String input = Console.readLine();
        InputValidator.checkMoney(input);

        return Integer.parseInt(input);
    }

    private List<Lotto> buy(int money) {
        int amount = money / Constants.LOTTO_PRICE;
        List<Lotto> lottos = IntStream.range(0, amount).mapToObj(index -> Lotto.generate())
                .collect(Collectors.toList());

        outputView.printLottoNumbers(lottos);

        return lottos;
    }

}
