package lotto.domain.model;

import static lotto.domain.model.ErrorMessage.BONUS_NUMBER_DUPLICATION;
import static lotto.domain.model.ErrorMessage.COMMON_MESSAGE;
import static lotto.utils.Advice.LottoValidator.checkConsistOfOnlyCommas;
import static lotto.utils.Advice.LottoValidator.checkDuplication;
import static lotto.utils.Advice.LottoValidator.checkRange;
import static lotto.utils.Advice.LottoValidator.checkSize;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final String DIVIDE_POINT = ",";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public Lotto(String firstPlace) {
        validate(firstPlace);
        this.numbers = Arrays.stream(firstPlace.split(DIVIDE_POINT)).map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        validateCommon(numbers);
    }

    private void validate(String firstPlace) {
        checkConsistOfOnlyCommas(firstPlace);
        List<Integer> firstPlaceNumbers = Arrays.stream(firstPlace.split(DIVIDE_POINT)).map(Integer::parseInt)
                .collect(Collectors.toList());
        validateCommon(firstPlaceNumbers);
    }

    private void validateCommon(List<Integer> numbers) {
        checkDuplication(numbers);
        checkRange(numbers);
    }

    public void duplicateCheckBonusNumber(String bonus) {
        if (this.numbers.contains(Integer.parseInt(bonus))) {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + BONUS_NUMBER_DUPLICATION.getMessage());
        }
    }

    public LottoRank calculateMatch(List<Integer> numbers) {
        int matchPoint = (int) numbers.stream().filter(this.numbers::contains).count();
        return LottoRank.find(String.valueOf(matchPoint));
    }

    public LottoRank compareLottoNumber(WinningLotto winningLotto) {
        return winningLotto.calculateMatch(this.numbers);
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
