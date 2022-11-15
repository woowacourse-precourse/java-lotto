package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        print_numbers(numbers);
    }
    public int getNumByIndex(int index){
        return this.numbers.get(index);
    }

    public void print_numbers(List<Integer> numbers){
        Collections.sort(numbers);
        System.out.println(numbers);
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
