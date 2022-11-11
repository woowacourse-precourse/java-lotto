package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int money;
    private double earning = 0;
    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
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

    public void calculateEarning(int howManyWinningNumber, boolean isBonusNumberCorrect) {
        if (howManyWinningNumber==6) {
            earning+=WinningNumberAndEarningPair.CORRECT_6.getEarning();
        } else if (howManyWinningNumber==5) {
            if (isBonusNumberCorrect) {
                earning+=WinningNumberAndEarningPair.CORRECT_5_BONUS.getEarning();
            }
            earning+=WinningNumberAndEarningPair.CORRECT_5.getEarning();
        } else if (howManyWinningNumber==4) {
            earning+=WinningNumberAndEarningPair.CORRECT_4.getEarning();
        } else if (howManyWinningNumber==3) {
            earning += WinningNumberAndEarningPair.CORRECT_3.getEarning();
        }
    }

    public double calculateEarningRate() {
        double earningRate;
        earningRate = earning/money;
        return earningRate;
    }
}
