package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Judgment {
    private User user;
    private WinningNumbers winningNumbers;
    private RankCounter rankCounter;

    public Judgment(User user, WinningNumbers winningNumbers) {
        this.user = user;
        this.winningNumbers = winningNumbers;
    }

    public RankCounter calculateRank() {
        this.rankCounter = new RankCounter();
        this.rankCounter.drawLotto(user, winningNumbers);
        return rankCounter;
    }

    public double calculateYield() {
        double investmentMoney = (double) user.getGameMoney();
        double totalPrizeMoney = (double) calculateTotalPrizeMoney();
        return totalPrizeMoney / investmentMoney;
    }

    private long calculateTotalPrizeMoney() {
        List<Rank> sortRanks = Rank.getSortRanks();
        long totalPrizeMoney = 0;
        for (Rank rank : sortRanks) {
            totalPrizeMoney = totalPrizeMoney + calculatePrizeMoney(rank);
        }
        return totalPrizeMoney;
    }

    private long calculatePrizeMoney(Rank rank) {
        int count = this.rankCounter.countRank(rank);
        long prizeMoney = rank.getPrizeMoney();
        return count * prizeMoney;
    }
}
