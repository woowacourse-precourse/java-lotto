package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void getNumbers() {
        String result = "[";
        for (int idx = 0; idx < this.numbers.size(); idx++) {
            result += this.numbers.get(idx);
            if (idx != this.numbers.size()-1) {
                result += ", ";
            }
        }
        result += "]";
        System.out.println(result);
    }
}
