package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void start() {
        int money = inputMoney();
        LottoList LottoPaper = OutputView.printQuantity(money);

        List<Integer> lottoList = inputWinningNumber();
        int bonusNumber = inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(new Lotto(lottoList) ,bonusNumber);

        WinningStatistics winningStatistics = OutputView.printWinningStatistics(LottoPaper, winningLotto);

        OutputView.printProfitRate(money, winningStatistics);
    }

    private int inputBonusNumber() {
        try {
            int bonusNumber = InputView.inputBonusNumber();
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputBonusNumber();
        }
    }

    private List<Integer> inputWinningNumber() {
        try {
            List<Integer> lottoList = InputView.inputWinningNumber();
            return lottoList;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputWinningNumber();
        }
    }

    private int inputMoney() {
        try {
            int money = InputView.inputMoney();
            return money;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputMoney();
        }
    }
}
