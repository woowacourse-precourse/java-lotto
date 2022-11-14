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
    }

    public List<Integer> getNumber() {
        return this.numbers;
    }

    // TODO: 추가 기능 구현

    public void myLotto_print() {
        System.out.print("\"[" + this.numbers.get(0));
        for (int i = 1; i < this.numbers.size(); i++) {
            System.out.print(", "+this.numbers.get(i));
        }
        System.out.println("]\",");
    }
}
