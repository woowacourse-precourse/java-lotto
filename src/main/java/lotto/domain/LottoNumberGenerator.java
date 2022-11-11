package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {

    public static List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);

        return numbers;
    }
}
