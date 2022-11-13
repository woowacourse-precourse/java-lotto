package lotto.domain;

import lotto.LottoValidation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumber {
    public final Lotto winningNumbers;
    public final int bonusNumber;

    public LottoNumber(String winningNumbers, String bonusNumber) {
        Lotto winningNumbersInteger = new Lotto(convertStringToInteger(winningNumbers));
        validBonusNumber(bonusNumber);
        this.winningNumbers = winningNumbersInteger;
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validBonusNumber(String number) {
        LottoValidation.validIsDigit(number);
        LottoValidation.validNumberRange(Integer.parseInt(number));
    }

    private List<Integer> convertStringToInteger(String numbers) {
        return Stream.of(numbers.split(","))
                .map(num -> num.replaceAll(" ", ""))
                .filter(num -> LottoValidation.validIsDigit(num))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
