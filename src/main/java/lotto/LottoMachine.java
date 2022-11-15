package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

import static lotto.Constants.*;

public class LottoMachine {
    private static void sortListInAscending(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    public static List<Integer> generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_VALUE_OF_LOTTO,
                MAX_VALUE_OF_LOTTO,
                NUM_OF_LOTTO);
        LottoMachine.sortListInAscending(numbers);
        return numbers;
    }
}
