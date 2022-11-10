package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumberGenerator {

    public static List<Integer> createDifferentRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(1, 45);
    }
}
