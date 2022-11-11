package lotto.domain;

import lotto.constant.Rank;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private ValidationInDomain validator = new ValidationInDomain();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validator.checkDuplicatedNumber(numbers);
        this.numbers = numbers;
        sortInAscendingOrder();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers(){
        return numbers;
    }

    private void sortInAscendingOrder(){
        Collections.sort(numbers);
    }

    public int calculateCountOfMatchingNumbers(List<Integer> winningNumbers){
        int count = 0;
        for(int i = 0; i < winningNumbers.size(); i++){
            if(numbers.contains(winningNumbers.get(i))){
                count++;
            }
        }
        return count;
    }

    public boolean contains(int number){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.contains(number)){
                return true;
            }
        }
        return false;
    }
}
