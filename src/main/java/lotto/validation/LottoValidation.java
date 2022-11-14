package lotto.validation;

import java.util.List;

public class LottoValidation {
    public static final int QUANTITY_OF_DIGITS = 6;
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;

    public void validateQuantityOfDigits(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != QUANTITY_OF_DIGITS) {
            throw new IllegalArgumentException("[ERROR] 번호의 개수는 6개여야 합니다.");
        }
    }

    public void validateNoDuplicateNumbers(List<Integer> lottoNumbers) {
        for (int currIdx = 0; currIdx < QUANTITY_OF_DIGITS; currIdx++) {
            int nextIdx = currIdx + 1;
            List<Integer> ElementsAfterCurrIdx = lottoNumbers.subList(nextIdx, QUANTITY_OF_DIGITS);

            if (ElementsAfterCurrIdx.contains(lottoNumbers.get(currIdx))) {
                throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력할 수 없습니다.");
            }
        }
    }

    public void validateNumbersRange(List<Integer> lottoNumbers) {
        for (int number : lottoNumbers) {
            if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
                throw new IllegalArgumentException("[ERROR] 번호의 범위는 1이상 45이하여야 합니다.");
            }
        }
    }

}
