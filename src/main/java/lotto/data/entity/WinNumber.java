package lotto.data.entity;

import java.util.Collections;
import java.util.Set;
import lotto.type.ConstantNumberType;
import lotto.type.ExceptionType;
import utils.Validator.CollectionValidator;
import utils.Validator.IntegerValidator;

public class WinNumber {

    private Long roundId;
    private final Set<Integer> winNumbers;
    private final Integer bonusNumber;

    WinNumber(Set<Integer> winNumbers, Integer bonusNumber) {
        validate(winNumbers, bonusNumber);
        this.winNumbers = Collections.unmodifiableSet(winNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Set<Integer> winNumbers, Integer bonusNumber) {
        if (winNumbers == null) {
            throw new NullPointerException("[ERROR] 당첨 번호를 받지 못했습니다.");
        }
        if (bonusNumber == null) {
            throw new NullPointerException("[ERROR] 보너스 번호를 받지 못했습니다.");
        }
        if (hasWrongSize(winNumbers)) {
            throw ExceptionType.COUNT.getException();
        }
        if (hasNumberOutOfRange(winNumbers) || isNumberOutOfRange(bonusNumber)) {
            throw ExceptionType.RANGE.getException();
        }
        if (containsNumber(winNumbers, bonusNumber)) {
            throw ExceptionType.DUPLICATE.getException();
        }
    }

    private static boolean hasWrongSize(Set<Integer> numbers) {
        return !CollectionValidator.hasSizeOf(numbers, ConstantNumberType.COUNT.getValue());
    }

    private static boolean hasNumberOutOfRange(Set<Integer> numbers) {
        int minimum = ConstantNumberType.MIN.getValue();
        int maximum = ConstantNumberType.MAX.getValue();
        return !numbers.stream().allMatch(number -> IntegerValidator.isInBetween(number, minimum, maximum));
    }

    private static boolean isNumberOutOfRange(int number) {
        int minimum = ConstantNumberType.MIN.getValue();
        int maximum = ConstantNumberType.MAX.getValue();
        return !IntegerValidator.isInBetween(number, minimum, maximum);
    }

    private static boolean containsNumber(Set<Integer> numbers, int number) {
        return numbers.contains(number);
    }

    public Set<Integer> getWinNumbers() {
        return winNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Long getRoundId() {
        return roundId;
    }

    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    /**
     * 입력 단계의 순서가 바뀌거나, 앞뒤로 단계를 건너뛰어도 영향을 받지 않도록
     * 빌더 패턴을 사용했습니다.
     */
    public static WinNumberBuilder builder() {
        return new WinNumberBuilder();
    }

    public static class WinNumberBuilder {

        private Set<Integer> winNumbers;
        private Integer bonusNumber;

        private WinNumberBuilder() {
        }

        public WinNumberBuilder winNumbers(Set<Integer> winNumbers) {
            this.winNumbers = winNumbers;
            return this;
        }

        public WinNumberBuilder bonusNumber(Integer bonusNumber) {
            this.bonusNumber = bonusNumber;
            return this;
        }

        public WinNumber build() {
            return new WinNumber(winNumbers, bonusNumber);
        }
    }
}
