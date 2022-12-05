package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.PurchaseAmount;

import lotto.util.Prize;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.EnumMap;
import java.util.List;

public class GameController {

    static List<List<Integer>> myLotto;
    static Lotto winningLotto;

    public static void run() throws IllegalArgumentException {
        issueLotto();
        setWinningLotto();
        getResult();
    }

    private static void getResult() {
        Calculator.setCalculator(myLotto, winningLotto);
        EnumMap<Prize, Integer> result = Calculator.calculateResult();
        OutputView.printResult(Prize.setResult(result));
        OutputView.printRate(Prize.calculateRate(result));
    }

    private static void setWinningLotto() throws IllegalArgumentException {
        winningLotto = new Lotto(InputView.readWinningLotto());
        BonusNumber.validate(InputView.readBonusNumber(), winningLotto);
    }

    public static void issueLotto() throws IllegalArgumentException {
        PurchaseAmount.validate(InputView.readPurchaseAmount());
        myLotto = LottoGenerator.generateLotto();
        OutputView.printMyLotto(myLotto);
    }
}
