package lotto;

import static lotto.constant.Rules.NUMBER_LENGTH;

import java.util.Arrays;
import java.util.List;
import lotto.exception.NotDistinctException;
import lotto.exception.WrongLengthException;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != NUMBER_LENGTH) {
            throw new WrongLengthException();
        }
        if (!verifyDistinct(numbers)) {
            throw new NotDistinctException();
        }
    }

    private boolean verifyDistinct(List<LottoNumber> numbers) {
        return numbers.stream().map(LottoNumber::getNumber).distinct().count()
                == numbers.size();
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
