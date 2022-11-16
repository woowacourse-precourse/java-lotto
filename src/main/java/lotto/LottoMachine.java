package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Constants.*;

public class LottoMachine {
    private static List<Integer> sortListInAscending(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public static List<Integer> generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_VALUE_OF_LOTTO,
                MAX_VALUE_OF_LOTTO,
                NUM_OF_LOTTO);

        return LottoMachine.sortListInAscending(numbers);
    }
}
