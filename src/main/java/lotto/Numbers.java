package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Constants.*;

public class Numbers {
    public static final List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(
                        START_NUMBER_INCLUSIVE, END_NUMBER_INCLUSIVE, LOTTO_SIZE
                ));
        Collections.sort(numbers);
        return numbers;
    }
}
