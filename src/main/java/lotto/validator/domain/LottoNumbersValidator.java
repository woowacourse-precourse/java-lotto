package lotto.validator.domain;

import lotto.exception.UtilClassCreateException;

import java.util.List;

public class LottoNumbersValidator extends NumberValidator {
    private static final String OUT_OF_LENGTH_EXCEPTION_MESSAGE = "[ERROR] 로또 번호의 개수는 6개여야 합니다.";
    private static final String DUPLICATE_NUMBER_EXIST_EXCEPTION_MESSAGE = "[ERROR] 중복된 숫자는 존재할 수 없습니다.";
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final int LENGTH_OF_LOTTO_NUMBERS = 6;
    
    private LottoNumbersValidator() {
        throw new UtilClassCreateException();
    }
    
    public static void validate(List<Integer> lottoNumbers) {
        validateOutOfLength(lottoNumbers);
        validateExistDuplicateNumber(lottoNumbers);
        validateOutOfRange(lottoNumbers);
    }
    
    private static void validateOutOfLength(final List<Integer> lottoNumbers) {
        if (isDifferentLength(lottoNumbers.size(), LENGTH_OF_LOTTO_NUMBERS)) {
            throw new IllegalArgumentException(OUT_OF_LENGTH_EXCEPTION_MESSAGE);
        }
    }
    
    private static void validateExistDuplicateNumber(final List<Integer> lottoNumbers) {
        if (isDifferentLength(lottoNumbers.size(), lengthAfterDeduplication(lottoNumbers))) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXIST_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isDifferentLength(final int lottoNumbersLength, final int lengthToCompare) {
        return lottoNumbersLength != lengthToCompare;
    }
    
    private static int lengthAfterDeduplication(final List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .distinct()
                .count();
    }
    
    private static void validateOutOfRange(final List<Integer> lottoNumbers) {
        if (isExistAnythingOutOfRange(lottoNumbers)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isExistAnythingOutOfRange(final List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(NumberValidator::isOutOfRange);
    }
}
