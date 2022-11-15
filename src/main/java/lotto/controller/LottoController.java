package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoGenerator;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public void run() {
        Money money = getInputMoney();
        List<LottoGenerator> lottos = generateLottos(money);
        ResultView.printLottoQuantity(money.calculateQuantity());
        ResultView.printGeneratedLotto(lottos);
        WinningLotto winningLotto = createWinningLotto();
        LottoCalculator lottoCalculator = new LottoCalculator(winningLotto,lottos);
        ResultView.printLottoResult(lottoCalculator);
    }

    public Money getInputMoney() {
        return new Money(InputView.getInputMoney());
    }

    public List<LottoGenerator> generateLottos(Money money) {
        LottoGenerator lotto = new LottoGenerator();
        List<LottoGenerator> generatedLottos = new ArrayList<>();
        for (int i = 0; i < money.calculateQuantity(); i++) {
            generatedLottos.add(lotto);
        }
        return generatedLottos;
    }

    public WinningLotto createWinningLotto() {
        Lotto winningNumbers = createWinningNumbers();
        BonusNumber bonusNumber = createBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Lotto createWinningNumbers() {
        List<Integer> winningNumbersInput = InputView.getWinningNumbers();
        return new Lotto(winningNumbersInput);
    }

    private BonusNumber createBonusNumber() {
        return new BonusNumber(InputView.getBonusNumber());
    }
}

