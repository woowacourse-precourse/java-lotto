package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    public int getPurchaseAmount() {
        String purchaseAmountInput = Console.readLine();
        int purchaseAmount = Integer.valueOf(purchaseAmountInput);
        return purchaseAmount;
    }

    public List getWinningNumber() {
        String winningNumberInput = Console.readLine();
        String[] splittedInput = winningNumberInput.split(",");
        List<Integer> winningNumber = new ArrayList<Integer>();

        for(int order=0; order<splittedInput.length; order++) {
            winningNumber.add(Integer.valueOf(splittedInput[order]));
        }

        return winningNumber;
    }
}
