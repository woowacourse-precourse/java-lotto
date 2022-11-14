package lotto;

import static lotto.Config.LOTTO_LENGTH;
import static lotto.Config.LOTTO_RANGE_END_NUMBER;
import static lotto.Config.LOTTO_RANGE_START_NUMBER;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final String EXISTED_LOTTO_ERROR_MESSAGE = "로또 번호가 존재하지 않습니다.";
    private static final String LOTTO_LENGTH_ERROR_MESSAGE = "로또 번호는 " + LOTTO_LENGTH + "개의 숫자로 이루어져야 합니다.";
    private static final String RANGE_NUMBER_ERROR_MESSAGE = "로또 번호는 " + LOTTO_RANGE_START_NUMBER + "이상 "
            + LOTTO_RANGE_END_NUMBER + "이하 범위이여야 합니다." ;
    private static final String DUPLICATED_NUMBER_ERROR_MESSAGE = "로또 번호에 중복된 숫자가 존재합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkExistedLotto(numbers);
        checkLottoLength(numbers);
        checkRangeNumber(numbers);
        checkDuplicatedNumber(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    private void checkExistedLotto(List<Integer> numbers){
        if(numbers == null){
            throw new IllegalArgumentException(EXISTED_LOTTO_ERROR_MESSAGE);
        }
    }

    private void checkLottoLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR_MESSAGE);
        }
    }

    private void checkRangeNumber(List<Integer> numbers) {
        if(!numbers.stream().allMatch(number ->
                (LOTTO_RANGE_START_NUMBER <= number && LOTTO_RANGE_END_NUMBER >= number))){
            throw new IllegalArgumentException(RANGE_NUMBER_ERROR_MESSAGE);
        };
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if(LOTTO_LENGTH != distinctCount){
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
