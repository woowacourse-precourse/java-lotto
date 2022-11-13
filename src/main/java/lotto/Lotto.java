package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicate = new HashSet<>(numbers);

        if (numbers.size() != checkDuplicate.size() ) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 중 중복 숫자가 존재합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(int i=0;i<numbers.size();i++){
            if(numbers.get(i)<1 || numbers.get(i)>45){
                throw new IllegalArgumentException("[ERROR] 범위를 초과한 숫자가 존재합니다.");
            }
        }
    }


}
