package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 6개의 숫자를 입력하시오.");
        }
    }

    public void printNumber() {
        System.out.println(numbers);
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }
}
