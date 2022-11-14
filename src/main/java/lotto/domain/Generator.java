package lotto.domain;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Generator {
    private final List<Integer> winNumber;

    public Generator() {
        winNumber = createWinNumber();
    }

    private List<Integer> createWinNumber() {
        return Randoms.pickUniqueNumbersInRange(
                Lotto.MINIMUM_NUMBER, Lotto.MAXIMUM_NUMBER, Lotto.SIZE_OF_NUMBERS);
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }
}
