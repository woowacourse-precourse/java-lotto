package lotto.domain;

import lotto.config.InputConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        InputConfig.checkPrizeLotto(numbers);
    }

    @Override
    public String toString() {
        List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
        return sorted.toString();
    }

    public boolean contains(int prizeBonusNumber) {
        return numbers.contains(prizeBonusNumber);
    }

    public Set<Integer> toSet() {
        return new HashSet<>(numbers);
    }

}
