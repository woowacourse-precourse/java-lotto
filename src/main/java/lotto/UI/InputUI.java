package lotto.UI;

import camp.nextstep.edu.missionutils.Console;

public class InputUI {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해주세요.";
    private static final String NORMAL_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    Validator validator = new Validator();

    public InputUI() {

    }

    public int getMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        String money = Console.readLine();
        validator.isValidatedMoney(money);
        return Integer.parseInt(money);
    }

    public void getWinningNumbers() {
        getNormalNumbers();
        getBonusNumbers();
    }

    private String getNormalNumbers() {
        System.out.println(NORMAL_NUMBER_INPUT_MESSAGE);
        String normalNumbers = Console.readLine();
        validator.isValidatedNormalNumbers(normalNumbers);
        return normalNumbers;
    }

    private String getBonusNumbers() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String bonusNumber = Console.readLine();
        validator.isValidatedBonusNumber(bonusNumber);
        return bonusNumber;
    }
}
