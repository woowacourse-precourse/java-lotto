package lotto.exception;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validateNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validateNumber(List<Integer> numbers){
        validateNumberSize(numbers);
        validateDuplicateNumbers(numbers);
        validateNumbersRange(numbers);
    }
    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호를 사용하지 않아야 합니다.");
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (LOTTO_START_NUMBER > number || number > LOTTO_END_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
