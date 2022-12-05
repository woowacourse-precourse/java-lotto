package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.EnumMap;
import java.util.List;

public class GameController {

    public static void run() throws IllegalArgumentException{
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.readPurchaseAmount());
        List<List<Integer>> myLotto = LottoGenerator.generateLotto(purchaseAmount);
        OutputView.printMyLotto(myLotto);
        Lotto winningLotto = new Lotto(InputView.readWinningLotto());
        BonusNumber bonusNumber = new BonusNumber(InputView.readBonusNumber(), winningLotto);
        Calculator calculator = new Calculator(myLotto, winningLotto, bonusNumber);
        EnumMap<Prize, Integer> result = calculator.saveResult();
        float rate = calculator.caculateRate(purchaseAmount);
        OutputView.printResult(result);
        OutputView.printRate(rate);
    }
}
