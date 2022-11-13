package lotto.Domain;

import lotto.Output.StatisticOutput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Statistic {
    private List<Integer> lottoSix;
    private int bonus;
    private List<Set<Integer>> publishedLotto;
    Statistic statistic = new Statistic();

    private Statistic(){}
    public Statistic(List<Integer> lottoSix, int bonus, List<Set<Integer>> publishedLotto) {
        this.lottoSix = lottoSix;
        this.bonus = bonus;
        this.publishedLotto = publishedLotto;
    }

    public Map<String, Integer> getStatistic() {
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
        return statistic.getWinningMap(three, four, five, six_YesBonus, six);
    }

    public Map<String, Integer> getWinningMap(int three, int four, int five, int six_YesBonus, int six) {
        Map<String, Integer> winningMap = new HashMap<>();
        winningMap.put("three", three);
        winningMap.put("four", four);
        winningMap.put("five", five);
        winningMap.put("six_YesBonus", six_YesBonus);
        winningMap.put("six", six);

        StatisticOutput statisticOutput = new StatisticOutput();
        statisticOutput.getStatisticOutput(three, four, five, six_YesBonus, six);
        return winningMap;
    }
}
