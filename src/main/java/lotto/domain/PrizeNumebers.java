package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrizeNumebers {

    private static final String PRIZENUMBER_SIZE_IS_NOT_SIX = "당첨 번호의 개수가 6개가 아닙니다.";
    private static final String DUPLICATE_PRIZENUMBER_EXISTS = "당첨 번호 중 중복된 숫자가 포함되었습니다.";
    private static final String PRIZENUMEBR_IS_NOT_IN_RANGE = "당첨 번호가 1부터 45까지의 범위 밖의 숫자가 포함되었습니다.";
    private static final int MINIMUM_PRIZENUMBER = 1;
    private static final int MAXIMUM_PRIZENUMBER = 45;
    private static final int LOTTO_TOTAL_COUNT = 6;

    public static void validatePrizeNumbers(List<Integer> prizeNumbers) {
        Set<Integer> uniquePrizeNumbers = new HashSet<>(prizeNumbers);
        if (prizeNumbers.size() != LOTTO_TOTAL_COUNT) {
            throw new IllegalArgumentException(PRIZENUMBER_SIZE_IS_NOT_SIX);
        }
        if (uniquePrizeNumbers.size() != prizeNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_PRIZENUMBER_EXISTS);
        }
        for (Integer prizeNumber : prizeNumbers) {
            if (prizeNumber < MINIMUM_PRIZENUMBER || prizeNumber > MAXIMUM_PRIZENUMBER) {
                throw new IllegalArgumentException(PRIZENUMEBR_IS_NOT_IN_RANGE);
            }
        }
    }
}
