package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator {

    public static List<Integer> randomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
