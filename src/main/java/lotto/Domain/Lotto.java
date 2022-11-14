package lotto.Domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        overlap(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void overlap(List<Integer> numbers){
        Set<Integer> newNumList = new HashSet<>(numbers);
        if(numbers.size()!=newNumList.size())
        {
            throw new IllegalArgumentException();
        }
    }


    // TODO: 추가 기능 구현
}
