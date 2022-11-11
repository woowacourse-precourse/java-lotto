package lotto.domain;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public enum ScoreManager {
    THREE(5_000),
    FOUR(50_000),
    FIVE(1_500_000),
    FIVE_BONUS(30_000_000),
    SIX(2_000_000_000);

    private final int price;

    ScoreManager(int price) {
        this.price = price;
    }

    public static List<ScoreManager> makePrize(WinningLotto winningLotto, UserLotto userLotto) {
        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < userLotto.size(); i++) {
            int result = winningLotto.grade(userLotto.getLottoAt(i));
            scores.add(result);
        }
//        System.out.println(scores);
        return new ArrayList<>();
    }
}
