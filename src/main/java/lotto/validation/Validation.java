package lotto.validation;

import java.util.HashSet;
import java.util.List;

public final class Validation {
    public static void validateNumberInRange(int number, int startInclusive, int endInclusive){
        if(number<startInclusive || number>endInclusive){
            throw new IllegalArgumentException();
        }
    }
}
