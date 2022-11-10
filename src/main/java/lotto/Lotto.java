package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> items = new HashSet<>();
        numbers.stream()
                .filter(n -> !items.add(n))
                .collect(Collectors.toSet());
        if (items.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(1,
                45,
                6);
    }

    public void setNumbers(List<Integer> numbers){
        this.numbers = numbers;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
