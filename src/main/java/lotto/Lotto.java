package lotto;

import java.util.ArrayList;
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
        checkDuplicatedNumber(numbers);
    }

    // TODO: 추가 기능 구현

    private void checkDuplicatedNumber(List<Integer> numbers) {
        ArrayList<Integer> ll = new ArrayList<>();
        numbers.forEach(number -> {
            if(ll.contains(number))
                throw new IllegalArgumentException();
            ll.add(number);
        });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
