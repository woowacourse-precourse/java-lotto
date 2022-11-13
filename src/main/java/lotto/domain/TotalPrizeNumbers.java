package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TotalPrizeNumbers {

    private final String PRIZENUMBER_SIZE_IS_NOT_SIX = "당첨 번호의 개수가 6개가 아닙니다.";
    private final String DUPLICATE_PRIZENUMBER_EXISTS = "당첨 번호 중 중복된 숫자가 포함되었습니다.";
    private final String PRIZENUMEBR_IS_NOT_IN_RANGE = "당첨 번호가 1부터 45까지의 범위 밖의 숫자가 포함되었습니다.";
    private final String BONUSNUMBER_OVERLAPS = "보너스 번호가 입력한 당첨 번화 중 하나와 중복됩니다.";
    private final int MINIMUM_PRIZENUMBER = 1;
    private final int MAXIMUM_PRIZENUMBER = 45;
    private final int LOTTO_TOTAL_COUNT = 6;

    private final List<Integer> totalPrizeNumbers;

    public TotalPrizeNumbers(List<Integer> prizeNumbers, Integer bonusNumber) {
        validatePrizeNumbers(prizeNumbers);
        validateBonusNumber(bonusNumber, prizeNumbers);

        this.totalPrizeNumbers = createTotalPrizeNumbers(prizeNumbers, bonusNumber);
    }

    public void validatePrizeNumbers(List<Integer> prizeNumbers) {
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

    private void validateBonusNumber(Integer bonusNumber, List<Integer> prizeNumbers) {
        if (bonusNumber < MINIMUM_PRIZENUMBER || bonusNumber > MAXIMUM_PRIZENUMBER) {
            throw new IllegalArgumentException(PRIZENUMEBR_IS_NOT_IN_RANGE);
        }
        if (prizeNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(BONUSNUMBER_OVERLAPS);
        }
    }

    private List<Integer> createTotalPrizeNumbers(List<Integer> prizeNumbers, Integer bonusNumber) {
    }
}
