package lotto.datamodel;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        reduplication(numbers);
        range(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력값으로 6개를 입력해야 합니다.");
        }
    }
    private void reduplication(List<Integer> numbers){
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 말아야 합니다.");
        }
    }

    private void range(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number >= 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
