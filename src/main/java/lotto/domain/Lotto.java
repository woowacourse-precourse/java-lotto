package lotto.domain;

import java.util.Collections;
import java.util.List;

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

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void sortInAscendingOrder(){
        Collections.sort(numbers);
    }

    public String compareNumbersWith(List<Integer> winningNumbers, int bonusNumber){
        int count = calculateCountOfMatchingNumbers(winningNumbers);
        String winningData = count + "개 일치";
        if(count == 5 && contains(bonusNumber)){
            winningData += " 보너스 볼 일치";
        }
        return winningData;
    }

    private int calculateCountOfMatchingNumbers(List<Integer> winningNumbers){
        int count = 0;
        for(int i = 0; i < winningNumbers.size(); i++){
            if(numbers.contains(winningNumbers.get(i))){
                count++;
            }
        }
        return count;
    }

    private boolean contains(int number){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.contains(number)){
                return true;
            }
        }
        return false;
    }
}
