package lotto.domain.model;

import static lotto.utils.Advice.LottoValidator.checkDuplication;
import static lotto.utils.Advice.LottoValidator.checkRange;
import static lotto.utils.Advice.LottoValidator.checkSize;
import static lotto.utils.Advice.LottoValidator.checkSortedAsc;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private static void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplication(numbers);
        checkRange(numbers);
        checkSortedAsc(numbers);
    }

    public LottoRank compareLottoNumber(LottoNumber lottoNumber) {
        return lottoNumber.calculateMatch(this.numbers);
    }
}
