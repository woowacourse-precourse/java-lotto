package lotto.domain.subaction;

import java.util.List;

public class WinningNumberPlace {
    public int judgement(List<Integer> random, int countLotto, int correctLotto) {
        for (int randomLocation = 0; randomLocation < random.size(); randomLocation++) {
            if (correctLotto == random.get(randomLocation)) {
                countLotto++;
            }
        }
        return countLotto;
    }
}
