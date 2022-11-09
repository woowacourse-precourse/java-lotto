package lotto.Model;

import java.util.ArrayList;
import java.util.List;


public class LottoSystem {

    public static List<Integer> getWinningStatics() {
        return winningStatics;
    }

    static List<Integer> winningStatics = new ArrayList<>(8);

    public static void lottoSystem(List<Integer> winningNumber, int bonusNumber) {

        for (List i : RandomLotto.getLottoNumberList()) {
            int score = calcScore(winningNumber, bonusNumber, i);
            winningStatics.add(score);
        }
    }

    private static int calcScore(List<Integer> winningNumber, int bonusNumber, List i) {
        int score = 0;
        for (int j : winningNumber) {
            if (i.contains(j)) score++;
        }
        if (score == 5 && i.contains(bonusNumber)) {
            score += 2;
        }
        return score;
    }
}
