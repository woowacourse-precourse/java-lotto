package lotto.validation;

import java.util.List;

public class LottoValidation {
    public static final int QUANTITY_OF_DIGITS = 6;

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


}
