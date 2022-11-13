package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        checkDuplicate(numbers);
       // orderLotto(numbers);
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
/*
    private void orderLotto(List<Integer> numbers){
        Collections.sort(numbers);
    }
*/
    public List<Integer> getLotto(){
        return numbers;
    }
}
