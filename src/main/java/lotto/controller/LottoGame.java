package lotto.controller;

import lotto.logic.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private LottoPurchase purchase;
    private LottoGenerator generator;
    private WinningNumberInput Winningnum;
    private WinningResult result;

    public LottoGame() {
        purchase = new LottoPurchase();
        generator = new LottoGenerator();
        Winningnum = new WinningNumberInput();
        result = new WinningResult();
    }

    public void play() {
        int lottocnt = purchase.puchaseLotto(); // 로또 구매
        List<Lotto> lottos = getpurchaseLotto(lottocnt);// 로또를 담은 리스트
        List<Integer> winningNum = Winningnum.getWinningNum(); // 당첨번호 입력
        int bonusNum = Winningnum.getBonusNum(winningNum);// 보너스번호 입력
        Map<Integer, Integer> integerIntegerMap = result.getwinningResult(lottos, winningNum, bonusNum);
    }

    protected List<Lotto> getpurchaseLotto(int lottocnt) {
        List<Lotto> lottonum = new ArrayList<>();
        for (int i = 0; i < lottocnt; i++) {
            Lotto lotto = new Lotto(generator.lottoGenerate());
            lottonum.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        return lottonum;
    }

    private void showStatistic () {

    }
}
