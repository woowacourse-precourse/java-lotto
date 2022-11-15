package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.Error;
import lotto.constants.Number;

public class LottoNumber {
    public static void exceptionDuplication(List<Integer> lotto) {
        Set<Integer> lottoSet = new HashSet<>(lotto);

        if (lottoSet.size() != lotto.size()) {
            throw new IllegalArgumentException(Error.DUPLICATE_LOTTOS_NUM.getMsg());
        }
    }

    public static void exceptionRange(List<Integer> lotto) {
        int rangeStart = Number.RANGE_START.getNumber();
        int rangeEnd = Number.RANGE_END.getNumber();
        for (int i = 0; i < lotto.size(); i++) {
            if (!(rangeStart <= lotto.get(i) && lotto.get(i) <= rangeEnd)) {
                throw new IllegalArgumentException(Error.WRONG_LOTTOS_RANGE.getMsg());
            }
        }
    }

    public static void exceptionSize(List<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException(Error.WRONG_LOTTOS_LENGTH.getMsg());
        }
    }
}
