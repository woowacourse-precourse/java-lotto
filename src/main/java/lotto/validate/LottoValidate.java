package lotto.validate;

import java.util.Collections;
import java.util.List;

public class LottoValidate {
    static final String DUPLICATE_NUMBER_ERROR_MSG = "[ERROR] 중복된 숫자를 입력했습니다!";
    static final String SIZE_NUMBER_ERROR_MSG = "[ERROR] 로또 번호의 개수가 6개가 아닙니다!";
    static final String RANGE_ERROR_MSG = "[ERROR] 1~45범위로 숫자를 입력해주세요!";
    static final int LOTTO_SIZE = 6;
    static final int START_OF_RANGE = 1;
    static final int END_OF_RANGE=45;
    static final int DUPLICATE_CRITERIA=1;

    public void validate(List<Integer> numbers){
        sizeValidate(numbers);
        duplicateValidate(numbers);
        rangeValidate(numbers);
    }

    private void sizeValidate(List<Integer> numbers){
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_NUMBER_ERROR_MSG);
        }
    }

    private void duplicateValidate(List<Integer> numbers) {
        for (int number : numbers) {
            if (Collections.frequency(numbers, number) > DUPLICATE_CRITERIA) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MSG);
            }
        }
    }

    private void rangeValidate(List<Integer> numbers){
        for (int number : numbers) {
            if(number<START_OF_RANGE || number>END_OF_RANGE){
                throw new IllegalArgumentException(RANGE_ERROR_MSG);
            }
        }
    }
}
