package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {
    private static int SAME_3 = 3;
    private static int SAME_4 = 4;
    private static int SAME_5 = 5;
    private static int SAME_6 = 6;

    public List<Integer> winningResult = new ArrayList<>(List.of(0, 0, 0, 0, 0));

    public WinningResult(int ticketAmount, List<Lotto> lottos, Lotto luckySix, int luckyBonus) {
        checkWinning(ticketAmount, lottos, luckySix, luckyBonus);
    }

    private void checkWinning(int ticketAmount, List<Lotto> lottos, Lotto luckySix, int luckyBonus) {
        for (int index = 0; index < ticketAmount; index++) {
            int sameNumber = lottos.get(index).hasSameElement(luckySix);
            boolean hasBonus = lottos.get(index).isIncludeBonus(luckyBonus);
            if (sameNumber == SAME_5 && hasBonus) {
                winningResult.set(3, winningResult.get(3) + 1);
                continue;
            }
            if (sameNumber >= SAME_3) {
                winningResult.set(sameNumber - 3, winningResult.get(sameNumber - 3) + 1);
            }
        }
    }
}
