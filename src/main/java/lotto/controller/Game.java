package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCashier;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Game {
    public void startLottoGame() {
        int money = InputView.inputLottoAmount();
        LottoCashier lottoCashier = new LottoCashier();
        int count = lottoCashier.getLottoCount(money);
        OutputView.printCheckAmount(count);
        List<Lotto> lottos = lottoCashier.createLottoList(count);

        Lotto winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber(winningNumbers);

    }

    private Lotto setWinningNumbers() {
        List<Integer> inputNumbers = InputView.inputWinningNumbers();
        Lotto winningNumber = new Lotto(inputNumbers);
        return winningNumber;
    }

    private int setBonusNumber(Lotto lotto) {
        int bonusNumber = InputView.inputBonusNumber();
        lotto.validateBonus(bonusNumber);
        return bonusNumber;
        }
}
