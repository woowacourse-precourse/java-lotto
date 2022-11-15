package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
        numbers.sort(Comparator.naturalOrder());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.addAll(numbers);
        return lottoNumber;
    }

    static void duplicate(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> duplicationCheck = new HashSet<>(numbers);
        if (duplicationCheck.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 내에 중복이 있습니다.");
        }
    }
}
