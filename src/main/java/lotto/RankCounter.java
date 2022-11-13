package lotto;

import java.util.HashMap;

public class RankCounter {
    private HashMap<Rank, Integer> rankCounter;

    public RankCounter() {
        rankCounter = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCounter.put(rank, 0);
        }
    }

    public void drawLotto(User user, WinningNumbers winningNumbers) {
        Lotto lotto;
        int count;
        Rank rank;
        for (int indexLottos = 0; indexLottos < user.getLottoCount(); indexLottos++) {
            lotto = user.findLotto(indexLottos);
            rank = winningNumbers.rankingLotto(lotto);
            count = rankCounter.getOrDefault(rank, 0);
            rankCounter.put(rank, count + 1);
        }
    }
}
