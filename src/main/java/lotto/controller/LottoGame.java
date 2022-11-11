package lotto.controller;

import lotto.logic.LottoPurchase;

public class LottoGame {

    private LottoPurchase purchase;

    public LottoGame() {
        purchase = new LottoPurchase();
    }

    public void play(){
        int lotto = purchase.puchaseLotto();
    }
}
