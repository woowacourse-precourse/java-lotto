package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> list = new ArrayList<>(numbers);
        Collections.sort(list);
        this.numbers = list;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요");
        }
        
        Set<Integer> set = new HashSet(numbers);

        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복 없이 입력해 주세요");
        }
    }

    public List<Integer> getNumbers() {
        
        return numbers;
    }
}
