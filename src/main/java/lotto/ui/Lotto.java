package lotto.ui;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        rangeValid(numbers);
        blockDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers)throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또의 수는 6개까지만 허용한다.");
        }
    }

    // TODO: 추가 기능 구현
    private void rangeValid(List<Integer> numbers){
        for (int i=0;i<6;i++){
            if (1>numbers.get(i) || numbers.get(i)>45){
                throw new IllegalArgumentException("1~45 사이의 수를 입력해주세요!");
            }
        }
    }

    private void blockDuplication(List<Integer> numbers){
        // Set 으로 변환
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size()!= numbers.size()){
            throw new IllegalArgumentException("중복된 요소가 있습니다!");
        }
    }


}
