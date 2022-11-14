package lotto.domain;

import static lotto.constant.LottoConstant.END_INCLUSIVE;
import static lotto.constant.LottoConstant.LOTTO_BONUS_NUMBER_COUNT;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.START_INCLUSIVE;
import static lotto.exception.ErrorResponse.BAD_BONUS_LOTTO_NUMBER;
import static lotto.exception.ErrorResponse.BAD_LENGTH_LOTTO_NUMBERS;
import static lotto.exception.ErrorResponse.BAD_RANGE_LOTTO_NUMBERS;
import static lotto.exception.ErrorResponse.DUPLICATED_LOTTO_NUMBER;

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

        validateAnswerNumbers(numbers);

        Set<Integer> numberSet = new HashSet<>(numbers);
        if (hasNotVerifiedNumberSet(numberSet)) {
            throw DUPLICATED_LOTTO_NUMBER.exception();
        }
    }

    private boolean hasNotVerifiedNumberSet(Set<Integer> numberSet) {
        return numberSet.size() != LOTTO_NUMBER_COUNT.getValue();
    }

    private void validateAnswerNumbers(List<Integer> numbers) {
        if (hasNotVerifiedNumberList(numbers)) {
            throw BAD_LENGTH_LOTTO_NUMBERS.exception();
        }

        for (Integer number : numbers) {
            if (isNotInLottoNumberRange(number)) {
                throw BAD_RANGE_LOTTO_NUMBERS.exception();
            }
        }
    }

    private boolean isNotInLottoNumberRange(Integer number) {
        return number < START_INCLUSIVE.getValue() || END_INCLUSIVE.getValue() < number;
    }

    private boolean hasNotVerifiedNumberList(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBER_COUNT.getValue();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    public void validateBonusNumber(Integer bonusNumber) {
        if (isNull(bonusNumber)) {
            throw BAD_BONUS_LOTTO_NUMBER.exception();
        }
        if (isNotInLottoNumberRange(bonusNumber)) {
            throw BAD_RANGE_LOTTO_NUMBERS.exception();
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        numberSet.add(bonusNumber);
        if (hasNotLottoNumbersAndBonusNumber(numberSet)) {
            throw DUPLICATED_LOTTO_NUMBER.exception();
        }
    }

    private boolean hasNotLottoNumbersAndBonusNumber(Set<Integer> numberSet) {
        return numberSet.size() != (LOTTO_NUMBER_COUNT.getValue()
            + LOTTO_BONUS_NUMBER_COUNT.getValue());
    }

    private boolean isNull(Integer bonusNumber) {
        return bonusNumber == null;
    }

    public long countSameLottoNumber(AnswerLotto answerLotto) {
        return this.getNumbers().stream()
            .filter(answerLotto::contains)
            .count();
    }

    public boolean contains(Integer number) {
        return this.numbers.contains(number);
    }
}
