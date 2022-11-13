package lotto.Domain;

import lotto.Output.StatisticOutput;

import java.util.List;
import java.util.Set;

public class Statistic {
    private final List<Integer> lottoSix;
    private final int bonus;
    private final List<Set<Integer>> publishedLotto;

    public Statistic(List<Integer> lottoSix, int bonus, List<Set<Integer>> publishedLotto) {
        this.lottoSix = lottoSix;
        this.bonus = bonus;
        this.publishedLotto = publishedLotto;
    }

    public void getStatistic() {
        int three = 0, four = 0, five = 0, six_YesBonus = 0, six = 0;
        for(Set<Integer> publishedOneLotto : publishedLotto) {
            List<Integer> userlotto = lottoSix;
            userlotto.removeAll(publishedOneLotto);
            if(userlotto.size() == 3) { three++; }
            if(userlotto.size() == 2) { four++; }
            if(userlotto.size() == 1) { five++; }
            if(userlotto.size() == 0) { six++; }
            userlotto.removeAll(List.of(bonus));
            if(userlotto.size() == 0) {
                six_YesBonus++;
                five--;
            }
        }
        StatisticOutput.getStatisticOutput(three, four, five, six_YesBonus, six);
    }
}
