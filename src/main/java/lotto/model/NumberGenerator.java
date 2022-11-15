package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class NumberGenerator {
    public List<Integer> createRandomLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }
}
