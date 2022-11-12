package controller;

import domain.PurchaseMoney;
import view.InputView;

public class LottoController {
    public void run(){
        PurchaseMoney purchaseMoney = new PurchaseMoney(InputView.inputMoney());
    }
}
