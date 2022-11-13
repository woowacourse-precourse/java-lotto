package lotto.model;

import lotto.util.Utils;
import lotto.util.validator.WinningStringValidator;

import java.util.List;

public class WinningNumbersService {
    private WinningNumbers winningNumbers;

    public WinningNumbersService(String numbers, String bonusNumber) {
        new WinningStringValidator(numbers, bonusNumber);
        this.winningNumbers = new WinningNumbers(getWinningNumbers(numbers), getWinningBonusNumber(bonusNumber));
    }

    public List<Integer> getWinningNumbers(String numbers) {
        List<Integer> numbersList = Utils.convertToList(numbers);

        return numbersList;
    }

    public int getWinningBonusNumber(String bonusNumber) {
        return Utils.convertToInt(bonusNumber);
    }
}
