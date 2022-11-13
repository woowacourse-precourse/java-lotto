package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void sort(){
        Collections.sort(this.numbers);
    }

    public void print_lotto(){
        System.out.println(this.numbers);
    }


    private int get_lotto_number(List<Integer> numbers, int i){
        return numbers.get(i);
    }

    // TODO: 추가 기능 구현
}
