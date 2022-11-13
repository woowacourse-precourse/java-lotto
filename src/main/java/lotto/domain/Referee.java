package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    private double totalPrize;

    public Referee() {
        this.totalPrize = 0.0;
    }

    public Map<Rank, Integer> findNumber(List<List<Integer>> generatorNumbers, int bonusNumber, Lotto lotto) {
        Judgement judgement = new Judgement();
        Map<Rank, Integer> ranking = new HashMap<>();
        for (List<Integer> number : generatorNumbers) {
            int matchCount = judgement.correctNumbers(number, lotto.getNumbers());
            boolean isBonus = judgement.correctBonus(number, bonusNumber);
            compareNumber(ranking, matchCount, isBonus);
        }
        return ranking;
    }

    private void compareNumber(Map<Rank, Integer> ranking, int matchCount, boolean isBonus) {
        Rank rank = Rank.find(matchCount, isBonus);
        ranking.put(rank, ranking.getOrDefault(rank, 0) + 1);
        sumPrize(rank);
    }

    private void sumPrize(Rank rank) {
        totalPrize += rank.getPrize();
    }

    public double getTotalPrize() {
        return totalPrize;
    }
}
