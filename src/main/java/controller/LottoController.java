package controller;

import domain.LotteryMachine;
import domain.Lotto;
import domain.PurchaseMoney;
import domain.WinningNumber;
import view.InputView;
import view.OutputView;

public class LottoController {
    private LotteryMachine lotteryMachine;

    public void run(){
        buyLotto();
        WinningNumber winningNumber = createWinningNumber();
    }

    private void buyLotto(){
        PurchaseMoney purchaseMoney = new PurchaseMoney(InputView.inputMoney());
        lotteryMachine = new LotteryMachine(purchaseMoney.getLottoCount());
        OutputView.showLottos(lotteryMachine.getLottos());
    }

    private WinningNumber createWinningNumber(){
        Lotto winningNumbers = new Lotto(InputView.inputWinningNumber());
        int bonusNumber = InputView.inputBonusNumber();

        System.out.println(winningNumbers.getNumbers());

        return getWinningNumbers(winningNumbers, bonusNumber);
    }

    private WinningNumber getWinningNumbers(Lotto winningNumbers, int bonusNumber){
        return new WinningNumber(winningNumbers, bonusNumber);
    }

}
