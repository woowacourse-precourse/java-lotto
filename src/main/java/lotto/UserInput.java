package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public Count inputPrice() {
        System.out.println("구입 금액을 입력해주세요.");
        String userInput = Console.readLine();
        return new Count(userInput);
    }

    public WinningNumber inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return new WinningNumber(winningNumbers, bonusNumber);
    }

}
