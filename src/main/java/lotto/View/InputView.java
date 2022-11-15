package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Service.InputValidator;

public class InputView {

    InputValidator inputValidator = new InputValidator();
    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public int readMoney() {
        System.out.println(PURCHASE_MESSAGE);

        String input = Console.readLine();

        inputValidator.validateMoney(input);

        int money = Integer.parseInt(input);

        return money;
    }

    public String readWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);

        String input = Console.readLine();

        inputValidator.validateNumbers(input);

        return input;
    }

    public int readBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);

        String input = Console.readLine();

        int num = inputValidator.returnValidatedSingleNumber(input);

        return num;
    }
}
