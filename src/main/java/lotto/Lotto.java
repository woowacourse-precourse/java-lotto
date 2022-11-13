package lotto;

import static lotto.Config.LOTTO_LENGTH;

import java.util.List;
import lotto.utils.Logger;
import lotto.utils.Logger.LogType;

public class Lotto {
    private static final String EXISTED_LOTTO_ERROR_MESSAGE = "로또 번호가 존재하지 않습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkExistedLotto(numbers);
        checkLottoLength(numbers);
        this.numbers = numbers;
    }

    private void checkExistedLotto(List<Integer> numbers){
        if(numbers == null){
            Logger.log(EXISTED_LOTTO_ERROR_MESSAGE, LogType.ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void checkLottoLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRangeNumber(List<Integer> numbers) {
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
    }
}
