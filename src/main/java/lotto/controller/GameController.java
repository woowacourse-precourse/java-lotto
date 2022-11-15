package lotto.controller;

import lotto.domain.Grade;
import lotto.domain.Lotto;
import lotto.domain.RandomNumbers;
import lotto.domain.Referee;
import lotto.domain.Yield;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.validateBonus;


public class GameController {

    private List<Lotto> purchasedLotto;
    private Lotto winningNumbers;
    private int bonusNumber;

    public void startLottoGame() {
        int money = InputView.inputLottoAmount();
        int count = getLottoCount(money);
        OutputView.printCheckAmount(count);
        List<Lotto> lottos = createLottoList(count);
        OutputView.printPurchasedNumbers(lottos);
        winningNumbers = setWinningNumbers();
        bonusNumber = setBonusNumber();
        Referee referee = new Referee(lottos,winningNumbers,bonusNumber);
        List<Grade> grades = referee.calculateGrades();
        OutputView.printLottoStatics(referee.getStatics(grades));
        Yield yield = new Yield(grades, money);
        OutputView.printLottoEarningRate(yield.getYield());
    }

    private int getLottoCount(int money) {
        if (money > 0 && money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구입해야 합니다.");
        }
        return money / 1000;
    }

    private List<Lotto> createLottoList(int count) {
        List<Lotto> purchasedLotto = new ArrayList<>();
        RandomNumbers randomNumbers = new RandomNumbers();

        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = randomNumbers.createRandomNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            purchasedLotto.add(lotto);
        }
        return purchasedLotto;
    }

    private Lotto setWinningNumbers() {
        List<Integer> inputNumbers = InputView.inputWinningNumbers();
        Lotto winningNumber = new Lotto(inputNumbers);
        return winningNumber;
    }

    private int setBonusNumber() {
        int bonusNumber = InputView.inputBonusNumber();
        validateBonus(winningNumbers.getNumbers(), bonusNumber);
        return bonusNumber;
    }

}
