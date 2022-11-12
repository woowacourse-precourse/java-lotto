package controller;

import domain.LotteryMachine;
import domain.PurchaseMoney;
import view.InputView;

public class LottoController {
    public void run(){
        buyLotto();
    }

    public void buyLotto(){
        PurchaseMoney purchaseMoney = new PurchaseMoney(InputView.inputMoney());
        LotteryMachine lotteryMachine = new LotteryMachine(purchaseMoney.getLottoCount());
    }
}
