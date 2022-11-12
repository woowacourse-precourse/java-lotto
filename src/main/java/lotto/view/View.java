package lotto.view;

import lotto.Constant;
import lotto.enums.Rank;
import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public class View {

    public void printLottoPayed(List<Lotto> lottoPayed) {
        System.out.printf(Constant.buyingFormat,lottoPayed.size());
        for (Lotto lotto : lottoPayed) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningStats(Map<Rank, Integer> winningStats) {
        System.out.printf(Constant.winningFormat,Constant.fifthRankNum
                ,Constant.fifthRankPriceString,winningStats.get(Rank.fifth));
        System.out.printf(Constant.winningFormat,Constant.fourthRankNum
                ,Constant.fourthRankPriceString,winningStats.get(Rank.fourth));
        System.out.printf(Constant.winningFormat,Constant.thirdRankNum
                ,Constant.thirdRankPriceString,winningStats.get(Rank.third));
        System.out.printf(Constant.winningFormatBonus,Constant.secondRankNum
                ,Constant.secondRankPriceString,winningStats.get(Rank.second));
        System.out.printf(Constant.winningFormat,Constant.firstRankNum
                ,Constant.firstRankPriceString,winningStats.get(Rank.first));
    }

    public void printEarningRate(double earningRate) {
        System.out.printf(Constant.earningRateFormat,earningRate);
    }

}
