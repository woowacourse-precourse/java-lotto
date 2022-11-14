package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;
    private static final String SIZE_CHECK_ERROR = "[ERROR] 입력한 번호가 6자리가 아닙니다.";
    private static final String DUPLICATE_CHECK_ERROR = "[ERROR] 입력한 번호 중 중복하는 번호가 있습니다.";
    private static final String LIMIT_CHECK_ERROR = "[ERROR] 입력한 번호 중 1~45 범위를 벗어나는 번호가 있습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        sizeCheck(numbers);
        duplicateCheck(numbers);
        limitCheck(numbers);
    }

    private void sizeCheck(List<Integer> numbers) {
        if(numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_CHECK_ERROR);
        }
    }

    private void duplicateCheck(List<Integer> numbers) {
        List<Integer> tempNumbers = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i++) {
            if(tempNumbers.contains(numbers.get(i))) {
                throw new IllegalArgumentException(DUPLICATE_CHECK_ERROR);
            }
            tempNumbers.add(numbers.get(i));
        }
    }
    private void limitCheck(List<Integer> numbers) {
        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) > LOTTO_END || numbers.get(i) < LOTTO_START) {
                throw new IllegalArgumentException(LIMIT_CHECK_ERROR);
            }
        }
    }

}
