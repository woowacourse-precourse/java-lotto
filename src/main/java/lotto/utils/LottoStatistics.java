package lotto.utils;

import lotto.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.Win;

import java.util.List;

import static lotto.LottoRank.*;

public class LottoStatistics {

    private int firstCount = 0;
    private int secondCount = 0;
    private int thirdCount = 0;
    private int fourthCount = 0;
    private int fifthCount = 0;


    public LottoStatistics(List<Lotto> lottos, Win win) {
        for (int i = 0; i < lottos.size(); i++) {
            LottoRank rank = getRank(lottos.get(i), win);
            if (rank != null) {
                count(rank);
            }
        }
    }

    private void count(LottoRank rank) {
        if (rank.equals(FIRST)) {
            firstCount++;
        }
        if (rank.equals(SECOND)) {
            secondCount++;
        }
        if (rank.equals(THIRD)) {
            thirdCount++;
        }
        if (rank.equals(FOURTH)) {
            fourthCount++;
        }
        if (rank.equals(FIFTH)) {
            fifthCount++;
        }
    }

    protected static LottoRank getRank(Lotto lotto, Win win) {
        int matchCount = 0;
        boolean bonusMatch = false;

        for (Integer number : lotto.getNumbers()) {
            if (win.getNumbers().contains(number)) {
                matchCount++;
            }
            if (win.getBonus() == number) {
                bonusMatch = true;
            }
        }

        return getLottoRankOrNull(matchCount, bonusMatch);
    }

    private static LottoRank getLottoRankOrNull(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return null;
    }

    protected long calculateReward() {
        return (long) firstCount * FIRST.getReward()
                + (long) secondCount * SECOND.getReward()
                + (long) thirdCount * THIRD.getReward()
                + (long) fourthCount * FOURTH.getReward()
                + (long) fifthCount * FIFTH.getReward();
    }

    public int getFirstCount() {
        return firstCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public int getThirdCount() {
        return thirdCount;
    }

    public int getFourthCount() {
        return fourthCount;
    }

    public int getFifthCount() {
        return fifthCount;
    }
}
