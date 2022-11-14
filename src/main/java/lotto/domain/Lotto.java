package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 로또 번호는 6자리 숫자여야 합니다.";
    private static final String ONE_BETWEEN_NINE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String OVERLAP_ERROR_MESSAGE = "[ERROR] 로또 번호에 중복된 숫자가 존재합니다.";
    public final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
        check1Between45(numbers);
        checkOverlap(numbers);
    }

    private void check1Between45(List<Integer> numbers){
        for (Integer num : numbers){
            if (num < 1 || num > 45){
                throw new IllegalArgumentException(ONE_BETWEEN_NINE_ERROR_MESSAGE);
            }
        }
    }

    private void checkOverlap(List<Integer> numbers){
        if (new HashSet<Integer>(numbers).size() != numbers.size()){
            throw new IllegalArgumentException(OVERLAP_ERROR_MESSAGE);
        }
    }
}
