package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationInDomain {

    public void checkDividedByThousand(int value){
        if(value % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }

    public void checkNumbersDuplication(List<Integer> numbers) {
        Set<Integer> validator = new HashSet<>();
        for (int number : numbers){
            if(validator.contains(number)){
                throw new IllegalArgumentException();
            }
            validator.add(number);
        }
    }

    public void checkNumberRange(int number){
        if(number < 1 || number > 45){
            throw new IllegalArgumentException();
        }
    }

    public void checkNumbersRange(List<Integer> numbers){
        for(int number : numbers){
            if(number < 1 || number > 45){
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkBonusNumberDuplication(List<Integer> numbers, int bonusNumber){
        Set<Integer> validator = new HashSet<>();
        for(int i = 0; i < numbers.size(); i++){
            validator.add(numbers.get(i));
        }
        if(validator.contains(bonusNumber)){
            throw new IllegalArgumentException();
        }
    }

    public void checkNumberOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

}
