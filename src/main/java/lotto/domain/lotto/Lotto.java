package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import lotto.constant.LottoNumber;


public class Lotto {

    private final List<Integer> numbers;
    public static final String ERROR_MESSAGE_OF_LOTTO_NUMBERS = "[ERROR] 중복되지 않는 6개의 숫자여야 합니다.";

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != lottoNumberCount()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OF_LOTTO_NUMBERS);
        }
    }

    public static Integer firstLottoNumber() {
        return LottoNumber.LOTTO_NUMBER.getStart();
    }

    public static Integer lastLottoNumber() {
        return LottoNumber.LOTTO_NUMBER.getEnd();
    }

    public static Integer lottoNumberCount() {
        return LottoNumber.LOTTO_NUMBER.getCount();
    }

}
