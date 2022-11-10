package lotto.Model;

import java.util.ArrayList;
import java.util.List;


public class LottoSystem {

    private static final List<Integer> winningStatics = new ArrayList<>(8);

    public static List<Integer> getWinningStatics() {
        return winningStatics;
    }

    public static void lottoSystem(List<Integer> winningNumber, int bonusNumber) {
        var temp = RandomLotto.getLottoNumberList();
        temp.stream()
                .mapToInt(i -> calcScore(winningNumber, bonusNumber, i))
                .forEach(winningStatics::add);
    }

    private static int calcScore(List<Integer> winningNumber, int bonusNumber, List<Integer> i) {
        int score = 0;
        for (int j : winningNumber) {
            if (i.contains(j)) score += 1;
        }
        if (score == 5 && i.contains(bonusNumber)) {
            score += 2;
        }
        return score;
    }
}
