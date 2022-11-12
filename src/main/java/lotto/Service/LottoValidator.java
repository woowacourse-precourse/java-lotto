package lotto.Service;

import lotto.Model.ValidNumbers;

import java.util.List;

public class LottoValidator {

    private static final int MAX_LOTTO_SIZE = ValidNumbers.MAX_LOTTO_SIZE.getValue();
    private static final int MIN_LOTTO_RANGE = ValidNumbers.MIN_LOTTO_RANGE.getValue();
    private static final int MAX_LOTTO_RANGE = ValidNumbers.MAX_LOTTO_RANGE.getValue();

    // TODO: 에러메시지 표시
    public void validate(List<Integer> numbers) {
        int size = numbers.size();

        if (size != MAX_LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        boolean isDuplicated = numbers.stream()
                .distinct()
                .count() != size;

        if (isDuplicated) {
            throw new IllegalArgumentException();
        }

        long invalidCount = numbers.stream()
                .filter(num -> (num < MIN_LOTTO_RANGE || num > MAX_LOTTO_RANGE))
                .count();

        if (invalidCount > 0) {
            throw new IllegalArgumentException();
        }

        //TODO: 메소드 길이 15줄 이내로 줄이기
    }
}
