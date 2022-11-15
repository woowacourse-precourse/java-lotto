package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Integer> collect = numbers.stream().distinct().collect(Collectors.toList());
        if (collect.size()<6){
            throw new IllegalArgumentException();
        }
        for (Integer number : numbers) {
            if(number<1 || number>45){
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    // TODO: 추가 기능 구현
}
