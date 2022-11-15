package domain;

import lotto.Rank;

import java.util.Arrays;
import java.util.List;

public class WinningConfirmation {
    public int getMatchCount(List<Integer> lotto, List<Integer> user) {
        int matchCnt = 0;
        for (int i = 0; i < lotto.size(); i++) {
            if (lotto.contains(user.get(i))) {
                matchCnt++;
            }
        }
        return matchCnt;
    }

    public boolean isBonus(List<Integer> lotto, int bonusNum) {
        if (lotto.contains(bonusNum)) {
            return true;
        }
        return false;
    }

    public Rank getRank(int matchCount, boolean isBonus) {
        Rank rank = Arrays.stream(Rank.values())
                .filter(myRank -> myRank.getMatchCount() == matchCount)
                .findAny()
                .orElse(Rank.LOSE);
        if (rank == Rank.SECOND) {
            if (!isBonus) {
                rank = Rank.THIRD;
            }
        }
        return rank;
    }
}
