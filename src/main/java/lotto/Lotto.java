package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final String ERROR_NOT_SIX = "[ERROR] 로또 번호의 개수가 6개가 아닙니다.";
    private static final String ERROR_DISTINCT = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
    private static final String ERROR_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_NOT_SIX);
        }
        if (numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ERROR_DISTINCT);
        }
        if (numbers.stream().anyMatch(number -> number < 1|| number > 45)){
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    List<Integer> getNumbers(){
        return this.numbers;
    }

}
