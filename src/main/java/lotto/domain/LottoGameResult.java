package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoGameResult {

    private final Map<Rank, Integer> winningResult;

    public LottoGameResult(PlayerLotto playerLotto, WinningLotto winningLotto) {
        this.winningResult = createWinningResult(playerLotto, winningLotto);
    }

    private Map<Rank, Integer> createWinningResult(PlayerLotto playerLotto, WinningLotto winningLotto) {
        Map<Rank, Integer> result = new HashMap<>();

        for (Lotto lotto : playerLotto.getLottos()) {
            Rank rank = winningLotto.compare(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return result;
    }

    public Map<Rank, Integer> getWinningResult() {
        return winningResult;
    }
}
