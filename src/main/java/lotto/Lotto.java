package lotto;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Lotto {
    private static final String ERROR_COUNT = "[ERROR] 로또번호 갯수를 확인해주세요.";
    private static final String ERROR_DUPLICATE = "[ERROR] 중복숫자가 포함되었습니다.";
    private static final String ERROR_WRONGNUMBER = "[ERROR] 잘못된 로또번호가 포함되었습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateCorrectRange(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_COUNT);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numset = new HashSet<>(numbers);

        if (numbers.size() != numset.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    private void validateCorrectRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ERROR_WRONGNUMBER);
            }
        }
    }
}
