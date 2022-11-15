package lotto.model.Lotto;

import lotto.util.InputLottoValidator;
import lotto.util.LottoNumberFormatValidator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        InputLottoValidator.validateLottoCount(numbers);
        for (Integer number: numbers) {
            LottoNumberFormatValidator.validateLottoNumberFormat(number);
            InputLottoValidator.validateDuplicateLottoNumber(numbers, number);
        }
    }

    public Integer countWinLotto(List<Integer> ticket) {
        List<Integer> equalNumbers = ticket.stream()
                .filter(target -> numbers.stream().anyMatch(Predicate.isEqual(target)))
                .collect(Collectors.toList());

        return equalNumbers.size();
    }
}