package lotto.domain;

import lotto.Validation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumber {
    public final List<Integer> winningNumbers;
    public final int bonusNumber;

    public LottoNumber(String inputWinning, String inputBonus) {
        List<Integer> winningNumbers = convertStringToInteger(inputWinning);
        Validation.validLotto(winningNumbers);
        validBonusNumber(inputBonus);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = Integer.parseInt(inputBonus);
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
