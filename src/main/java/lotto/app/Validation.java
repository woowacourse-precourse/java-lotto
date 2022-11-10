package lotto.app;

import java.util.List;

public class Validation {
    public boolean hasSixItems(List<Integer> numbers){
        if(numbers.size() != 6)
            return false;
        return true;
    }
}
