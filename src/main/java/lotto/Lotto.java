package lotto;

import java.util.Collections;
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
    public void sortElements() {
        Collections.sort(this.numbers);
    }

    public void printElements() {
        System.out.print("[");
        for(int i=0; i<5; i++)
            System.out.print(this.numbers.get(i) + ", ");
        System.out.println(this.numbers.get(5) + "]");
    }
}
