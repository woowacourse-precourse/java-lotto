package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        Collections.sort(this.numbers);
        print(this.numbers);
    }

    private void print(List<Integer> numbers) { System.out.println(numbers); }
}