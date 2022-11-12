package lotto;

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

    // TODO: 추가 기능 구현
    // 당첨번호중 중복이 있을경우 예외처리
    private void overlap(List<Integer>numbers){
        Set<Integer> number = new HashSet<Integer>();
        int temp;
        for(int i =0; i < numbers.size();i++){
            temp = numbers.get(0);
            number.add(temp);
        }
        if (number.size() !=0 ){
            throw new IllegalArgumentException();
        }
    }
}
