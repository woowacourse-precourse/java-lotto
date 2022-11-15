package lotto;

import net.bytebuddy.asm.Advice;

import java.util.List;

public class Lotto {

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String ERROR_LOTTO_NUM_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_LOTTO_CNT_MESSAGE = "로또 번호 개수를 맞춰 입력해 주세요.(당첨 번호는 6개, 보너스 번호는 1개)";

    private static final String ERROR_LOTTO_NUM_DUPLICATE = "로또 번호는 중복되지 않게 입력해 주세요";
    private static final Integer ERROR_LOTTO_START = 1;
    private static final Integer ERROR_LOTTO_END = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try {
            isSizeSix(numbers);
            isLottoNumbersInRange(numbers);
            isLottoNumbersDuplicated(numbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void isSizeSix(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_LOTTO_CNT_MESSAGE);
        }
    }

    private void isLottoNumbersInRange(List<Integer> numbers) throws IllegalArgumentException {
        for(int i=0; i<6; i++){
            if(numbers.get(i) < ERROR_LOTTO_START || numbers.get(i) > ERROR_LOTTO_END){
                throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_LOTTO_NUM_MESSAGE);
            }
        }
    }

    private void isLottoNumbersDuplicated(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_LOTTO_NUM_DUPLICATE);
        }
    }
}
