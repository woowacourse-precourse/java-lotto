package lotto;

import lotto.exception.OverlapsNumberException;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlaps(numbers);
        this.numbers = numbers;
    }// Lotto

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        } // if
    }//validate

    private void validateOverlaps(List<Integer> numbers){
        String[] putWinningNumber= numbers.toString().substring(1,numbers.toString().length()-1).split(",");
        OverlapsNumberException.overlapsCheck(putWinningNumber);
    }//validateOverlaps

    public List<Integer> getLottoNumbers() {
        return numbers;
    }//getLottoNumbers


}// end class
