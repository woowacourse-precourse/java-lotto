package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lotto.constants.Rank;

public class Result {

    private Map<Rank, Integer> rankInfo;
    private float winningAmount;

    public Result() {
        rankInfo = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> rankInfo.put(rank, 0));
    }

    public void initWinningAmount(int purchase) {
        for (Rank rank : rankInfo.keySet()) {
            winningAmount += rank.getPrize() * rankInfo.get(rank);
        }
        winningAmount = (winningAmount / purchase) * 100;
    }

    public void updateRankInfo(Rank rank) {
        rankInfo.put(rank, rankInfo.get(rank) + 1);
    }

    public void matchLotto(List<Integer> winningNumbers, List<Lotto> lottos, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(winningNumbers, lotto);
            boolean isContainBonusNumber = isContainBonusNumber(bonusNumber, lotto);

            updateRankInfo(Rank.valueOfRank(matchCount, isContainBonusNumber));
        }
    }

    public Map<Rank, Integer> sortedRankInfo() {
        List<Entry<Rank, Integer>> entries = rankInfo.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(r -> r.getKey().getPrize()))
                .collect(Collectors.toList());

        Map<Rank, Integer> result = convertListToMap(entries);

        return result;
    }

    public Map<Rank, Integer> getRankInfo() {
        return rankInfo;
    }

    public float getWinningAmount() {
        return winningAmount;
    }

    private boolean isContainBonusNumber(int bonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private int getMatchCount(List<Integer> winningNumbers, Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private Map<Rank, Integer> convertListToMap(List<Entry<Rank, Integer>> entries) {
        Map<Rank, Integer> result = new LinkedHashMap<>();

        for (Entry<Rank, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
