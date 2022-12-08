package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WinningLottoTicket {
    private Map<WinningLotto, Integer> winningLottoCount;

    public WinningLottoTicket() {
        winningLottoCount = new EnumMap<>(WinningLotto.class);
        Arrays.stream(WinningLotto.values()).forEach(winningLotto -> winningLottoCount.put(winningLotto, 0));
    }

    public Map<WinningLotto, Integer> getWinningLottoCount() {
        return winningLottoCount;
    }

    public void countWinningLotto(WinningLotto winningLotto) {
        winningLottoCount.put(winningLotto, winningLottoCount.get(winningLotto) + 1);
    }
}
