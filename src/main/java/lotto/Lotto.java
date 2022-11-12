package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<Integer> list){
        Set<Integer> numSet = new HashSet<>(list);
        //중복이 있음
        if(numSet.size()!=list.size()){
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현

}
