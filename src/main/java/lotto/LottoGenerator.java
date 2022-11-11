package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {

    static final int LOTTO_MAX_LEN = 6;
    static final int START_RANGE = 1;
    static final int FINAL_RANGE = 45;

    public List<Integer> createRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_RANGE, FINAL_RANGE, LOTTO_MAX_LEN);
        sortByNaturalOrder(numbers);
        return numbers;
    }

    private void sortByNaturalOrder(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

}
