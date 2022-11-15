package lotto.domain;

import java.util.List;

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
        drawAllLotto();
        return rankCounter;
    }

    private void drawAllLotto() {
        for (int indexLotto = 0; indexLotto < user.getLottoCount(); indexLotto++) {
            Rank rank = drawLotto(indexLotto);
            rankCounter.addRank(rank);
        }
    }

    private Rank drawLotto(int indexLotto) {
        Lotto lotto = user.findLotto(indexLotto);
        return winningNumbers.rankingLotto(lotto);
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
