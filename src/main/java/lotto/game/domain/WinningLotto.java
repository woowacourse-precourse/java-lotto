package lotto.game.domain;

import static lotto.game.ExceptionHandler.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final Pattern lottoPattern = Pattern.compile("^([1-9]\\d?,){5}[1-9]\\d?$");
    private static final Pattern bonusNumberPattern = Pattern.compile("^[1-9]\\d?$");

    private final Lotto lotto;
    private final Integer bonusNumber;

    private WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        validateDuplicate(numbers, bonusNumber);
        for (Integer number : numbers) {
            validateLottoNumber(number);
        }
        validateLottoNumber(bonusNumber);
        this.lotto = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(String numbersInput, String bonusNumberInput) {
        if (!lottoPattern.matcher(numbersInput).matches()) {
            throwException(ILLEGAL_LOTTO_NUMBER_MESSAGE);
        }
        List<Integer> numbers = Arrays.stream(numbersInput.split(","))
                .sequential()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Integer bonusNumber = convertInputToBonusNumber(bonusNumberInput);
        return new WinningLotto(numbers, bonusNumber);
    }

    public void validateDuplicate(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throwException(BONUS_NUMBER_DUPLICATE_MESSAGE);
        }
    }

    private static void validateLottoNumber(Integer number) {
        if (number >= 1 && number <= 45) {
            return;
        }
        throwException(ILLEGAL_LOTTO_NUMBER_MESSAGE);
    }

    private static Integer convertInputToBonusNumber(String bonusNumber) {
        if (!bonusNumberPattern.matcher(bonusNumber).matches()) {
            throwException(ILLEGAL_LOTTO_NUMBER_MESSAGE);
        }
        return Integer.parseInt(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WinningLotto)) {
            return false;
        }
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNumber);
    }
}
