package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Utils {
    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (!validateNumbersRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean validateNumbersRange(List<Integer> numbers) {
        for (int n : numbers) {
            if (n < LottoInfo.START_NUMBER.getValue() || n > LottoInfo.END_NUMBER.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> pickUnique6Numbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoInfo.START_NUMBER.getValue(),
                LottoInfo.END_NUMBER.getValue(),
                LottoInfo.NUMBER_COUNT.getValue()
        );
    }
}
