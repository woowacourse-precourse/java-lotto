package lotto.domain;

import lotto.io.Output;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Statistics {
    private final int INITIAL_VALUE = 0;
    private final Map<Rank, Integer> rankMap = new EnumMap<>(Rank.class);
    private int totalPrize;

    public Statistics() {
        rankMapPut();
    }

    private void rankMapPut() {
        rankMap.put(Rank.FIRST, INITIAL_VALUE);
        rankMap.put(Rank.SECOND, INITIAL_VALUE);
        rankMap.put(Rank.THIRD, INITIAL_VALUE);
        rankMap.put(Rank.FOURTH, INITIAL_VALUE);
        rankMap.put(Rank.FIFTH, INITIAL_VALUE);
    }

    public void winningStatistics(List<Lotto> quickPicks, LinkedList<Integer> winningNumWithBonusList, int purchaseAmt) {
        for (Lotto quickPick : quickPicks) {
            compareNum(quickPick, winningNumWithBonusList);
        }
        double revenue = (totalPrize / (double) purchaseAmt) * 100;

        Output.printWinningStatistics(rankMap, revenue);
    }

    private void compareNum(Lotto quickPick, LinkedList<Integer> winningNumWithBonusList) {
        List<Integer> winningNumList = winningNumWithBonusList.subList(0, winningNumWithBonusList.size() - 1);
        int bonus = winningNumWithBonusList.getLast();
        boolean bonusMatch = false;
        long count = quickPick.getNumbers().stream().filter(winningNumList::contains).count();

        if (quickPick.getNumbers().contains(bonus)) {
            bonusMatch = true;
        }
        calculateTotalPrize((int) count, bonusMatch);
    }

    private void calculateTotalPrize(int count, boolean bonusMatch) {
        Rank rank = Rank.getRank(count, bonusMatch);
        totalPrize += rank.getPrize();

        calculateMatchCount(rank);
    }

    private void calculateMatchCount(Rank rank) {
        if (rankMap.containsKey(rank)) {
            rankMap.replace(rank, rankMap.get(rank) + 1);
        }

    }

}
