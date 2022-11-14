package lotto.domain;

import static lotto.utils.Constant.LOTTO_MAXIMUM;
import static lotto.utils.Constant.LOTTO_MINIMUM;
import static lotto.utils.Constant.LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;



public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateFittingInRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public List<Integer> sortNumbers() {
        return this.numbers
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자로 이루어져야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> duplicationChecker = new HashSet<>(numbers);

        if (duplicationChecker.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 입력되었습니다");
        }
    }

    private void validateFittingInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_MINIMUM || number > LOTTO_MAXIMUM) {
                throw new IllegalArgumentException("[ERROR] 1에서 45사이 숫자만 허용됩니다.");
            }
        }
    }
}
