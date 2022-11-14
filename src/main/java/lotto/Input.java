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

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine();
        int bonusNumber = Integer.valueOf(bonusNumberInput);
        return bonusNumber;
    }
}
