package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicatedNumber(numbers);
        checkRangeOverNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicatedNumber(List<Integer> numbers){
        Set<Integer> checkDuplicate = new HashSet<Integer>(numbers);

        if(checkDuplicate.size() < numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    private void checkRangeOverNumber(List<Integer> numbers){

        for(int i = 0 ; i < numbers.size(); i++){
            int checkNumber = numbers.get(i);

            if(checkNumber > 0 || 45 < checkNumber){
                throw new IllegalArgumentException();
            }
        }

    }
    // TODO: 추가 기능 구현
}
