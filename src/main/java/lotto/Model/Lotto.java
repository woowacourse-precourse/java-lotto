package lotto.Model;

import static lotto.Model.Error.Dup_bonus;

import static lotto.Validator.checkDuplication;
import static lotto.Validator.checkRange;
import static lotto.Validator.checkSize;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Lotto {
    private static final String DIVIDE_POINT = ",";
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public Lotto(final String firstPlace) {
        validate(firstPlace);
        this.numbers = Arrays.stream(firstPlace.split(DIVIDE_POINT)).map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    private void validate(final List<Integer> numbers) {
        checkSize(numbers);
        validateCommon(numbers);
    }

    private void validate(final String firstPlace) {
        List<Integer> firstPlaceNumbers = Arrays.stream(firstPlace.split(DIVIDE_POINT)).map(Integer::parseInt)
                .collect(Collectors.toList());
        validateCommon(firstPlaceNumbers);
    }

    private void validateCommon(final List<Integer> numbers) {
        checkDuplication(numbers);
        checkRange(numbers);
    }

    public void dupCheckBonusNumber(final String bonus) {
        if (this.numbers.contains(Integer.parseInt(bonus))) {
            throw new IllegalArgumentException(Error.getErrorMessage(Dup_bonus) + this.numbers);
        }
    }

    public Rank calLotto(final List<Integer> numbers) {
        int matchPoint = (int) numbers.stream().filter(this.numbers::contains).count();
        return Rank.find(String.valueOf(matchPoint));
    }

    public Rank CompareNbr(final Winning lottoResult) {
        return lottoResult.calculateMatch(this.numbers);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return this.numbers.stream().sorted()
                .collect(Collectors.toList())
                .toString();
    }
}
