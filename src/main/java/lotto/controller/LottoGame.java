package lotto.controller;

import lotto.logic.Lotto;
import lotto.logic.LottoGenerator;
import lotto.logic.LottoPurchase;
import lotto.logic.WinningNumberInput;

import java.util.List;

public class LottoGame {

    private LottoPurchase purchase;
    private LottoGenerator generator;
    private WinningNumberInput Winningnum;

    public LottoGame() {
        purchase = new LottoPurchase();
        generator = new LottoGenerator();
        Winningnum = new WinningNumberInput();
    }

    public void play() {
        int lottocnt = purchase.puchaseLotto();
        showPurchaseLotto(lottocnt);
        List<Integer> winningNum = Winningnum.getWinningNum();
        Winningnum.getBonusNum(winningNum);
    }

    protected void showPurchaseLotto(int lottocnt) {
        for (int i = 0; i < lottocnt; i++) {
            Lotto lotto = new Lotto(generator.lottoGenerate());
            System.out.println(lotto.getNumbers());
        }
    }
}
