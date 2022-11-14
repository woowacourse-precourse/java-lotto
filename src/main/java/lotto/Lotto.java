package lotto;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.type.LottoCondition.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumberBound(numbers);
    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != BOUND_SIZE.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 중복되지 않는 6개 숫자이어야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 중복되지 않는 6개 숫자이어야 합니다.");
        }
    }

    private void validateNumberBound(List<Integer> numbers) throws IllegalArgumentException {
        if (!numbers.stream().allMatch(number -> (BOUND_START.getNumber() <= number) && (number <= BOUND_END.getNumber()))) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1-45의 숫자이어야 합니다.");
        }
    }

    public int compare(Lotto compareLotto) {
        return (int) IntStream.range(0, numbers.size())
                .filter(i -> numbers.contains(compareLotto.numbers.get(i))).count();
    }

    public boolean hasBonusNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return "" + numbers;
    }
}
