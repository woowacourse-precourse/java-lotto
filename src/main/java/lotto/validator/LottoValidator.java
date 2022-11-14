package lotto.validator;

import java.util.List;
import lotto.constant.LottoConstant;

public class LottoValidator {

    public static void validateWinningNumber(List<Integer> lottoNumbers) {
        validateDuplicateNumber(lottoNumbers);
        for (Integer integer : lottoNumbers) {
            if (integer > LottoConstant.MAX_LOTTO_NUMBER ||
                    integer < LottoConstant.LOW_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
    private static void validateDuplicateNumber(List<Integer> lottoNumbers) {
        long count = lottoNumbers.stream()
                .distinct()
                .count();
        if (count != LottoConstant.WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복된 정수를 입력하면 안됩니다.");
        }
    }
    public static void validateHasNumber(List<String> list) {
        String regex = "[0-9]+";
        for (String number : list) {
            if (!number.matches(regex)) {
                throw new IllegalArgumentException("[ERROR] 정수만 입력해야 합니다.");
            }
        }
    }
}
