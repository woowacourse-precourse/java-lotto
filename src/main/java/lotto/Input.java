package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    String purchaseAmount;
    String winningNumbers;
    String bonusNumber;

    public String lottoPurchaseAmount() {

        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = Console.readLine();

        return purchaseAmount;
    }

    public String lottoWinningNumbers() {

        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbers = Console.readLine();

        return winningNumbers;
    }

    public String lottoBonusNumber() {

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Console.readLine();

        return bonusNumber;
    }
}
