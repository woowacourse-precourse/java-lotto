package util.input.lotto;

import static lotto.Message.INPUT_BONUS_NUMBER;
import static util.input.global.InputUtil.getInput;

import lotto.Lotto;
import validation.Validator;

public class BonusNumberInputUtil {
    public static int getBonusNumber(Lotto winningNumbers) {
        printMessage();

        String bonusNumber = getInput();

        validate(bonusNumber, winningNumbers);

        return Integer.parseInt(bonusNumber);
    }

    private static void printMessage() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
    }

    private static void validate(String bonusNumber, Lotto winningNumbers) {
        Validator validator = new Validator();

        validator.validateBonusNumber(bonusNumber, winningNumbers);
    }
}
