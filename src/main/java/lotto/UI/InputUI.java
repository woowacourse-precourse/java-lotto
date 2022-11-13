package lotto.UI;

import camp.nextstep.edu.missionutils.Console;

public class InputUI {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해주세요.";
    private static final String NORMAL_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    Validator validator = new Validator();
    OutputUI outputUI = new OutputUI();

    public InputUI() {

    }

    public int getMoney() {
        outputUI.printMessage(MONEY_INPUT_MESSAGE);
        String money = Console.readLine();
        validator.validateMoney(money);
        return Integer.parseInt(money);
    }

    public String getNormalNumbers() {
        outputUI.printMessage(NORMAL_NUMBER_INPUT_MESSAGE);
        String normalNumbers = Console.readLine();
        validator.validateNormalNumbers(normalNumbers);
        return normalNumbers;
    }

    public String getBonusNumbers() {
        outputUI.printMessage(BONUS_NUMBER_INPUT_MESSAGE);
        String bonusNumber = Console.readLine();
        validator.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }
}
