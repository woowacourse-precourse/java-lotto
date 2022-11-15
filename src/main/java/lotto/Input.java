package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseMoneyInput = Console.readLine();
        int purchaseMoney = Integer.valueOf(purchaseMoneyInput);
        int purchaseAmount = purchaseMoney / 1000;
        // TODO: 1000으로 나누어 떨어지지 않을 때의 예외 처리
        return purchaseAmount;
    }

    public List getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
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
