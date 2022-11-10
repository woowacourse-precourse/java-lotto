package lotto.app;

import java.util.List;

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
}
