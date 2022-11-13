package lotto;

import static lotto.Config.*;

import java.util.List;
import lotto.utils.Logger;
import lotto.utils.Logger.LogType;

public class Lotto {
    private static final String EXISTED_LOTTO_ERROR_MESSAGE = "로또 번호가 존재하지 않습니다.";
    private static final String LOTTO_LENGTH_ERROR_MESSAGE = "로또 번호는 " + LOTTO_LENGTH + "개의 숫자로 이루어져야 합니다.";
    private static final String RANGE_NUMBER_ERROR_MESSAGE = "로또 번호는 " + LOTTO_RANGE_START_NUMBER + "이상 "
            + LOTTO_RANGE_END_NUMBER + "이하 범위이여야 합니다." ;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkExistedLotto(numbers);
        checkLottoLength(numbers);
        checkRangeNumber(numbers);
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
            Logger.log(LOTTO_LENGTH_ERROR_MESSAGE, LogType.ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void checkRangeNumber(List<Integer> numbers) {
        if(!numbers.stream().allMatch(number ->
                (LOTTO_RANGE_START_NUMBER <= number && LOTTO_RANGE_END_NUMBER >= number))){
            Logger.log(RANGE_NUMBER_ERROR_MESSAGE, LogType.ERROR);
            throw new IllegalArgumentException();
        };
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
    }
}
