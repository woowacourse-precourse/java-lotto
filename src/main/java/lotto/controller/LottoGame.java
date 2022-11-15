package lotto.controller;

import lotto.logic.*;
import lotto.data.LottoRank;
import lotto.data.OutputForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.data.Constant.PRICE;

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
        for (int i = 0; i < lottocnt / PRICE.getConstant(); i++) {
            Lotto lotto = new Lotto(generator.lottoGenerate());
            lottonum.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        return lottonum;
    }

    private void showStatistic(Map<Integer, Integer> map, int amount) {
        System.out.println(OutputForm.OUTPUT_STATISTIC.getMessage());
        System.out.println(OutputForm.OUTPUT_BORDER.getMessage());
        System.out.println(LottoRank.FIFTH.getState() + rank.getRankfive(map) + "개");
        System.out.println(LottoRank.FOURTH.getState() + rank.getRankfour(map) + "개");
        System.out.println(LottoRank.THIRD.getState() + rank.getRankthree(map) + "개");
        System.out.println(LottoRank.SECOND.getState() + rank.getranktwo(map) + "개");
        System.out.println(LottoRank.FIRST.getState() + rank.getrankone(map) + "개");
        System.out.println(OutputForm.OUTPUT_PROFIT.getMessage() + (rank.getearningRate(map, amount) + "%입니다."));
    }
}
