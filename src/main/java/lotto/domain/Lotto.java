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

    public boolean contains(int number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }

    public int matchCount(Lotto other) {
        int count = 0;

        for (int i=0; i<numbers.size(); i++) {
            if (contains(other.numbers.get(i))) {
                count++;
            }
        }

        return count;
    }
}
