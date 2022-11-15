package util.input.lotto;

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
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private static void validate(String bonusNumber, Lotto winningNumbers) {
        Validator validator = new Validator();

        validator.validateBonusNumber(bonusNumber, winningNumbers);
    }
}
