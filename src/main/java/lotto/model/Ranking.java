package lotto.model;

import lotto.enums.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ranking {
    private static final Map<Rank, Integer> ranks = new HashMap<>();

    public Ranking(List<Lotto> userLotto, WinningNumbers winningNumbers) {
        initRanking();
        setRanking(userLotto, winningNumbers);
    }
    private void setRanking(List<Lotto> userLotto, WinningNumbers winningNumbers) {
        Rank rank;
        int ball = 0;
        boolean bonus = false;
        for(Lotto lotto: userLotto) {
            ball = countNumbers(lotto, winningNumbers);
            if(ball == 5) bonus = hasBonus(lotto, winningNumbers);
            rank = getRank(ball, bonus);
            ranks.put(rank, ranks.get(rank) + 1);
        }
    }
    private void initRanking() {
        for(Rank rank: Rank.values()) {
            ranks.put(rank, 0);
        }
    }
    private int countNumbers(Lotto lotto, WinningNumbers winningNumbers) {
        List<Integer> winNum = winningNumbers.getWinningNumbers();

        List<Integer> userNum = lotto.getLotto();
        int cnt = 0;
        for(int num: userNum) {
            if(winNum.contains(num)) cnt++;
        }
        return cnt;
    }
    private boolean hasBonus(Lotto lotto, WinningNumbers winningNumbers) {
        int bonus = winningNumbers.getBonusNumber();
        List<Integer> userNum = lotto.getLotto();

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
    public Map<Rank, Integer> getRanking() {
        return ranks;
    }
}
