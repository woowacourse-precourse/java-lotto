package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDup(numbers);
        this.numbers = numbers;
    }

    public void play() {

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void isDup(List<Integer> numbers) {
        Set checkDup = new HashSet();
        for(int num : numbers){
            checkDup.add(num);
        }
        if(checkDup.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void printResult(int bonus) {

    }

    // TODO: 추가 기능 구현
}
