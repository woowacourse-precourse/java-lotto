package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) { 
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자여야 합니다.");
        }
        for (Integer number : numbers) {
            if (1 > number || 45 < number) {
                throw new IllegalArgumentException("당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
            }
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("당첨 번는 서로다른 6개 숫자여야 합니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }
}
