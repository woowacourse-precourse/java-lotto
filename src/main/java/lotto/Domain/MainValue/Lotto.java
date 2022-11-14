package lotto.Domain.MainValue;

import lotto.Domain.Exception.CheckException;

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
        CheckException checkException = new CheckException();
        checkException.check_LottoSize(numbers.size());

        Set<Integer> compareNum = new HashSet<>(numbers);
        checkException.check_RelativeLottoSize(numbers.size(), compareNum.size());

        for(Integer number : numbers) {
            checkException.check_OutOfRange(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
