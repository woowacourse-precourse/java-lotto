package lotto.Domain.Statistic;

import java.util.*;
import java.util.stream.Collectors;

public class Statistic {
    public List<Integer> lottoSix;
    public int bonus;
    public List<Set<Integer>> publishedLotto;
    public List<Integer> prizeRanks;

    public Statistic(List<Integer> lottoSix, int bonus, List<Set<Integer>> publishedLotto) {
        this.lottoSix = lottoSix;
        this.bonus = bonus;
        this.publishedLotto = publishedLotto;
        this.prizeRanks = getStatistic();
    }



    public List<Integer> getStatistic() {
        int[] prizeRank = {0,0,0,0,0};
        StatisticCalculate statisticCalculate = new StatisticCalculate();
        for(Set<Integer> publishedOneLotto : publishedLotto) {
            int hasBonusSize = statisticCalculate.hasBonusSize(publishedOneLotto, lottoSix, bonus);
            int hasNoBonusSize = statisticCalculate.hasNoBonusSize(publishedOneLotto, lottoSix, bonus);
            if(hasBonusSize == 6){ prizeRank[PrizeRankIndex.SIX_YES_BONUS.getNum()]++; }

            if(hasNoBonusSize == 6){ prizeRank[PrizeRankIndex.SIX_NO_BONUS.getNum()]++; }
            if(hasNoBonusSize == 7){ prizeRank[PrizeRankIndex.FIVE.getNum()]++; }
            if(hasNoBonusSize == 8){ prizeRank[PrizeRankIndex.FOUR.getNum()]++; }
            if(hasNoBonusSize == 9){ prizeRank[PrizeRankIndex.THREE.getNum()]++; }
        }

        return Arrays.stream(prizeRank).boxed().collect(Collectors.toList());
    }

}
