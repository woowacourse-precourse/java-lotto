package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static String getInputPurchaseAmount() {
        String purchaseAmountInput = Console.readLine();
        return purchaseAmountInput;
    }

    public static String getInputWinningNumber() {
        String winningNumberInput = Console.readLine();
        return winningNumberInput;
    }

    public static List<Integer> revertInputToList(String winningNumberInput) {
        List<Integer> winningNumberList = new ArrayList<>();
        String[] winningNumberArray = winningNumberInput.split(",");
        for (String winningNumberStr : winningNumberArray) {
            Integer winningNumber = Integer.parseInt(winningNumberStr);
            winningNumberList.add(winningNumber);
        }
        return winningNumberList;
    }

    public static String getInputBonusNumber() {
        String bonusNumberInput = Console.readLine();
        return bonusNumberInput;
    }
}
