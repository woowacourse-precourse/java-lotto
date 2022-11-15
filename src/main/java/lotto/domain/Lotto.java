package lotto.domain;

import static lotto.constant.LottoGameRule.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoGameRule.LOTTO_MIN_NUMBER;
import static lotto.constant.LottoGameRule.LOTTO_NUMBER_SIZE;
import static lotto.utils.ErrorMessage.DUPLICATE_NUMBER_ERROR;
import static lotto.utils.ErrorMessage.NUMBER_SIZE_ERROR;
import static lotto.utils.ErrorMessage.OUT_OF_RANGE_NUMBER_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isSizeSix(numbers);
        isInRange(numbers);
        isDuplicate(numbers);
    }

    private void isSizeSix(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR.toString());
        }
    }

    private void isInRange(List<Integer> lottoNumbers) {
        for (int number : lottoNumbers) {
            if (!(number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER)) {
                throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_ERROR.toString());
            }
        }
    }

    private void isDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> lottoNumber = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() != lottoNumber.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR.toString());
        }
    }

    public boolean isContainBonusNumber(int number) {
        return this.numbers.contains(number);
    }

    public int compare(List<Integer> lottoNumbers) {
        return (int) numbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}