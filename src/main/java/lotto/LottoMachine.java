package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.Constants.*;

public class LottoMachine {
    public static List<Integer> generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_VALUE_OF_LOTTO,
                MAX_VALUE_OF_LOTTO,
                NUM_OF_LOTTO);
        return numbers;
    }
}
