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

    public void checkDuplicatedNumber(List<Integer> numbers){
        Set<Integer> validator = new HashSet<>();
        for(int i = 0; i < numbers.size(); i++){
            int number = numbers.get(i);
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

    public void checkBonusNumberDuplication(List<Integer> numbers, int bonusNumber){
        Set<Integer> validator = new HashSet<>();
        for(int i = 0; i < numbers.size(); i++){
            validator.add(numbers.get(i));
        }
        if(validator.contains(bonusNumber)){
            throw new IllegalArgumentException();
        }
    }

}
