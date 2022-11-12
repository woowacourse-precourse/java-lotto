package lotto.controller;

import lotto.logic.Lotto;
import lotto.logic.LottoGenerator;
import lotto.logic.LottoPurchase;

import java.util.List;

public class LottoGame {

    private LottoPurchase purchase;
    private LottoGenerator generator;

    public LottoGame() {
        purchase = new LottoPurchase();
        generator = new LottoGenerator();
    }

    public void play() {
        int lottocnt = purchase.puchaseLotto();
        showPurchaseLotto(lottocnt);
    }

    protected void showPurchaseLotto(int lottocnt) {
        for (int i = 0; i < lottocnt; i++) {
            Lotto lotto = new Lotto(generator.lottoGenerate());
            System.out.println(lotto.getNumbers());
        }
    }
}
