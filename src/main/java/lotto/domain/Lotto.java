package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 갯수가 6개가 아닙니다.");
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 번호가 존재합니다.");
        }
    }

    public int compare(List<Integer> winNumber) {
        int count = 0;

        for (Integer num : numbers) {
            if (winNumber.contains(num)) {
                count++;
            }
        }

        return count;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        String str = "[";

        for (int idx = 0; idx < numbers.size(); idx++) {
            str += numbers.get(idx);
            if (idx != numbers.size() - 1) {
                str += ", ";
            }
        }

        return str + "]";
    }
}
