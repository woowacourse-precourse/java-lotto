package lotto.util;

import static lotto.Constants.END_NUMBER_INCLUSIVE;
import static lotto.Constants.LOTTO_SIZE;
import static lotto.Constants.START_NUMBER_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generator {
    public static List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(
                        START_NUMBER_INCLUSIVE,
                        END_NUMBER_INCLUSIVE,
                        LOTTO_SIZE
                ));
        Collections.sort(numbers);
        return numbers;
    }
}
