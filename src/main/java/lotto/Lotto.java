package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final static int MIN_OF_RANDOM_NUMBER =1;
    private final static int MAX_OF_RANDOM_NUMBER =45;
    private final static int COUNT_LOTTO_NUMBER=6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
        List<Integer> collect = numbers.stream().distinct().collect(Collectors.toList());
        if (collect.size()<COUNT_LOTTO_NUMBER){
            throw new IllegalArgumentException();
        }
        for (Integer number : numbers) {
            if(number<MIN_OF_RANDOM_NUMBER || number>MAX_OF_RANDOM_NUMBER){
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    // TODO: 추가 기능 구현
}
