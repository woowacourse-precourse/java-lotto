package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.*;

public class Winner {
    private final Integer bonusNumber;
    private final Lotto winningNumbers;

    public Winner(List<Integer> winningNumbers, Integer bonusNumber) {
        checkIfBonusNumberIncludedInWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
        Validator.checkRange(this.bonusNumber);
    }

    public static List<Integer> convert(String[] numbers) {
        List<Integer> validNumbers = new ArrayList<>();
        for (String number : numbers) {
            Validator.checkIfNumeric(number);
            Integer numericValue = Integer.valueOf(number);
            validNumbers.add(numericValue);
        }
        return validNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getLottoNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void checkIfBonusNumberIncludedInWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_TITLE + DUPLICATE_NUMBERS);
        }
    }
}
