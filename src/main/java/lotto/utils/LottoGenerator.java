package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int START_VALUE = 1;
    private static final int END_VALUE = 45;
    private static final int SIZE = 6;

    public static List<Integer> getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_VALUE, END_VALUE, SIZE);

        Collections.sort(numbers);

        return numbers;
    }
}
