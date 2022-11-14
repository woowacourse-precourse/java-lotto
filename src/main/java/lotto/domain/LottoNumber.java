package lotto.domain;

import lotto.Validation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumber {
    public final List<Integer> winningNumbers;
    public final int bonusNumber;

    public LottoNumber(String winningNumbers, String bonusNumber) {
        List<Integer> winningNumbersInteger = convertStringToInteger(winningNumbers);
        Validation.validLotto(winningNumbersInteger);
        validBonusNumber(bonusNumber);
        this.winningNumbers = winningNumbersInteger;
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validBonusNumber(String number) {
        Validation.validIsDigit(number);
        Validation.validNumberRange(Integer.parseInt(number));
    }

    private List<Integer> convertStringToInteger(String numbers) {
        return Stream.of(numbers.split(","))
                .map(num -> num.replaceAll(" ", ""))
                .filter(num -> Validation.validIsDigit(num))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
