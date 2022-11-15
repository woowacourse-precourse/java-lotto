package lotto.object;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    public Integer getNumber(Integer index) {
        return numbers.get(index);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        sizeValidate(numbers);
        duplicationValidate(numbers);
        rangeValidate(numbers);
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 6개여야 합니다.");
        }
    }

    private void duplicationValidate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);

        if (set.size() < 6) {
            throw new IllegalArgumentException("로또 숫자 중복이 없어야 합니다.");
        }
    }

    private void rangeValidate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 숫자는 1~45 내의 수여야 합니다.");
            }
        }
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
