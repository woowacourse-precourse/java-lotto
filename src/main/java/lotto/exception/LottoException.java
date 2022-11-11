package lotto.exception;

import java.util.List;

public class LottoException {

    public LottoException(){}

    public void validate(List<Integer> numbers){

    }

    private boolean isNotRightLength(List<Integer> numbers){
        return true;
    }

    private boolean containsSameNumber(List<Integer> numbers){
        return true;
    }

    private boolean containsNumberOutOfRange(List<Integer> numbers){
        return true;
    }

    private void notRightNumberException(){}
}
