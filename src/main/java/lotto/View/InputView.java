package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputPurchasing() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchasingAmount = Console.readLine();

        return purchasingAmount;
    }

    public String inputWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
        String winningNumber = Console.readLine();

        return winningNumber;
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

        return bonusNumber;
    }
}
