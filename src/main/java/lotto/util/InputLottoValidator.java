package lotto.util;

import java.util.Collections;
import java.util.List;

public class InputLottoValidator {

    private static int LOTTO_TOTAL_COUNT = 6;
    private static int VALID_NUMBER_COUNT = 1;

    public static void validateInputLotto(String inputLotto) {
        if (inputLotto.contains(" ")) throw new IllegalArgumentException("입력값에 공백이 없어야 합니다.");
        if (inputLotto.contains(",,")) throw new IllegalArgumentException("숫자가 ,로 구분되어 입력되어야 합니다.");
    }

    public static void validateLottoCount(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() !=LOTTO_TOTAL_COUNT) {
            throw new IllegalArgumentException("로또 번호가 " +LOTTO_TOTAL_COUNT+"개 입력되어야 합니다.");
        }
    }

    public static void validateDuplicateLottoNumber(List<Integer> lottoNumbers, Integer number) {
        if (Collections.frequency(lottoNumbers, number) >VALID_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호가 중복되지 않아야 합니다.");
        }
    }
}