package lotto.controller;

import lotto.logic.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private LottoPurchase purchase;
    private LottoGenerator generator;
    private WinningNumberInput Winningnum;
    private WinningResult result;
    private Rank rank;


    public LottoGame() {
        purchase = new LottoPurchase();
        generator = new LottoGenerator();
        Winningnum = new WinningNumberInput();
        result = new WinningResult();
        rank = new Rank();
    }

    public void play() {
        int sumlotto = purchase.puchaseLotto();
        List<Lotto> lottos = getpurchaseLotto(sumlotto);
        List<Integer> winningNum = Winningnum.getWinningNum();
        int bonusNum = Winningnum.getBonusNum(winningNum);
        Map<Integer, Integer> map = result.getwinningResult(lottos, winningNum, bonusNum);
        showStatistic(map, sumlotto);
    }

    protected List<Lotto> getpurchaseLotto(int lottocnt) {
        List<Lotto> lottonum = new ArrayList<>();
        for (int i = 0; i < lottocnt / 1000; i++) {
            Lotto lotto = new Lotto(generator.lottoGenerate());
            lottonum.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        return lottonum;
    }

    private void showStatistic(Map<Integer, Integer> map, int amount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rank.getRankfive(map) + "개");
        System.out.println("4개 일치 (50,000원) - " + rank.getRankfour(map) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rank.getRankthree(map) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rank.getranktwo(map) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rank.getrankone(map) + "개");
        System.out.println("총 수익률은 " + (rank.getearningRate(map, amount)+ "%입니다."));
    }
}
