package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Service.InputValidator;

public class InputView {

    InputValidator inputValidator = new InputValidator();

    public int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        String input = Console.readLine();

        inputValidator.validateMoney(input);

        int money = Integer.parseInt(input);

        return money;
    }

    public String readWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String input = Console.readLine();

        inputValidator.validateNumbers(input);

        return input;
    }

    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        String input = Console.readLine();

        int num = inputValidator.returnValidatedSingleNumber(input);

        return num;
    }
}
