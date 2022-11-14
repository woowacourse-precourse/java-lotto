package lotto.domain.subaction;

import java.util.List;

public class WinningNumberPlace {
    public int judgement(List<Integer> random, int countLotto, int correctLotto) {
        for (Integer integer : random) {
            if (correctLotto == integer) {
                countLotto++;
            }
        }
        return countLotto;
    }
}
