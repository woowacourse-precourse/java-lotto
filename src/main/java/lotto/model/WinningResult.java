package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {
    public List<Integer> winningResult = new ArrayList<>(List.of(0, 0, 0, 0, 0));

    public WinningResult(int ticketAmount, Lottos lottos) {
        checkWinning(ticketAmount, lottos);
    }

    private void checkWinning(int ticketAmount, Lottos lottos) {
        for (int index = 0; index < ticketAmount; index++) {
            int sameNumber = lottos.getLottos(index).hasSameElement(LuckySix.luckySix);
            if (sameNumber == 3) {
                winningResult.set(0, winningResult.get(0) + 1);
            }
            if (sameNumber == 4) {
                winningResult.set(1, winningResult.get(1) + 1);
            }
            if (sameNumber == 5 && !lottos.getLottos(index).isIncludeBonus(LuckyBonus.luckyBonus)) {
                winningResult.set(2, winningResult.get(2) + 1);
            }
            if (sameNumber == 5 && lottos.getLottos(index).isIncludeBonus(LuckyBonus.luckyBonus)) {
                    winningResult.set(3, winningResult.get(3) + 1);
            }
            if (sameNumber == 6) {
                winningResult.set(4, winningResult.get(4) + 1);
            }
        }
    }
}
