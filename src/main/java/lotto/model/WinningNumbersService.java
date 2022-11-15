package lotto.model;

import lotto.util.Utils;

import java.util.List;

public class WinningNumbersService {
    private WinningNumbers winningNumbers;

    public WinningNumbersService(String numbers, String bonusNumber) {
        this.winningNumbers = new WinningNumbers(getWinningNumbers(numbers), getWinningBonusNumber(bonusNumber));
    }

    public List<Integer> getWinningNumbers(String numbers) {
        List<Integer> numbersList = Utils.convertToList(numbers);

        return numbersList;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public int getWinningBonusNumber(String bonusNumber) {
        return Utils.convertToInt(bonusNumber);
    }
}
