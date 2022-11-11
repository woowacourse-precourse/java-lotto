package lotto.exception;

import java.util.HashSet;
import java.util.List;

public class LottoException {

    private static final int NUMBERS_LENGTH = 6;
    private static final int MINIMUM_NUMBER_IN_RANGE = 1;
    private static final int MAXIMUM_NUMBER_IN_RANGE = 45;
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 5;

    public LottoException(){}

    public void validate(List<Integer> numbers){

    }

    private boolean isNotRightLength(List<Integer> numbers){
        return numbers.size() != NUMBERS_LENGTH;
    }

    private boolean containsSameNumber(List<Integer> numbers){
        return new HashSet<>(numbers).size() != NUMBERS_LENGTH;
    }

    private boolean containsNumberOutOfRange(List<Integer> numbers){
        return numbers.get(FIRST_INDEX) < MINIMUM_NUMBER_IN_RANGE || numbers.get(LAST_INDEX) > MAXIMUM_NUMBER_IN_RANGE;
    }

    private void notRightNumberException(){}
}
