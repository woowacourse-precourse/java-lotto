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

    public int decideRank(List<Integer> lotto, int bonusNumber) {
        return 0;
    }


    public String toString(){
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
