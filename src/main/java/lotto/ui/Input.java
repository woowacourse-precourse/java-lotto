package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseMoneyInput = Console.readLine();
        int purchaseMoney = 0;

        try {
            purchaseMoney = Integer.valueOf(purchaseMoneyInput);
        } catch (Exception notOnlyNumber) { // 에러 발생 시 에러 전파
            System.out.println("[ERROR] 정수를 입력하세요");
        }

        int purchaseAmount = purchaseMoney / 1000;

        return purchaseAmount;
    }

    public List getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumberInput = Console.readLine();
        Validator.checkWinningNumberInputForm(winningNumberInput);

        String[] splittedInput = winningNumberInput.split(","); // 입력 받은 문자열을 ','을 기준으로 split
        List<Integer> winningNumber = new ArrayList<Integer>();
        for(int order=0; order<splittedInput.length; order++) {
            winningNumber.add(Integer.valueOf(splittedInput[order]));
        }
        Validator.checkLottoNumbers(winningNumber); // 입력 값 검증

        return winningNumber;
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine();
        int bonusNumber = Integer.valueOf(bonusNumberInput); // str to int
        return bonusNumber;
    }
}
