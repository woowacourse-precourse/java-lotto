package lotto.controller;

import lotto.domain.*;
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
        OutputView.printPurchasedNumbers(lottos);

        Lotto winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber(winningNumbers);

        Referee referee = new Referee(lottos,winningNumbers,bonusNumber);
        List<Grade> grades = referee.calculateGrades();
        OutputView.printLottoStatics(referee.getStatics(grades));

        Yield yield = new Yield(grades, money);
        OutputView.printLottoEarningRate(yield.getYield());
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
