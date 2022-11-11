package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generator {
    private static final int START_NUMBER_INCLUSIVE = 1;
    private static final int END_NUMBER_INCLUSIVE = 45;
    private static final int COUNT = 6;

    public static List<Integer> LottoNumbers() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(
                        START_NUMBER_INCLUSIVE, END_NUMBER_INCLUSIVE, COUNT
                ));
        Collections.sort(numbers);
        return numbers;
    }
}
