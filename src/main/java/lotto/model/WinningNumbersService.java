package lotto.model;

import lotto.util.Utils;
import lotto.util.validator.WinningStringValidator;

import java.util.List;

public class WinningNumbersService {
    private WinningNumbers winningNumbers;

    public WinningNumbersService(String numbers) {
        new WinningStringValidator(numbers);
        this.winningNumbers = new WinningNumbers(getWinningNumbers(numbers));
    }

    public List<Integer> getWinningNumbers(String numbers) {
        List<Integer> numbersList = Utils.convertToList(numbers);

        return numbersList;
    }
}
