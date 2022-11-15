package lotto.controller;

import lotto.Lotto;
import lotto.domain.*;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public static void run() {
        Amount amount = new Amount(InputView.inputPurchaseAmount());
        LottoNumber number = new LottoNumber(amount.calculateBallCount());

        WinNumber winNumber = new WinNumber(InputView.inputWinNumber());
        List<Integer> userInputWinNumber = winNumber.getWinLottoNumber();

        BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
        int bonus = bonusNumber.getBonus();

        CheckWin checkWin = new CheckWin(number.getUserAllLotto(), userInputWinNumber, bonus);
        checkWin.compareNumber();
        checkWin.printResult();

        CalculateYield calculateYield = new CalculateYield(amount.getAmount());
        calculateYield.calculatePrizeMoney(checkWin.getPrize());
        calculateYield.printPrizeMoney();
    }
}
