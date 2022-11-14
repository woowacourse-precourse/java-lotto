package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Calculator {

    private List<Integer> winningNum = new ArrayList<>();
    private int bonusNum;
    private List<Lotto> lotto = new ArrayList<>();
    private HashMap<Integer, Integer> rankCount = new HashMap<>();
    private double yield;

    public Calculator(List<Integer> winningNum, int bonusNum, List<Lotto> lotto) {
        this.winningNum = winningNum;
        this.bonusNum = bonusNum;
        this.lotto = lotto;
        calcWinningStat();
        calcYield();
    }

    private int matchCount(List<Integer> lottoNum) {
        int count = 0;
        for (int num : lottoNum) {
            if (winningNum.contains(num)) {
                count += 1;
            }
        }
        return count;
    }

    private int calcRank(Lotto lotto) {
        int matchCount = matchCount(lotto.getLottoNum());
        boolean isMatchBonusNum = lotto.getLottoNum().contains(bonusNum);

        switch (matchCount) {
            case 6:
                return 1;
            case 5:
                if (isMatchBonusNum) {
                    return 2;
                } else {
                    return 3;
                }
            case 4:
                return 4;
            case 3:
                return 5;
        }
        return 0;
    }

    private void calcWinningStat() {
        for (Lotto lotto : lotto) {
            int rank = calcRank(lotto);

            if (rankCount.containsKey(rank)) {
                rankCount.put(rank, rankCount.get(rank) + 1);
            } else {
                rankCount.put(rank, 1);
            }
        }
    }

    public int getCountByRank(int rank) {
        if (rankCount.containsKey(rank)) {
            return rankCount.get(rank);
        }
        else {
            return 0;
        }
    }

    private void calcYield() {
        double profit = 0;
        for(Rank rank: Rank.values()) {
            if (rankCount.containsKey(rank.getPlace())) {
                profit += rankCount.get(rank.getPlace()) * rank.getPrize();
            }
        }
        yield = (profit/(1000*lotto.size()))*100;
    }

    public double getYield() {
        return yield;
    }
}

