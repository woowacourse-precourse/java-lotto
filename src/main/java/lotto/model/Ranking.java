package lotto.model;

import lotto.Enum.Rank;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Ranking {
    private final Map<Rank, Integer> ranks = new HashMap<>();

    public Ranking(List<Lotto> userLotto, WinningNumbers winningNumbers) {
        initRanking();
        setRanking(userLotto, winningNumbers);
    }

    public Map<Rank, Integer> getRanking() {
        return ranks;
    }

    private void setRanking(List<Lotto> userLotto, WinningNumbers winningNumbers) {
        Rank rank;
        boolean bonus = false;
        int hitNumber = 0;
        for (Lotto lotto : userLotto) {
            hitNumber = countNumbers(lotto, winningNumbers);
            if (hitNumber == 5) bonus = hasBonusNumber(lotto, winningNumbers);
            rank = getRank(hitNumber, bonus);
            ranks.put(rank, ranks.get(rank) + 1);
        }
    }

    private Map<Rank, Integer> initRanking() {
        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }
        return ranks;
    }

    private int countNumbers(Lotto lotto, WinningNumbers winningNumbers) {
        List<Integer> winNum = winningNumbers.getWinningNumbers();
        List<Integer> userNum = lotto.getLottoNumbers();
        int cnt = 0;
        for(int num: userNum) {
            if(winNum.contains(num)) cnt++;
        }
        return cnt;
    }

    private boolean hasBonusNumber(Lotto lotto, WinningNumbers winningNumbers) {
        int bonus = winningNumbers.getBonusNumber();
        List<Integer> userNum = lotto.getLottoNumbers();

        for(int num: userNum) {
            if(num == bonus) return true;
        }
        return false;
    }

    private Rank getRank(int ball, boolean bonus) {
        if(ball == 6) return Rank.FIRST;
        if(ball == 5 && bonus) return Rank.SECOND;
        if(ball == 5) return Rank.THIRD;
        if(ball == 4) return Rank.FOURTH;
        if(ball == 3) return Rank.FIFTH;
        return Rank.DEFAULT;
    }
}
