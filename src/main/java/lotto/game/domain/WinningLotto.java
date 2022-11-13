package lotto.game.domain;

import static lotto.game.ExceptionConst.*;

import java.util.Arrays;
import java.util.List;
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

    private void validateDuplicate(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_MESSAGE);
        }
    }

    private void validateLottoNumber(Integer number) {
        if (number >= 1 && number <= 45) {
            return;
        }
        throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBER_MESSAGE);
    }

    public static WinningLotto of(String numbersInput, String bonusNumberInput) {
        if (!lottoPattern.matcher(numbersInput).matches()) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBER_MESSAGE);
        }
        List<Integer> numbers = Arrays.stream(numbersInput.split(","))
                .sequential()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Integer bonusNumber = convertInputToBonusNumber(bonusNumberInput);
        return new WinningLotto(numbers, bonusNumber);
    }

    private static Integer convertInputToBonusNumber(String bonusNumber) {
        if (!bonusNumberPattern.matcher(bonusNumber).matches()) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBER_MESSAGE);
        }
        return Integer.parseInt(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
