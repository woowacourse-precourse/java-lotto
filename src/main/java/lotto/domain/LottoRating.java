package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRating {
    private final List<Lotto> lottoBunch;
    private final WinningLotto winningLotto;

    private Map<String, Integer> winningCountRepository = new HashMap<>();

    public LottoRating(List<Lotto> lottoTicket, WinningLotto winningLotto) {
        this.lottoBunch = lottoTicket;
        this.winningLotto = winningLotto;
    }

    public void rate() {
        for (Lotto lotto : lottoBunch) {
            int matchingCount = compareLotto(lotto);
        }
    }

    public int compareLotto(Lotto lotto) {
        int matchingCount = 0;
        for (Integer winningNumber : winningLotto.getLotto().getNumbers()) {
            if (lotto.getNumbers().contains(winningNumber)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    public Map<String, Integer> getWinningCountRepository() {
        return winningCountRepository;
    }
}
