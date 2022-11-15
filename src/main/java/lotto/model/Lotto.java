package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final String LOTTO_DIGITS_ERROR = "[ERROR] 로또번호의 갯수가 6이 아닙니다.";
    public static final String LOTTO_DUPLICATION_ERROR = "[ERROR] 로또번호의 중복이 존재합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateHaveLotto6Digits(numbers);
        validateHaveLottoDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateHaveLotto6Digits(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_DIGITS_ERROR);
        }
    }

    private void validateHaveLottoDuplication(List<Integer> numbers){
        Set<Integer> checkDuplication = new HashSet<>();
        for(Integer number : numbers){
            if(!checkDuplication.add(number)){
                throw new IllegalArgumentException(LOTTO_DUPLICATION_ERROR);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
