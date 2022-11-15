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


}
