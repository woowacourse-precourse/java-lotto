package lotto.Domain;

import lotto.Input.PrintError;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException{
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        IllegalArgument illegalArgument = new IllegalArgument();
        if (numbers.size() != 6) {
            throw illegalArgument.withMessage(PrintError.NO_SIX_NUM.getMessage());
        }

        Set<Integer> compareNum = new HashSet<>(numbers);
        if(numbers.size() != compareNum.size()) {
            throw illegalArgument.withMessage(PrintError.OVERLAP.getMessage());
        }

        for(Integer number : numbers) {
            if(number<1 || 45<number) {
                throw illegalArgument.withMessage(PrintError.OUT_OF_NUMBER_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
