package lotto.app;

import java.util.List;
import java.util.stream.Collectors;

public class Validation {
    public boolean hasSixItems(List<Integer> numbers){
        if(numbers.size() != 6)
            return false;
        return true;
    }

    public boolean isInRange(List<Integer> numbers){
        for(int i = 0; i < 6; i++){
            if( 1 > numbers.get(i) || numbers.get(i) > 45){
                return false;
            }
        }
        return true;
    }

    public boolean isNotDuplicate(List<Integer> numbers){
        for(int i = 0; i < 6; i++){
            List<Integer> number = numbers.stream()
                    .filter(numbers.get(i)::equals)
                    .collect(Collectors.toList());
            if(number.size() != 1)
                return false;
        }
        return true;
    }

    public boolean isThousandUnit(int money){
        if(money % 1000 != 0)
            return false;
        return true;
    }
}
