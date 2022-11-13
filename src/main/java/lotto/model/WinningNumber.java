package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumber(String winningNumberStr, String bonusNumberStr) {
        winningNumbers = parseWinningNumberStr(winningNumberStr);
        bonusNumber = bonusNumberStrToInt(bonusNumberStr);
    }

    private List<Integer> parseWinningNumberStr(String winningNumberStr) {
        List<Integer> newWinningNumbers = new ArrayList<>();
        String[] numbers = winningNumberStr.split(",");
        for(String number : numbers) {
            newWinningNumbers.add(Integer.parseInt(number));
        }
        return newWinningNumbers;
    }

    private int bonusNumberStrToInt(String bonusNumberStr) {
        return Integer.parseInt(bonusNumberStr);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
