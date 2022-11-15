package lotto.domain;

import lotto.enumeration.NumberType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TotalPrizeNumbers {

    private static final String PRIZENUMBER_SIZE_IS_NOT_SIX = "당첨 번호의 개수가 6개가 아닙니다.";
    private static final String DUPLICATE_PRIZENUMBER_EXISTS = "당첨 번호 중 중복된 숫자가 포함되었습니다.";
    private static final String PRIZENUMEBR_IS_NOT_IN_RANGE = "당첨 번호가 1부터 45까지의 범위 밖의 숫자가 포함되었습니다.";
    private static final String BONUSNUMEBR_IS_NOT_IN_RANGE = "보너스 번호가 1부터 45까지의 범위 밖의 숫자가 포함되었습니다.";
    private static final String BONUSNUMBER_OVERLAPS = "보너스 번호가 입력한 당첨 번호 중 하나와 중복됩니다.";
    private static final int MINIMUM_PRIZENUMBER = 1;
    private static final int MAXIMUM_PRIZENUMBER = 45;
    private static final int LOTTO_TOTAL_COUNT = 6;

    private final List<PrizeNumber> totalPrizeNumbers;

    public TotalPrizeNumbers(List<Integer> normalNumbers, Integer bonusNumber) {
        this.totalPrizeNumbers = createTotalPrizeNumbers(normalNumbers, bonusNumber);
    }

    public static void validateNormalNumbers(List<Integer> normalNumbers) {
        Set<Integer> uniquePrizeNumbers = new HashSet<>(normalNumbers);
        if (normalNumbers.size() != LOTTO_TOTAL_COUNT) {
            throw new IllegalArgumentException(PRIZENUMBER_SIZE_IS_NOT_SIX);
        }
        if (uniquePrizeNumbers.size() != normalNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_PRIZENUMBER_EXISTS);
        }
        for (Integer prizeNumber : normalNumbers) {
            if (prizeNumber < MINIMUM_PRIZENUMBER || prizeNumber > MAXIMUM_PRIZENUMBER) {
                throw new IllegalArgumentException(PRIZENUMEBR_IS_NOT_IN_RANGE);
            }
        }
    }

    public static void validateBonusNumber(Integer bonusNumber, List<Integer> prizeNumbers) {
        if (bonusNumber < MINIMUM_PRIZENUMBER || bonusNumber > MAXIMUM_PRIZENUMBER) {
            throw new IllegalArgumentException(BONUSNUMEBR_IS_NOT_IN_RANGE);
        }
        if (prizeNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUSNUMBER_OVERLAPS);
        }
    }

    private List<PrizeNumber> createTotalPrizeNumbers(List<Integer> normalNumbers, Integer bonusNumber) {
        List<PrizeNumber> totalPrizeNumbers = new ArrayList<>();

        for (Integer normalNumber : normalNumbers) {
            totalPrizeNumbers.add(new PrizeNumber(normalNumber, NumberType.NORMAL));
        }
        totalPrizeNumbers.add(new PrizeNumber(bonusNumber, NumberType.BOUNS));

        return totalPrizeNumbers;
    }

    public List<PrizeNumber> getNormalNumbers() {
        return this.totalPrizeNumbers.stream()
                .filter(PrizeNumber::isNormal)
                .collect(Collectors.toList());
    }

    public List<PrizeNumber> getTotalPrizeNumbers() {
        return new ArrayList<>(totalPrizeNumbers);
    }

    public int getBonusNumber() {
        return totalPrizeNumbers.stream()
                .filter(PrizeNumber::isBonus)
                .map(PrizeNumber::getPrizeNumber)
                .findFirst().get();
    }
}
