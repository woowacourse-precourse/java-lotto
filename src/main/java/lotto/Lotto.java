package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        // 로또 번호 정렬
        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Integer::compareTo);
    }

    private void validate(List<Integer> numbers) {
        // 번호가 6개인지 확인
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }

        // 중복 번호가 있는지 확인
        Set<Integer> checkSet = new HashSet<>(numbers);

        if(numbers.size() != checkSet.size())
            throw new IllegalArgumentException();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        String value = "";
        for (Integer n : numbers)
            value += n + ", ";
        value = value.substring(0, value.length()-2);
        return value;
    }
}
