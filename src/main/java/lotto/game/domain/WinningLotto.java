package lotto.game.domain;

import static java.util.stream.Collectors.*;
import static lotto.game.ExceptionConst.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WinningLotto extends Lotto {
    private static final Pattern lottoPattern = Pattern.compile("^([1-9]\\d?,){5}[1-9]\\d?$");
    private static final Pattern bonusNumberPattern = Pattern.compile("^[1-9]\\d?$");

    private final Integer bonusNumber;

    private WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validateDuplicate(numbers, bonusNumber);
        validateLottoNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_MESSAGE);
        }
    }

    public static WinningLotto of(String numbersInput, String bonusNumberInput) {
        if (!lottoPattern.matcher(numbersInput).matches()) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBER_MESSAGE);
        }
        List<Integer> numbers = parseStringNumbers(numbersInput);
        Integer bonusNumber = parseStringBonusNumber(bonusNumberInput);
        return new WinningLotto(numbers, bonusNumber);
    }

    private static List<Integer> parseStringNumbers(String numbersInput) {
        return Arrays.stream(numbersInput.split(","))
                .map(Integer::parseInt)
                .collect(toList());
    }

    private static Integer parseStringBonusNumber(String bonusNumber) {
        if (!bonusNumberPattern.matcher(bonusNumber).matches()) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBER_MESSAGE);
        }
        return Integer.parseInt(bonusNumber);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
