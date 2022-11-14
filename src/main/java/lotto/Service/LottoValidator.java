package lotto.Service;

import lotto.Model.ValidNumbers;

import java.util.List;

public class LottoValidator {

    private static final int MAX_LOTTO_SIZE = ValidNumbers.MAX_LOTTO_SIZE.getValue();
    private static final int MIN_LOTTO_RANGE = ValidNumbers.MIN_LOTTO_RANGE.getValue();
    private static final int MAX_LOTTO_RANGE = ValidNumbers.MAX_LOTTO_RANGE.getValue();

    private static final String ERROR_HEADER = "[ERROR]";
    private static final String SIZE_ERROR_MESSAGE = ERROR_HEADER + " 6개의 숫자만 입력해주십시오.";
    private static final String DUPLICATION_ERROR_MESSAGE = ERROR_HEADER + " 중복되는 숫자는 입력할 수 없습니다.";
    private static final String RANGE_ERROR_MESSAGE = ERROR_HEADER + " 1~45 사이의 숫자만 입력해주십시오.";

    public void validate(List<Integer> numbers) {
        checkLottoSize(numbers);
        checkDuplicate(numbers);
        countInvalidNumber(numbers);
    }

    public void validate(List<Integer> numbers, int bonusNumber) {
        //TODO: 여기서 당첨 Lotto와 번호가 중복인지도 체크해야 한다.
        

    }

    public void checkLottoSize(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_SIZE) {
            System.out.print(SIZE_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void checkDuplicate(List<Integer> numbers) {
        boolean isDuplicated = numbers.stream()
                .distinct()
                .count() != numbers.size();

        if (isDuplicated) {
            System.out.print(DUPLICATION_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void countInvalidNumber(List<Integer> numbers) {
        long invalidCount = numbers.stream()
                .filter(num -> (num < MIN_LOTTO_RANGE || num > MAX_LOTTO_RANGE))
                .count();

        if (invalidCount > 0) {
            System.out.print(RANGE_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
