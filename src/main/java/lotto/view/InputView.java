package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static List<String> revertInputToList(String winningNumberInput) {
        String[] winningNumberArray = winningNumberInput.split(",");
        List<String> winningNumberList = Arrays.asList(winningNumberArray);
        return winningNumberList;
    }



}
