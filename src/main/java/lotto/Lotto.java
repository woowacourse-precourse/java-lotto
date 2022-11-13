package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 6개여야 합니다.");
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
		if(numbers.size() != numbers.stream().distinct().count()) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
		}
	}
}
