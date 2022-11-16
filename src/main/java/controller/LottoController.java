package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import static util.StringUtil.parseToInt;
import static util.StringUtil.parseToIntegerList;

public class LottoController {
    public void run() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(InputView.inputMoney());
        LotteryMachine lotteryMachine = new LotteryMachine(purchaseMoney.getLottoCount());
        OutputView.showLottos(lotteryMachine.getLottos());
        WinningNumber winningNumber = createWinningNumber();
        LottoResult lottoResult = new LottoResult(lotteryMachine, winningNumber);
        OutputView.showResult(lottoResult.getResult());
        OutputView.showProfitPercent(purchaseMoney.getPurchaseMoney(), lottoResult);
    }

    private WinningNumber createWinningNumber() {
        Lotto winningNumbers = new Lotto(parseToIntegerList(InputView.inputWinningNumber()));
        int bonusNumber = parseToInt(InputView.inputBonusNumber());

        return getWinningNumbers(winningNumbers, bonusNumber);
    }

    private WinningNumber getWinningNumbers(Lotto winningNumbers, int bonusNumber) {
        return new WinningNumber(winningNumbers, bonusNumber);
    }
}
