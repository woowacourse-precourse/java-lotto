package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoException {

    private static final int NUMBERS_LENGTH = 6;

    public LottoException(){}

    public void validate(List<Integer> numbers){

    }

    private boolean isNotRightLength(List<Integer> numbers){
        return numbers.size() != NUMBERS_LENGTH;
    }

    private boolean containsSameNumber(List<Integer> numbers){
        return new HashSet<>(numbers).size() != numbers.size();
    }

    private boolean containsNumberOutOfRange(List<Integer> numbers){
        return true;
    }

    private void notRightNumberException(){}
}
