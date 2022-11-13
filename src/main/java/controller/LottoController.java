package controller;

import domain.LotteryMachine;
import domain.PurchaseMoney;
import view.InputView;
import view.OutputView;

public class LottoController {
    public void run(){
        buyLotto();
        
    }

    public void buyLotto(){
        PurchaseMoney purchaseMoney = new PurchaseMoney(InputView.inputMoney());
        LotteryMachine lotteryMachine = new LotteryMachine(purchaseMoney.getLottoCount());
        OutputView.showLottos(lotteryMachine.getLottos());
    }
}
