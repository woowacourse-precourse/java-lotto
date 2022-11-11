package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int money;

    public void inputMoney(int money) {
        this.money = money;
    }

    public List<Integer> inputWinningNumber(String inputtedWinningNumber) {
        int convertedWinningNumber;
        List<Integer> winningNumber = new ArrayList<>();
        String[] unconvertedWinningNumber = inputtedWinningNumber.split(",");
        for (String unconvertedWinningNumberContent : unconvertedWinningNumber) {
            convertedWinningNumber = Integer.parseInt(unconvertedWinningNumberContent);
            winningNumber.add(convertedWinningNumber);
        }
        return winningNumber;
    }

    public int inputBonusNumber(String inputtedBonusNumber) {
        return Integer.parseInt(inputtedBonusNumber);
    }

    public int calculateEarning(int howManyWinningNumber, boolean isBonusNumberCorrect) {
        if (howManyWinningNumber==6) {
            return WinningNumberAndEarningPair.CORRECT_6.getEarning();
        } else if (howManyWinningNumber==5) {
            if (isBonusNumberCorrect) {
                return WinningNumberAndEarningPair.CORRECT_5_BONUS.getEarning();
            }
            return WinningNumberAndEarningPair.CORRECT_5.getEarning();
        } else if (howManyWinningNumber==4) {
            return WinningNumberAndEarningPair.CORRECT_4.getEarning();
        } else if (howManyWinningNumber==3) {
            return WinningNumberAndEarningPair.CORRECT_3.getEarning();
        }
        return WinningNumberAndEarningPair.CORRECT_3_UNDER.getEarning();
    }


}
