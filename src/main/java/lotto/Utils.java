package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    public static void validateLottoNumbers(List<Integer> numbers) {
        Set<Integer> overlapRemoveNumbers = new HashSet<>(numbers);
        if (numbers.size() != 6 || overlapRemoveNumbers.size() != 6) {
            throw new IllegalArgumentException(Error.COUNT_ERROR.getMessage());
        }
        validateNumbersRange(overlapRemoveNumbers);
    }

    private static void validateNumbersRange(Set<Integer> numbers) {
        for (int n : numbers) {
            if (n < LottoInfo.START_NUMBER.getValue() || n > LottoInfo.END_NUMBER.getValue()) {
                throw new IllegalArgumentException(Error.RANGE_ERROR.getMessage());
            }
        }
    }

    public static List<Integer> pickUnique6Numbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoInfo.START_NUMBER.getValue(),
                LottoInfo.END_NUMBER.getValue(),
                LottoInfo.NUMBER_COUNT.getValue());
    }
}
