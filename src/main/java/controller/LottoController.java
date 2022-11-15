package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class LottoController {

    public void run(){
        PurchaseMoney purchaseMoney = new PurchaseMoney(InputView.inputMoney());
        LotteryMachine lotteryMachine = new LotteryMachine(purchaseMoney.getLottoCount());
        OutputView.showLottos(lotteryMachine.getLottos());
        WinningNumber winningNumber = createWinningNumber();
        LottoResult lottoResult = new LottoResult(lotteryMachine, winningNumber);
        OutputView.showResult(lottoResult.getResult());
        OutputView.showProfitPercent(purchaseMoney.getPurchaseMoney(), lottoResult);
    }

    private WinningNumber createWinningNumber(){
        Lotto winningNumbers = new Lotto(InputView.inputWinningNumber());
        int bonusNumber = InputView.inputBonusNumber();

        return getWinningNumbers(winningNumbers, bonusNumber);
    }

    private WinningNumber getWinningNumbers(Lotto winningNumbers, int bonusNumber){
        return new WinningNumber(winningNumbers, bonusNumber);
    }

}
