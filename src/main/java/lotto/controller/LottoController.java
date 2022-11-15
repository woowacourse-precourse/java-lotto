package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseMoney;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            LottoPurchaseMoney lottoPurchaseMoney = getLottoPurchaseMoney();
            WinningNumbers winningNumbers = getWinningNumbers();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private LottoPurchaseMoney getLottoPurchaseMoney() {
        int lottoPurchaseMoney = inputView.inputLottoPurchaseMoney();
        return new LottoPurchaseMoney(lottoPurchaseMoney);
    }

    private WinningNumbers getWinningNumbers() {
        Lotto winningNumber = new Lotto(inputView.inputWinningNumber());
        int bonusNumber = inputView.inputBonusNumber();
        return new WinningNumbers(winningNumber, bonusNumber);
    }

}
