package lotto;

import java.util.HashMap;

public class Judgment {
    private User user;
    private WinningNumbers winningNumbers;

    public Judgment(User user, WinningNumbers winningNumbers) {
        this.user = user;
        this.winningNumbers = winningNumbers;
    }

    public HashMap<Rank, Integer> calculateRank() {
        RankCounter rankCounter = new RankCounter();
        rankCounter.drawLotto(user, winningNumbers);
        return rankCounter.getRankCounter();
    }

}
