package lotto;

import java.util.HashMap;
import java.util.Map;

public class Judgment {
    private User user;
    private WinningNumbers winningNumbers;

    public Judgment(User user, WinningNumbers winningNumbers) {
        this.user = user;
        this.winningNumbers = winningNumbers;
    }

    public RankCounter calculateRank() {
        RankCounter rankCounter = new RankCounter();
        rankCounter.drawLotto(user, winningNumbers);
        return rankCounter;
    }

}
