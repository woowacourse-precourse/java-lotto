package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoNumberGenerator {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int COUNT = 6;

    public LottoNumberGenerator() {
    }

    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT));
        numbers.sort(Comparator.naturalOrder());
        return Collections.unmodifiableList(numbers);
    }
}
