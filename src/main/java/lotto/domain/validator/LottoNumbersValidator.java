package lotto.domain.validator;

import java.util.List;

public class LottoNumbersValidator {
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호의 개수는 6개여야 합니다.";
    private static final String DUPLICATE_NUMBER_EXIST_EXCEPTION_MESSAGE = "[ERROR] 중복된 숫자는 존재할 수 없습니다.";
    private static final String UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE = "생성할 수 없는 유틸 클래스입니다.";
    private static final int LENGTH_OF_LOTTO_NUMBERS = 6;
    
    private LottoNumbersValidator() {
        throw new IllegalStateException(UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    public static void validate(List<Integer> lottoNumbers) {
        validateOutOfLength(lottoNumbers);
        validateExistDuplicateNumber(lottoNumbers);
        validateOutOfRange(lottoNumbers);
    }
    
    private static void validateOutOfLength(final List<Integer> lottoNumbers) {
        if (isOutOfLength(lottoNumbers)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isOutOfLength(final List<Integer> lottoNumbers) {
        return isSameLength(lottoNumbers.size(), LENGTH_OF_LOTTO_NUMBERS);
    }
    
    private static void validateExistDuplicateNumber(final List<Integer> lottoNumbers) {
        if (isSameLength(lottoNumbers.size(), lengthAfterDeduplication(lottoNumbers))) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXIST_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isSameLength(final int lottoNumbersLength, final int lengthToCompare) {
        return lottoNumbersLength != lengthToCompare;
    }
    
    private static int lengthAfterDeduplication(final List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .distinct()
                .count();
    }
    
    private static void validateOutOfRange(final List<Integer> lottoNumbers) {
        if (isExistAnythingOutOfRange(lottoNumbers)) {
            throw new IllegalArgumentException();
        }
    }
    
    private static boolean isExistAnythingOutOfRange(final List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(LottoNumbersValidator::isOutOfRange);
    }
    
    private static boolean isOutOfRange(final Integer lottoNumber) {
        return lottoNumber < 1 || lottoNumber > 45;
    }
}
