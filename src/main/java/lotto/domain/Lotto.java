package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicate(numbers);
        checkRange(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해 주세요.");
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 6개의 숫자를 입력해 주세요.");
        }
    }

    private void checkRange(List<Integer> numbers) {
        List<Integer> outRangeList = numbers.stream().filter(n -> 1 > n || n > 45)
                .collect(Collectors.toList());
        if(outRangeList.size() > 0) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해 주세요.");
        }
    }
}
