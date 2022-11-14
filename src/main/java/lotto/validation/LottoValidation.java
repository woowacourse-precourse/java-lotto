package lotto.validation;

import java.util.List;

public class LottoValidation {
    public static final int QUANTITY_OF_DIGITS = 6;

    public void validateQuantityOfDigits(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != QUANTITY_OF_DIGITS) {
            throw new IllegalArgumentException("[ERROR] 번호의 개수는 6개여야 합니다.");
        }
    }
}
