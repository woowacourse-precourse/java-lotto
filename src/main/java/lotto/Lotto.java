package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers ;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]올바른 당첨금액을 입력해주세요.");
        }
        Set<Integer> duplicateCheckSet = new HashSet<>(numbers);
        if (duplicateCheckSet.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR]올바른 당첨금액을 입력해주세요.");
        }
        System.out.println(numbers);
    }
}
