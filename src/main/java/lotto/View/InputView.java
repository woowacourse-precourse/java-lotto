package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String InputPurchasing() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchasingAmount = Console.readLine();

        return purchasingAmount;
    }

    public String InputWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
        String winningNumber = Console.readLine();

        return winningNumber;
    }
}
