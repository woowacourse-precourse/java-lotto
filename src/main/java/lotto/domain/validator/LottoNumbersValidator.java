package lotto.domain.validator;

import java.util.List;

public class LottoNumbersValidator {
    private static final String UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE = "생성할 수 없는 유틸 클래스입니다.";
    private static final int LENGTH_OF_LOTTO_NUMBERS = 6;
    
    private LottoNumbersValidator() {
        throw new IllegalStateException(UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    public static void validate(List<Integer> numbers) {
        validateOutOfLength(numbers);
        validateExistDuplicateNumber(numbers);
        validateOutOfRange(numbers);
    }
    
    private static void validateOutOfLength(final List<Integer> numbers) {
        if (isOutOfLength(numbers)) {
            throw new IllegalArgumentException();
        }
    }
    
    private static boolean isOutOfLength(final List<Integer> numbers) {
        return isSameLength(numbers.size(), LENGTH_OF_LOTTO_NUMBERS);
    }
    
    private static void validateExistDuplicateNumber(final List<Integer> numbers) {
        if (isSameLength(numbers.size(), lengthAfterDeduplication(numbers))) {
            throw new IllegalArgumentException();
        }
    }
    
    private static boolean isSameLength(final int lottoNumbersLength, final int lengthToCompare) {
        return lottoNumbersLength != lengthToCompare;
    }
    
    private static int lengthAfterDeduplication(final List<Integer> numbers) {
        return (int) numbers.stream()
                .distinct()
                .count();
    }
    
    private static void validateOutOfRange(final List<Integer> numbers) {
        if (isExistAnythingOutOfRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }
    
    private static boolean isExistAnythingOutOfRange(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(LottoNumbersValidator::isOutOfRange);
    }
    
    private static boolean isOutOfRange(final Integer lottoNumber) {
        return lottoNumber < 1 || lottoNumber > 45;
    }
}
