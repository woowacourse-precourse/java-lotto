package lotto;

import static lotto.Constant.*;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 입력해주세요.");
        }
        isDuplicated(numbers);
        isNumbersInRange(numbers);
    }

    // TODO: 추가 기능 구현
    public void isDuplicated(List<Integer> numbers) {
        List<Integer> uniqueNumbers = numbers.stream()
                                             .distinct()
                                             .collect(Collectors.toList());

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자들을 입력해주세요.");
        }
    }

    public void isNumbersInRange(List<Integer> targetNumbers) {
        for(Integer item : targetNumbers) {
            if (item < 1 || item > 45) {
                throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해주세요.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
