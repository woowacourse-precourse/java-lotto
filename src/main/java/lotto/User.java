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



}
