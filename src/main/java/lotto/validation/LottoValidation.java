package lotto.validation;

import java.util.List;

public class LottoValidation {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String ERROR_INCORRECT_COUNT = "[ERROR] 로또 번호는 1~45까지 중 서로 다른 6자리 수여야 합니다.";
    private static final String ERROR_DUPLICATE = "[ERROR] 로또 번호가 중복입니다.";

    public LottoValidation() {

    }

    public void numberCountCheck(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_INCORRECT_COUNT);
        }
    }

    public void numberDuplicateCheck(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }
}
