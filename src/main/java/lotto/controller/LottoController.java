package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Clerk;
import lotto.domain.Lotto;
import lotto.domain.NumbersGenerator;
import lotto.domain.Statistics;
import lotto.domain.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    public void start() {
        Output output = new Output();
        Input input = new Input();

        int lottoQuantity = getLottoQuantity(output, input);
        List<Lotto> lottos = getLottos(output, lottoQuantity);
        WinningLotto winningLotto = makeWinningLotto(output, input);
        makeResult(output, lottos, winningLotto);
    }

    private void makeResult(Output output, List<Lotto> lottos, WinningLotto winningLotto) {
        Statistics statistics = new Statistics();
        statistics.makeStatistics(winningLotto, lottos);
        output.printWinningStatistics(statistics);
    }

    private List<Lotto> getLottos(Output output, int lottoQuantity) {
        NumbersGenerator numbersGenerator = new NumbersGenerator();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(new Lotto(numbersGenerator.generatorNumbers()));
        }
        output.printInputMoneyResultMessage(lottoQuantity);
        output.printPurchasedLottos(lottos);
        return lottos;
    }

    private int getLottoQuantity(Output output, Input input) {
        Clerk clerk = new Clerk();
        output.printMoneyInputMessage();

        return clerk.giveLottoQuantity(input.inputMoney());
    }

    private WinningLotto makeWinningLotto(Output output, Input input) {
        output.printWinningNumbersInputMessage();
        List<Integer> winningNumber = input.inputWinningNumber();

        output.printBonusNumberInputMessage();
        int bonusNumber = input.inputBonusNumber();

        return new WinningLotto(winningNumber, bonusNumber);
    }

}
