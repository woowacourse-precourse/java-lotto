package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.util.constants.WinningScore;

public class LottoResult {

    private Map<WinningScore, Integer> winningScore;

    public LottoResult() {
        this.winningScore = new HashMap<>() {{
            put(WinningScore.THREE, 0);
            put(WinningScore.FOUR, 0);
            put(WinningScore.FIVE, 0);
            put(WinningScore.BONUS, 0);
            put(WinningScore.SIX, 0);
        }};
    }

    public Map<WinningScore, Integer> getWinningScore() {
        return this.winningScore;
    }

    public void computeWinningScore(List<Lotto> userLottoTickets, Lotto winningLotto) {
        for (Lotto userLotto : userLottoTickets) {
            WinningScore winningScore = compareLottoNumber(userLotto.getNumbers(), winningLotto.getNumbers());
            this.winningScore.put(winningScore, this.winningScore.get(winningScore) + 1);
        }
    }

    public WinningScore compareLottoNumber(List<Integer> userLotto, List<Integer> winningLotto) {
        int count = (int) userLotto.stream().filter(num -> winningLotto.contains(num)).count();
        return WinningScore.getScore(count);
    }
}
