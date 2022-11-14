package lotto.Domain.Statistic;

import lotto.Output.Statistic.StatisticOutput;

import java.util.*;
import java.util.stream.Collectors;

public class Statistic {
    public List<Integer> lottoSix;
    public int bonus;
    public List<Set<Integer>> publishedLotto;
    public List<Integer> prizeRanks;

    private Statistic(){}
    public Statistic(List<Integer> lottoSix, int bonus, List<Set<Integer>> publishedLotto) {
        this.lottoSix = lottoSix;
        this.bonus = bonus;
        this.publishedLotto = publishedLotto;
        StatisticOutput statisticOutput = new StatisticOutput();
        this.prizeRanks = getStatistic();
        statisticOutput.getStatisticOutput(prizeRanks);
    }



    public List<Integer> getStatistic() {
        int[] prizeRank = {0,0,0,0,0};
        for(Set<Integer> publishedOneLotto : publishedLotto) {
            List<Integer> userlotto = lottoSix;
            userlotto.removeAll(publishedOneLotto);
            if(userlotto.size() == 3) { prizeRank[0]++; }
            if(userlotto.size() == 2) { prizeRank[1]++; }
            if(userlotto.size() == 1) { prizeRank[2]++; }
            if(userlotto.size() == 0) { prizeRank[4]++; }
            userlotto.removeAll(List.of(bonus));
            if(userlotto.size() == 0) { prizeRank[3]++; prizeRank[2]--; }
        }
        return Arrays.stream(prizeRank)
                .boxed()
                .collect(Collectors.toList());
    }

}
