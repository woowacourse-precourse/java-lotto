package lotto.result;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    public static List<Integer> winningResult ;

    public LottoResult() {
        List<Integer> winningResult = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            winningResult.add(0);
        }
        this.winningResult = winningResult;
    }

    public static List<Integer> getWinningResult() {
        return winningResult;
    }

    public static void createResult(Integer luckyCount) {
        if (luckyCount >= 3) {
            winningResult.set(luckyCount, winningResult.get(luckyCount) + 1);
        }
    }
}
