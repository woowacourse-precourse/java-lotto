package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseMoneyInput = Console.readLine();

        // TODO: 숫자가 아닌 입력이 들어왔을 때의 예외 처리
        int purchaseMoney = Integer.valueOf(purchaseMoneyInput);
        Validator.checkPurchaseMoney(purchaseMoney);
        int purchaseAmount = purchaseMoney / 1000;

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
