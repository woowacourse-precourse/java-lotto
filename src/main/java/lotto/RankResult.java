package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RankResult {

    private RankCalculator rankCalculator;
    private Map<Rank, Integer> rankMap;

    public RankResult() {
        rankCalculator = new RankCalculator();
        rankMap = new EnumMap<>(Rank.class);
    }

    public Map<Rank, Integer> getResult() {
        return this.rankMap;
    }

    public void initEnumMap() {
        Arrays.stream(Rank.values())
                .forEach(rank -> rankMap.put(rank, 0));
    }

    public void addRankMapCount(List<Integer> winLotto, List<List<Integer>> randomLottos, int bonus) {
        for (List<Integer> randomLotto : randomLottos) {
            Rank rank = rankCalculator.calculate(winLotto, randomLotto, bonus);
            int previousCount = rankMap.getOrDefault(rank, 0);
            rankMap.put(rank, previousCount + 1);
        }
    }

    public float getProfit(int money) {
        return ((float) getReward() / (float) money) * 100;
    }

    private long getReward() {
        return rankMap.entrySet()
                .stream()
                .mapToLong(entry -> (long) entry.getKey().getWinMoney() * entry.getValue())
                .sum();
    }
}
